package com.ms.blogserver.result;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
