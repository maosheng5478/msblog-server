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
@TableName(value = "ms_role_permission")
public class RolePermission implements Serializable {
    //主键id
    private Long id;
    //role id
    private int rid;
    //permission id
    private int pid;
}
