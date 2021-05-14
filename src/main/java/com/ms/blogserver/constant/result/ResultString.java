package com.ms.blogserver.constant.result;

/**
 * @description:
 * @author: z
 * @time: 2021/5/14
 */
public enum ResultString {

    /**
     * 404
     */
    PAGE_NO_FOUND("页面未找到"),

    /**
     * 401
     */
    NO_AUTHORIZED("认证错误：未完成认证"),

    /**
     * 500
     */
    INTERNAL_ERROR("服务器内部错误"),

    /**
     * 400
     */
    BAD_REQUEST("错误请求"),

    /**
     * 403
     */
    FORBIDDEN("禁止访问"),
    ;
    public String DATA;

    ResultString(String date) {
        this.DATA = date;
    }
}
