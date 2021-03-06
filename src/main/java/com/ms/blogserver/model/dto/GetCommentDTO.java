package com.ms.blogserver.model.dto;

import lombok.Data;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Data
public class GetCommentDTO extends BaseDTO{
    private Long articleId;

    public GetCommentDTO(Long articleId) {
        this.articleId = articleId;
    }

    public GetCommentDTO() {
    }
}
