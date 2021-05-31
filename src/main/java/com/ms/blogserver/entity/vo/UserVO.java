package com.ms.blogserver.entity.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
@Data
@ToString
public class UserVO {
    private Long id ;
    private String username;
    private Integer phone;
    private String email;
    private String token;

}
