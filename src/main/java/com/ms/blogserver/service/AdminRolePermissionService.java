package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.AdminRolePermission;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface AdminRolePermissionService extends IService<AdminRolePermission> {

    List<Integer> getAllMenuIdByRoleId(Integer roleId);
}
