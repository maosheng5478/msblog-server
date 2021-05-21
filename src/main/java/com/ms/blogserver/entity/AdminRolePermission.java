package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 角色对应菜单id
 * @author: zhh
 * @time: 2021/5/21
 */
@Data
@ToString
@TableName(value = "ms_admin_role_permission")
public class AdminRolePermission implements Serializable {

    private Integer id;
    private Integer rid;
    private Integer mid;
}
