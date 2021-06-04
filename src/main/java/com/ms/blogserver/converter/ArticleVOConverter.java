package com.ms.blogserver.converter;

import com.ms.blogserver.converter.core.Converter;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.vo.ArticleVO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
@org.mapstruct.Mapper
public interface ArticleVOConverter extends Converter<Article, ArticleVO> {

    ArticleVOConverter INSTANCE = Mappers.getMapper(ArticleVOConverter.class);
}
