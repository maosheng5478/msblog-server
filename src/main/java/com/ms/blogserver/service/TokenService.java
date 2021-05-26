package com.ms.blogserver.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/26
 */
public interface TokenService {

    String CreateToken(String username, HttpServletResponse response);
}
