package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.entity.Comment;
import com.ms.blogserver.entity.dto.BaseDTO;
import com.ms.blogserver.entity.dto.GetCommentDTO;
import com.ms.blogserver.entity.vo.CommentVO;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
public interface CommentService extends IService<Comment> {

    List<Comment> getAllCommentByArticleId(Long articleId);

    List<CommentVO> getParentId(Long pid);

    PageInfo<CommentVO> getPageByArticle(GetCommentDTO dto);
}
