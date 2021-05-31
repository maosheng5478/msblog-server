package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.constant.LoginContexts;
import com.ms.blogserver.constant.exception.CustomException;
import com.ms.blogserver.entity.Menu;
import com.ms.blogserver.entity.PermissionMenu;
import com.ms.blogserver.entity.RolePermission;
import com.ms.blogserver.mapper.MenuMapper;
import com.ms.blogserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PermissionMenuService permissionMenuService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Menu> getMenusByCurrentUser(Long uid) {
        Long rid = userRoleService.getRidByUid(uid);
        List<Long> pidList =rolePermissionService.getAllPermissionByRoleId(rid)
                .stream()
                .map(RolePermission::getPid)
                .collect(Collectors.toList());
        List<Integer> midList = permissionMenuService.getMenuIdByPid(pidList)
                .stream()
                .map(PermissionMenu::getMid)
                .collect(Collectors.toList());
        List<Menu> menus = baseMapper.selectList(new QueryWrapper<Menu>().in("id",midList));
        handleMenu(menus);
        return menus;
    }

    @Override
    public List<Menu> getParentId(Integer parentId) {
        return baseMapper.selectList(new QueryWrapper<Menu>().eq("parent_id",parentId));
    }

    /**
     * 组装菜单
     * @return
     */
    private void handleMenu(List<Menu> list){
        list.forEach(menu -> {
            List<Menu> childrenMenu = getParentId(menu.getId());
            menu.setChildren(childrenMenu);
        });
        list.removeIf(menu -> menu.getParentId() != 0);
    }

}
