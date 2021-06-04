package com.ms.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.blogserver.entity.Category;
import org.mapstruct.Mapper;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
