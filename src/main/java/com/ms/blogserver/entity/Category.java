package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
@Data
@ToString
@TableName(value = "ms_category")
public class Category {
    private Integer id;
    private Integer categoryId;
    private String category;
}
