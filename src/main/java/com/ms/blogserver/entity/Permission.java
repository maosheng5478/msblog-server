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
@TableName(value = "ms_permission")
public class Permission {
    private Long id;
    private String name;
    private String desc;
    private String url;
}