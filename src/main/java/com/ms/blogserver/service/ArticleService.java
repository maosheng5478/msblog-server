package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.dto.ArticleDTO;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.vo.ArticleVO;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
public interface ArticleService extends IService<Article> {

    ArticleVO getArticleById(Long id);

    PageInfo<ArticleVO> getPage(ArticleDTO dto);


}
