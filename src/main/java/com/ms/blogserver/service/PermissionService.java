package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.Permission;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
public interface PermissionService extends IService<Permission> {

    String getNameById(Long pid);
}

