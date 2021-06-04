package com.ms.blogserver.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
@Data
@ToString
public class ArticleDTO extends BaseDTO{
    private Long id;
    private Integer type;
    private LocalTime time;
    private Long writerId;
}
