package com.ms.blogserver.service;

import com.ms.blogserver.constant.exception.CustomException;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.vo.UserVO;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/26
 */
public interface TokenService {

    String CreateToken(String username, HttpServletResponse response);

    boolean removeToken(String token);

    boolean hasLogin(String token);

    UserVO setToken(User user, String token);

    void saveCode(Integer code);

    boolean getVerifyCode(Integer code) throws CustomException;

    void sendSMS(String phone);
}
