package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.entity.vo.PageVO;
import com.ms.blogserver.mapper.ArticleMapper;
import com.ms.blogserver.service.ArticleService;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public PageVO getPage() {
        return null;
    }
}
