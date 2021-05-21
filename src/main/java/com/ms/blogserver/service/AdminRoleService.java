package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.AdminRole;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
public interface AdminRoleService extends IService<AdminRole> {

    AdminRole findByID(int id);
}
