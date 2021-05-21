package com.ms.blogserver.constant.exception;

/**
 * @description: 自定义认证异常
 * @author: zhh
 * @time: 2021/5/21
 */
public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
