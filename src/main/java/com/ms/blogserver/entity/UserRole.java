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
    private Long id;
    private Long uid;
    private Long rid;

    public UserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public UserRole() {
    }
}
