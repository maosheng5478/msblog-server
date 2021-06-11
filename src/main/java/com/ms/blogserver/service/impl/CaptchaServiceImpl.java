package com.ms.blogserver.service.impl;

import com.ms.blogserver.constant.contexts.DigitalContexts;
import com.ms.blogserver.constant.contexts.VerifyContexts;
import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.vo.CaptchaVO;
import com.ms.blogserver.service.CaptchaService;
import com.ms.blogserver.utils.RedisUtils;
import com.ms.blogserver.utils.VerifyCodeUtils;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public CaptchaVO createArithmetic() {
        ArithmeticCaptcha captcha = VerifyCodeUtils.arithmeticCaptcha();
        //captcha.getArithmeticString();  // 获取运算的公式：3+2=?
        String key = UUID.randomUUID().toString();
        String code = captcha.text();
        log.debug("code:"+code+",expression:"+captcha.getArithmeticString());
        redisUtils.set(key,code, DigitalContexts.FIVE_MINUTES);
        return new CaptchaVO(key,captcha.toBase64());
    }

    @Override
    public CaptchaVO createSpec() {
        try {
            SpecCaptcha captcha = VerifyCodeUtils.digitalCaptcha();
            String code = captcha.text().toLowerCase(Locale.ROOT);
            String key = UUID.randomUUID().toString();
            log.debug("code:"+code);
            redisUtils.set(key,code,DigitalContexts.FIVE_MINUTES);
            return new CaptchaVO(key,captcha.toBase64());
        }catch (Exception e){
            throw new CustomException("Unknown error from captcha-createSpec:"+e.getMessage());
        }

    }

    @Override
    public void verifyArithmetic(String key, String code) {
        String redisCode = (String) redisUtils.get(key);
        if (redisCode == null){
            throw new CustomException(VerifyContexts.INVALID_CAPTCHA);
        }
        if (!redisCode.equals(code)){
            throw new CustomException(VerifyContexts.VERIFY_ERROR);
        }
    }

    @Override
    public void verifySpec(String key, String code) {
        verifyArithmetic(key,code);
    }
}
