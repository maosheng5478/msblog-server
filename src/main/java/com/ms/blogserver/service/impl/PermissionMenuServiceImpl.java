package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.PermissionMenu;
import com.ms.blogserver.mapper.PermissionMenuMapper;
import com.ms.blogserver.service.PermissionMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
@Service
public class PermissionMenuServiceImpl extends ServiceImpl<PermissionMenuMapper, PermissionMenu> implements PermissionMenuService {
    @Override
    public List<PermissionMenu> getMenuIdByPid(List<Long> list) {
        return baseMapper.selectList(new QueryWrapper<PermissionMenu>().in("pid",list));
    }
}
