package com.ms.blogserver.service.api;

import com.ms.blogserver.model.vo.CaptchaVO;

import java.awt.*;
import java.io.IOException;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
public interface CaptchaService {

    CaptchaVO createArithmetic();

    CaptchaVO createSpec() throws IOException, FontFormatException;

    void verifyArithmetic(String key,String code);

    void verifySpec(String key,String code);
}