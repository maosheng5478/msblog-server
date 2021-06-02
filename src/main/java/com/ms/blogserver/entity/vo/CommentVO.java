package com.ms.blogserver.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Data
@ToString
public class CommentVO {
    private Long id;
    private String content;
    private String commenter;
    private String respondent;
    private Integer likes;
    private Long parentId;
    private LocalTime create_time;

    private List<CommentVO> children;
}
