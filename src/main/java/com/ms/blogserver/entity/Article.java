package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Article implements Serializable {
    private Integer id;
    private String title;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalTime create_time;

}
