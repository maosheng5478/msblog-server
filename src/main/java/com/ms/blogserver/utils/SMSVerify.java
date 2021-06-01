package com.ms.blogserver.utils;


import com.ms.blogserver.constant.exception.CustomException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@Slf4j
public class SMSVerify {

    private static final String HOST = "http://dingxin.market.alicloudapi.com";
    private static final String PATH = "/dx/sendSms";
    private static final String METHOD = "POST";
    private static final String APPCODE = "6416008baa3d495a94bb4944fb788259";
    private static final Integer CODE_LENGTH = 6;

    public static Integer sendSMS(String phone){
        Integer code = RandomUtils.getRandomInt(CODE_LENGTH);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + APPCODE);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "code:"+code);
        querys.put("tpl_id", "TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpUtils.doPost(HOST, PATH, METHOD, headers, querys, bodys);
            log.debug("verify code:"+code);
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("SMS Send Error:"+"服务器异常，请联系管理人员");
        }
    }

}
