package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.constant.EncryptPassword;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.mapper.UserMapper;
import com.ms.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Watchable;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public User getUser(String username, String pwd) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("pwd",EncryptPassword.encrypt(pwd));
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public User getUserByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void insertUser(User user) {
        user.setPwd(EncryptPassword.encrypt(user.getPwd()));
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
        baseMapper.updateById(user);
    }

    @Override
    public List<User> findAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public int removeById(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteById(Long id) {
        return baseMapper.deletedByDel(id);
    }

    @Override
    public User findByUserName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userName);
        return baseMapper.selectOne(wrapper);
    }
}
