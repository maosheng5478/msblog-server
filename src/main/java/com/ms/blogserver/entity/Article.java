package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.ToString;

import javax.swing.border.TitledBorder;
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalTime createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalTime updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
