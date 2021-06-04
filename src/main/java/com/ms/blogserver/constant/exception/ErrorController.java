package com.ms.blogserver.constant.exception;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.constant.result.ResultString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 错误页面
 * @author: z
 * @time: 2021/5/14
 */
@RestController
@Slf4j
@RequestMapping("/err")
public class ErrorController {
    /**
     * 404页面
     */
    @RequestMapping(value = "/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result error_404() {
        log.warn(ResultCode.NOT_FOUND.CODE+":"+ResultString.PAGE_NO_FOUND.DATA);
        return ResultFactory.buildResult(ResultCode.NOT_FOUND, ResultString.PAGE_NO_FOUND.DATA);
    }

    /**
     * 500页面
     */
    @RequestMapping(value = "/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result error_500() {
        log.warn(ResultCode.INTERNAL_SERVER_ERROR.CODE+":"+ResultString.INTERNAL_ERROR.DATA);
        return ResultFactory.buildResult(ResultCode.INTERNAL_SERVER_ERROR,ResultString.INTERNAL_ERROR.DATA);
    }

    /**
     * 400页面
     */
    @RequestMapping(value = "/400")
    public Result error_400() {
        log.warn(ResultCode.FAIL.CODE+":"+ResultString.BAD_REQUEST.DATA);
        return ResultFactory.buildFailResult(ResultCode.FAIL.CODE+":"+ ResultString.BAD_REQUEST.DATA);
    }

    /**
     * 401页面
     */
    @RequestMapping(value = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result error_401() {
        log.warn(ResultCode.UNAUTHORIZED.CODE+":"+ResultString.NO_AUTHORIZED.DATA);
        return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, ResultString.NO_AUTHORIZED.DATA);
    }
    /**
     * 403页面
     */
    @RequestMapping(value = "/403")
    public Result error_403() {
        log.warn(ResultCode.FORBIDDEN.CODE+":"+ResultString.FORBIDDEN.DATA);
        return ResultFactory.buildResult(ResultCode.FORBIDDEN,ResultString.FORBIDDEN.DATA);
    }


}
