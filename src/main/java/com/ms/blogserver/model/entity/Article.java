package com.ms.blogserver.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/20
 */
@Data
@ToString
@TableName(value = "ms_article")
public class Article implements Serializable {
    private Long id;
    private String title;
    private String content;
    private String contentMd;
    private Long writerId;
    private String cover;
    private Integer likes;
    private Integer type;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalTime createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalTime updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
