package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    User getUser(String username,String pwd);

    User getUserByID(Long id);

    void insertUser(User user);

    void updateUser(User user);

    List<User> findAll();

}
