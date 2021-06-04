package com.ms.blogserver.converter;

import com.ms.blogserver.converter.core.Converter;
import com.ms.blogserver.entity.Comment;
import com.ms.blogserver.bo.CommentBO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@org.mapstruct.Mapper
public interface CommentBOConverter extends Converter<Comment,CommentBO> {

    CommentBOConverter INSTANCE = Mappers.getMapper(CommentBOConverter.class);
}
