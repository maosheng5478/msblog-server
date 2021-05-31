package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.Role;
import com.ms.blogserver.mapper.RoleMapper;
import com.ms.blogserver.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Role findByID(Long id) {
        return baseMapper.selectById(id);
    }
}
