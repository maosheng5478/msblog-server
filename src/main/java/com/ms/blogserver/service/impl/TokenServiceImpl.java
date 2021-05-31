package com.ms.blogserver.service.impl;

import com.ms.blogserver.converter.vo.UserVOConverter;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.entity.vo.UserVO;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.utils.RedisUtil;
import com.ms.blogserver.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/26
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String CreateToken(String username, HttpServletResponse response) {
        Long currentTimeMillis = System.currentTimeMillis();
        String token= TokenUtil.sign(username,currentTimeMillis);
        redisUtil.set(username,currentTimeMillis,TokenUtil.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return token;
    }

    @Override
    public boolean removeToken(String token) {
        String account = TokenUtil.getAccount(token);
        Long currentTime=TokenUtil.getCurrentTime(token);
        if (redisUtil.hasKey(account)) {
            Long currentTimeMillisRedis = (Long) redisUtil.get(account);
            if (currentTimeMillisRedis.equals(currentTime)) {
                redisUtil.del(account);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasLogin(String token) {
        String account = TokenUtil.getAccount(token);
        return redisUtil.hasKey(account);
    }

    @Override
    public UserVO setToken(User user,String token) {
        UserVO userVO = UserVOConverter.INSTANCE.toData(user);
        userVO.setToken(token);
        return userVO;
    }
}
