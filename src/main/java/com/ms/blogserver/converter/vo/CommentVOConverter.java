package com.ms.blogserver.converter.vo;

import com.ms.blogserver.converter.Converter;
import com.ms.blogserver.entity.Comment;
import com.ms.blogserver.entity.bo.CommentBO;
import com.ms.blogserver.entity.vo.CommentVO;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@org.mapstruct.Mapper
public interface CommentVOConverter extends Converter<CommentBO, CommentVO> {

    CommentVOConverter INSTANCE = Mappers.getMapper(CommentVOConverter.class);

}
