package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.AdminMenu;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.mapper.AdminMenuMapper;
import com.ms.blogserver.service.AdminMenuService;
import com.ms.blogserver.service.AdminRolePermissionService;
import com.ms.blogserver.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminRolePermissionService adminRolePermissionService;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        List<Integer> midList = adminRolePermissionService.getAllMenuIdByRoleId(userService.findByUserName(username).getRoleId());
        return baseMapper.selectList(new QueryWrapper<AdminMenu>().in("id",midList));
    }

}
