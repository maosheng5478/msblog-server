package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.AdminMenu;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface AdminMenuService extends IService<AdminMenu> {

    List<AdminMenu> getMenusByCurrentUser();

}
