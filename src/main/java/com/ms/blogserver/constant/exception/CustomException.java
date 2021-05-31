package com.ms.blogserver.constant.exception;

/**
 * @description: 自定义异常
 * @author: zhh
 * @time: 2021/5/31
 */
public class CustomException extends RuntimeException{
    public CustomException(String msg) {
        super(msg);
    }

    public CustomException() {
        super();
    }
}
