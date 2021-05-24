package com.ms.blogserver.constant.exception;

import com.ms.blogserver.constant.LoginContexts;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.constant.result.ResultString;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;

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

    /**
     * 捕获认证异常
     * @param e shiro异常
     * @param unauthorizedException 自定义认证异常
     * @return 返回code 401
     */
    @ExceptionHandler({ShiroException.class})
    @ResponseBody
    public Result handleShiroException(ShiroException e,UnauthorizedException unauthorizedException) {
        e.printStackTrace();
        unauthorizedException.printStackTrace();
        return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, ResultString.NO_AUTHORIZED.DATA);
    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public Result handleUnauthorizedException(UnauthorizedException unauthorizedException) {
        unauthorizedException.printStackTrace();
        return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, ResultString.NO_AUTHORIZED.DATA);
    }

    /**
     * 其他异常
     * @param e
     * @return 返回400
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return ResultFactory.buildFailResult(e.getMessage());
    }
}
