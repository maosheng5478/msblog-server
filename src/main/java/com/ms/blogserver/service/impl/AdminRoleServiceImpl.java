package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.AdminRole;
import com.ms.blogserver.mapper.AdminRoleMapper;
import com.ms.blogserver.service.AdminRoleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper,AdminRole> implements AdminRoleService {

    @Override
    public AdminRole findByID(int id) {

        return baseMapper.selectById(id);
    }
}
