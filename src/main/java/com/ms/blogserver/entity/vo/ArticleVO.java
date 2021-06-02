package com.ms.blogserver.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Data
@ToString
public class ArticleVO {
    private Long id;
    private String title;
    private String content;
    private String contentMd;
    private String writer;
    private String cover;
    private Integer likes;

    //文章评论
    private List<CommentVO> commentVOS;
}
