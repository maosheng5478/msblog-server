package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 菜单实体类
 * @author: zhh
 * @time: 2021/5/21
 */
@Data
@ToString
@TableName(value = "ms_admin_menu")
public class AdminMenu implements Serializable {

    private Integer id;
    private String path;
    private String name;
    private String nameZh;
    private String component;
    private Integer parentId;

    public AdminMenu() {
    }
}
