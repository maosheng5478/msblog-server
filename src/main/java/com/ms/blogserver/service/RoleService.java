package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.Role;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface RoleService extends IService<Role> {

    Role findByID(Long id);
}
