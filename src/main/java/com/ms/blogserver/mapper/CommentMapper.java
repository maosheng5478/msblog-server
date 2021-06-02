package com.ms.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.blogserver.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
