package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 用户角色
 * @author: zhh
 * @time: 2021/5/21
 */
@Data
@ToString
@TableName(value = "ms_role")
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;
    private int enabled;

    public Role() {
    }
}
