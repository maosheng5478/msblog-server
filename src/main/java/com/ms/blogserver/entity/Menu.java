package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;


import java.io.Serializable;
import java.util.List;

/**
 * @description: 菜单实体类
 * @author: zhh
 * @time: 2021/5/21
 */
@Data
@ToString
@TableName(value = "ms_menu")
public class Menu implements Serializable {

    private Integer id;
    private String path;
    private String name;
    private String nameZh;
    private String component;
    private Integer parentId;
    @TableLogic
    private int deleted;
    @TableField(exist = false)
    private List<Menu> children;

    public Menu() {
    }
}
