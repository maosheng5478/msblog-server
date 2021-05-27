package com.ms.blogserver.config.jwt;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ms.blogserver.constant.LoginContexts;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.constant.result.ResultString;
import com.ms.blogserver.utils.RedisUtil;
import com.ms.blogserver.utils.TokenUtil;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/24
 */

public class JWTFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 判断是否允许通过
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        System.out.println("isAccessAllowed方法");
        if (this.isLoginAttempt(request,response)) {
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                System.out.println("错误" + e);
                //throw new ShiroException(e.getMessage());
                responseError(response, "shiro fail");
                //return false;
            }
        }
        return true;
    }

    /**
     * 是否进行登录请求
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        logger.debug("isLoginAttempt方法");
        String token=((HttpServletRequest)request).getHeader("token");
        return token != null;
    }

    /**
     * 创建shiro token
     * @param request
     * @param response
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        logger.debug("createToken方法");
        String jwtToken = ((HttpServletRequest)request).getHeader("token");
        if(jwtToken!=null)
            return new JWTToken(jwtToken);

        return null;
    }

    /**
     * isAccessAllowed为false时调用，验证失败
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        logger.debug("onAccessDenied");
        this.sendChallenge(request,response);
        responseError(response,"token verify fail");
        return false;
    }



    /**
     * shiro验证成功调用
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        logger.debug("onLoginSuccess：");
        String jwttoken= (String) token.getPrincipal();
        if (jwttoken!=null){
            try{
                if(TokenUtil.verify(jwttoken)){
                    //判断Redis是否存在所对应的RefreshToken
                    String account = TokenUtil.getAccount(jwttoken);
                    Long currentTime=TokenUtil.getCurrentTime(jwttoken);
                    if (redisUtil.hasKey(account)) {
                        Long currentTimeMillisRedis = (Long) redisUtil.get(account);
                        if (currentTimeMillisRedis.equals(currentTime)) {
                            return true;
                        }
                    }
                }
                return false;
            }catch (Exception e){
                logger.error("token验证："+e.getClass());
                if (e instanceof TokenExpiredException){
                    return refreshToken(request, response);
                }
            }
        }
        return true;
    }



    /**
     * 拦截器的前置方法，此处进行跨域处理
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin",httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",httpServletRequest.getHeader("Access-Control-Resquest-Headers"));
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())){
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request,response);

    }


    /**
     * 刷新AccessToken，进行判断RefreshToken是否过期，未过期就返回新的AccessToken且继续正常访问
     * @param request
     * @param response
     * @return
     */
    private boolean refreshToken(ServletRequest request, ServletResponse response) {
        String token = ((HttpServletRequest)request).getHeader("token");
        String account = TokenUtil.getAccount(token);
        Long currentTime=TokenUtil.getCurrentTime(token);
        // 判断Redis中RefreshToken是否存在
        if (redisUtil.hasKey(account)) {
            // Redis中RefreshToken还存在，获取RefreshToken的时间戳
            Long currentTimeMillisRedis = (Long) redisUtil.get(account);
            // 获取当前AccessToken中的时间戳，与RefreshToken的时间戳对比，如果当前时间戳一致，进行AccessToken刷新
            if (currentTimeMillisRedis.equals(currentTime)) {
                // 获取当前最新时间戳
                Long currentTimeMillis =System.currentTimeMillis();
                redisUtil.set(account, currentTimeMillis,
                        TokenUtil.REFRESH_EXPIRE_TIME);
                // 刷新AccessToken，设置时间戳为当前最新时间戳
                token = TokenUtil.sign(account, currentTimeMillis);
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.setHeader("Authorization", token);
                httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
                return true;
            }
        }
        return false;
    }

    /**
     * 将非法请求跳转到 /unauthorized/**
     */
    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter out =  httpServletResponse.getWriter();
            String data = JSONObject.toJSONString(ResultFactory.buildResult(ResultCode.UNAUTHORIZED, ResultString.NO_AUTHORIZED.DATA,LoginContexts.TOKEN_ERROR));
            out.append(data);
            System.out.println("responseError:"+message);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
