package com.ms.blogserver.controller;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.entity.vo.CaptchaVO;
import com.ms.blogserver.service.CaptchaService;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.utils.RedisUtils;
import com.wf.captcha.ArithmeticCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@RestController
@Slf4j
@RequestMapping(value = "/code")
public class VerifyController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping(value = "/sms")
    public Result sendSMSCode(String phone){
        tokenService.sendSMS(phone);
        return ResultFactory.buildSuccessResult("");
    }

    @PostMapping(value = "/captcha/arithmetic")
    public Result arithmetic(){
        CaptchaVO captchaVO = captchaService.createArithmetic();
        return ResultFactory.buildSuccessResult(captchaVO);
    }

    @PostMapping(value = "/captcha/spec")
    public Result spec() throws IOException, FontFormatException {
        CaptchaVO captchaVO = captchaService.createSpec();
        return ResultFactory.buildSuccessResult(captchaVO);
    }
}
