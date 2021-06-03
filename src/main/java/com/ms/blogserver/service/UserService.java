package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.dto.BaseDTO;
import com.ms.blogserver.dto.UserDTO;
import com.ms.blogserver.vo.UserVO;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    boolean hasUserName(String username);

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
     * @param userDTO
     */
    void insertUser(UserDTO userDTO);

    /**
     * 修改用户（乐观锁）
     *
     * @param userDTO
     */
    void updateUser(UserDTO userDTO);

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

    /**
     * 获取用户密码
     * @param username
     * @return
     */
    String getPassword(String username);

    /**
     * 分页查询
     * @return
     * @param dto
     */
    PageInfo<UserVO> getPage(BaseDTO dto);
}
