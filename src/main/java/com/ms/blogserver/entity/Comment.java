package com.ms.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Data
@ToString
@TableName(value = "ms_comment")
public class Comment implements Serializable {
    private Long id;
    private String content;
    private Long commenterId;
    private Long respondentId;
    private Long parentId;
    private Integer likes;
    private LocalTime create_time;
}
