package com.ms.blogserver.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@Data
@ToString
public class UserVO {
    private Long id ;
    private String username;
    private String phone;
    private String email;
    private String token;
}
