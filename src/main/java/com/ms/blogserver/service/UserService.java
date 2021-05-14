package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     *根据用户名和密码查询
     *
     * @param username
     * @param pwd
     * @return
     */
    User getUser(String username,String pwd);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserByID(Long id);

    /**
     * 插入用户
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 修改用户（乐观锁）
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 删除用户
     * 逻辑删除
     * deleted默认0，删除时为1
     *
     * @param id
     * @return
     */
     int removeById(Long id);

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
     int deleteById(Long id);

    /**
     * 根据名字查找
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
