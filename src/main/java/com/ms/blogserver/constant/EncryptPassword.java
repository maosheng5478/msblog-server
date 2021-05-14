package com.ms.blogserver.constant;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/14
 */
public class EncryptPassword {
    private static final String DEFAULT_ALGORITHM_NAME = "MD5";
    private static final Object DEFAULT_SALT = null;
    private static final int DEFAULT_HASH_ITERATIONS = 1;

    public static String encrypt(String password) {
        return new SimpleHash(DEFAULT_ALGORITHM_NAME, password, DEFAULT_SALT, DEFAULT_HASH_ITERATIONS).toString();
    }
}
