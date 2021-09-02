package com.ms.blogserver.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Data
public class CommentBO implements Serializable {
    private Long id;
    private String content;
    private String commenter;
    private String respondent;
    private Long commenterId;
    private Long respondentId;
    private Long parentId;
    private Integer likes;
    private LocalTime createTime;
}
