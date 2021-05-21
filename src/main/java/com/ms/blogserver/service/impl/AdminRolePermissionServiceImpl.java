package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.AdminRolePermission;
import com.ms.blogserver.mapper.AdminRolePermissionMapper;
import com.ms.blogserver.service.AdminRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class AdminRolePermissionServiceImpl extends ServiceImpl<AdminRolePermissionMapper, AdminRolePermission> implements AdminRolePermissionService {
    @Override
    public List<Integer> getAllMenuIdByRoleId(Integer roleId) {
        return baseMapper.selectList(new QueryWrapper<AdminRolePermission>().eq("rid",roleId))
                .stream()
                .map(AdminRolePermission::getMid)
                .collect(Collectors.toList());
    }
}
