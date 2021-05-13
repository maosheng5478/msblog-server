package com.ms.blogserver.result;

public enum ResultCode {

    NOT_FOUND(404),

    SUCCESS(200),

    FAIL(400),

    //未认证
    UNAUTHORIZED(401),

    //服务器内部错误
    INTERNAL_SERVER_ERROR(505);

    public int CODE;

    ResultCode(int CODE) {
        this.CODE = CODE;
    }
}
