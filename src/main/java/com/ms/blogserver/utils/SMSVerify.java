package com.ms.blogserver.utils;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
public class SMSVerify {

    private static final String host = "http://dingxin.market.alicloudapi.com";
    private static final String path = "/dx/sendSms";
    private static final String method = "POST";
    private static final String appcode = "6416008baa3d495a94bb4944fb788259";

    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "17759309269");
        querys.put("param", "code:1234");
        querys.put("tpl_id", "TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
