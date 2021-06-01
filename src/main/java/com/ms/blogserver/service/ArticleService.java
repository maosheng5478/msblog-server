package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.entity.vo.PageVO;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
public interface ArticleService extends IService<Article> {

    PageVO getPage();

}
