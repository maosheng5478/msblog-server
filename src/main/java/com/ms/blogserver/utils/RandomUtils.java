package com.ms.blogserver.utils;

import java.util.Random;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public class RandomUtils {
    /**
     * 生成随机字符
     *
     * @param length 生成随机字符的长度
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     *
     *
     * @param length
     * @return
     */
    public static Integer getRandomInt(int length){
        String num = "1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(num.length());
            sb.append(num.charAt(number));
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     *
     * @return
     */
    public static Integer getFourInt(){
        return getRandomInt(4);
    }
}
