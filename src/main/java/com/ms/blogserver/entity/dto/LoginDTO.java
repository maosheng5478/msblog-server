package com.ms.blogserver.entity.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Data
@ToString
public class LoginDTO extends BaseDTO {

    private String username;
    private String password;
    private String key;
    private String code;
}
