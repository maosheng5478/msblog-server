package com.ms.blogserver.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
