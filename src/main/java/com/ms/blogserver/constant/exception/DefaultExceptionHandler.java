package com.ms.blogserver.constant.exception;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: z
 * @time: 2021/5/14
 */
@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return ResultFactory.buildFailResult(e.getMessage());
    }
}
