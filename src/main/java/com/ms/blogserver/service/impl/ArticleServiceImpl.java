package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.vo.ArticleVO;
import com.ms.blogserver.mapper.ArticleMapper;
import com.ms.blogserver.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public ArticleVO getArticleById(Long id) {
        return null;
    }

    @Override
    public PageInfo getPage() {
        return null;
    }
}
