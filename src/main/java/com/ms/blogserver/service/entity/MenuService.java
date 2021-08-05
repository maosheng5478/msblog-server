package com.ms.blogserver.service.entity;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.model.entity.Menu;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface MenuService extends IService<Menu> {

    List<Menu> getMenusByCurrentUser(Long uid);

    List<Menu> getParentId(Integer parentId);

}