package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.mapper.UserMapper;
import com.ms.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public User getUser(String username, String pwd) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("pwd",pwd);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public User getUserByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void insertUser(User user) {
        baseMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        /*UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",user.getId());
        wrapper.set("username",user.getUsername());
        wrapper.set("pwd",user.getPwd());
        wrapper.set("phone",user.getPhone());
        wrapper.set("email",user.getEmail());*/
        System.out.println(user.getVersion()+"=================");
        baseMapper.updateById(user);
    }

    @Override
    public List<User> findAll() {
        return baseMapper.selectList(null);
    }
}
