package com.ms.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.blogserver.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
