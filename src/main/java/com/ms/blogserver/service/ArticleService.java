package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.entity.vo.ArticleVO;
import com.ms.blogserver.entity.vo.PageVO;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
public interface ArticleService extends IService<Article> {

    ArticleVO getArticleById(Long id);

    PageInfo getPage();


}
