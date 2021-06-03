package com.ms.blogserver.controller;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.dto.GetCommentDTO;
import com.ms.blogserver.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@RestController
@Slf4j
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/comment")
    public Result getComment(@RequestBody GetCommentDTO dto){
        return ResultFactory.buildSuccessResult(commentService.getPageByArticle(dto));
    }
}
