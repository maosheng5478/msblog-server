package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
@Data
@ToString
@TableName(value = "ms_user_role")
public class UserRole {
    private int id;
    private int uid;
    private int rid;
}
