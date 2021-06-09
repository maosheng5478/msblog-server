package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.entity.UserRole;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
public interface UserRoleService extends IService<UserRole> {

    Long getRidByUid(Long uid) throws CustomException;
}
