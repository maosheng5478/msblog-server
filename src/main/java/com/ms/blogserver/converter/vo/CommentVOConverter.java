package com.ms.blogserver.converter.vo;

import com.ms.blogserver.converter.Converter;
import com.ms.blogserver.bo.CommentBO;
import com.ms.blogserver.vo.CommentVO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@org.mapstruct.Mapper
public interface CommentVOConverter extends Converter<CommentBO, CommentVO> {

    CommentVOConverter INSTANCE = Mappers.getMapper(CommentVOConverter.class);

}
