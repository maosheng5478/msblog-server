package com.ms.blogserver.entity.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Data
@ToString
public class CaptchaVO {
    private String key;
    private String img;

    public CaptchaVO(String key, String img) {
        this.key = key;
        this.img = img;
    }

    public CaptchaVO() {
    }
}
