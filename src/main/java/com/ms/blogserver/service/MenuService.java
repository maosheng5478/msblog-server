package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.Menu;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface MenuService extends IService<Menu> {

    List<Menu> getMenusByCurrentUser();

}
