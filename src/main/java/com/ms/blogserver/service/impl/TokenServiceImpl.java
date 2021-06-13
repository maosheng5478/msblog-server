package com.ms.blogserver.service.impl;

import com.ms.blogserver.config.exception.ProgramException;
import com.ms.blogserver.constant.contexts.DigitalContexts;
import com.ms.blogserver.constant.contexts.LoginContexts;
import com.ms.blogserver.constant.contexts.RedisKeyContexts;
import com.ms.blogserver.constant.contexts.VerifyContexts;
import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.converter.vo.UserVOConverter;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.vo.UserVO;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.utils.RedisUtils;
import com.ms.blogserver.utils.RegularUtils;
import com.ms.blogserver.utils.SMSVerify;
import com.ms.blogserver.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/26
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String CreateToken(String username, HttpServletResponse response) throws UnsupportedEncodingException {
        Long currentTimeMillis = System.currentTimeMillis();
        String token= TokenUtils.sign(username,currentTimeMillis);
        System.out.println(currentTimeMillis);
        redisUtils.set(username,currentTimeMillis, TokenUtils.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return token;
    }

    @Override
    public boolean removeToken(String token) {
        try {
            String account = TokenUtils.getAccount(token);
            Long currentTime= TokenUtils.getCurrentTime(token);
            if (redisUtils.hasKey(account)) {
                Long currentTimeMillisRedis;
                Object o = redisUtils.get(account);
                currentTimeMillisRedis = (Long) o;
                if (currentTimeMillisRedis.equals(currentTime)) {
                    redisUtils.del(account);
                    log.info(LoginContexts.LOGOUT_SUCCESS);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ProgramException(e.getMessage());
        }
    }

    @Override
    public boolean hasLogin(String token) {
        String account = TokenUtils.getAccount(token);
        return redisUtils.hasKey(account);
    }

    @Override
    public UserVO setToken(User user,String token) {
        UserVO userVO = UserVOConverter.INSTANCE.toData(user);
        userVO.setToken(token);
        return userVO;
    }

    @Override
    public void saveCode(Integer code) {
        redisUtils.set(RedisKeyContexts.SMS_CODE,code, DigitalContexts.ONE_MINUTES);
    }

    @Override
    public boolean getVerifyCode(Integer code) throws CustomException {
        Integer verifyCode = (Integer) redisUtils.get(RedisKeyContexts.SMS_CODE);
        if (verifyCode == null){
            throw new CustomException(VerifyContexts.VERIFY_NO_FOUND_ERROR);
        }
        return code.equals(verifyCode);
    }

    @Override
    public void sendSMS(String phone) {
        if (phone == null || !RegularUtils.isMobileExact(phone)){
            throw new CustomException(VerifyContexts.RIGHT_PHONE_NUMBER);
        }
        Integer code = SMSVerify.sendSMS(phone);
        saveCode(code);
    }
}
