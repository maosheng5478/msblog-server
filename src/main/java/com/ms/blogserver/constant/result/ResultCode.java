package com.ms.blogserver.constant.result;

public enum ResultCode {

    NOT_FOUND(404),

    SUCCESS(200),

    FAIL(400),

    FORBIDDEN(403),

    //未认证
    UNAUTHORIZED(401),

    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int CODE;

    ResultCode(int CODE) {
        this.CODE = CODE;
    }
}
