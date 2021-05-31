package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.RolePermission;
import com.ms.blogserver.mapper.RolePermissionMapper;
import com.ms.blogserver.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Override
    public List<RolePermission> getAllPermissionByRoleId(Long roleId) {
        List<RolePermission> list = baseMapper.selectList(new QueryWrapper<RolePermission>().eq("rid",roleId));
        return list;
    }
}
