package com.ms.blogserver.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@Data
@ToString
public class UserDTO extends BaseDTO{
    private Long id;
    private String username;
    private String pwd;
    private String phone;
    private String email;
}
