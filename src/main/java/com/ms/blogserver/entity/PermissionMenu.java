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
@TableName(value = "ms_permission_menu")
public class PermissionMenu {
    //主键id
    private int id;
    //permission id
    private int pid;
    //menu id
    private int mid;

}
