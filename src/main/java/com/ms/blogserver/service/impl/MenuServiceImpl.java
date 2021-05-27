package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.Menu;
import com.ms.blogserver.mapper.MenuMapper;
import com.ms.blogserver.service.MenuService;
import com.ms.blogserver.service.RolePermissionService;
import com.ms.blogserver.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Menu> getMenusByCurrentUser() {
//        String username = SecurityUtils.getSubject().getPrincipal().toString();
//        List<Integer> midList = rolePermissionService.getAllMenuIdByRoleId(userService.findByUserName(username).getRoleId());
//        return baseMapper.selectList(new QueryWrapper<Menu>().in("id",midList));
        return null;
    }

}
