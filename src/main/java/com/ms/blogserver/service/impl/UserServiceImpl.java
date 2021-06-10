package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.constant.contexts.LoginContexts;
import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.constant.contexts.RoleContexts;
import com.ms.blogserver.converter.dto.UserDTOConverter;
import com.ms.blogserver.converter.vo.UserVOConverter;
import com.ms.blogserver.dto.BaseDTO;
import com.ms.blogserver.dto.UserDTO;
import com.ms.blogserver.entity.UserRole;
import com.ms.blogserver.service.UserRoleService;
import com.ms.blogserver.utils.RegularUtils;
import com.ms.blogserver.vo.UserVO;
import com.ms.blogserver.utils.EncryptPassword;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.mapper.UserMapper;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.PageInfoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean hasUserName(String username) {
        return findByUserName(username) == null;
    }

    @Override
    public User getUserByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void insertUser(UserDTO userDTO) {
        userDTO.setPwd(EncryptPassword.encrypt(userDTO.getPwd()));
        User  user = UserDTOConverter.INSTANCE.fromData(userDTO);
        String email = user.getEmail();
        if (StringUtils.isNotEmpty(email)){
            if (!RegularUtils.isEmail(email)){
                throw new CustomException(LoginContexts.EMAIL_ERROR);
            }
        }
        baseMapper.insert(user);
        // 新用户添加权限，默认权限为2
        User newUser = findByUserName(user.getUsername());
        userRoleService.save(new UserRole(newUser.getId(),RoleContexts.CONTENT_MANAGER_ID));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() == 0) {
            throw new CustomException("UserService-updateUser:"+LoginContexts.AUTHENTIC_FAIL);
        }
        User user = getUserByID(userDTO.getId());
        if (!userDTO.getUsername().isEmpty()) {
            user.setUsername(userDTO.getUsername());
        }
        if (!userDTO.getEmail().isEmpty()) {
            user.setEmail(userDTO.getEmail());
        }
        if (!userDTO.getPwd().isEmpty()) {
            user.setPwd(EncryptPassword.encrypt(userDTO.getPwd()));
        }
        if (!userDTO.getPhone().isEmpty()) {
            user.setPhone(userDTO.getPhone());
        }
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
        wrapper.eq("username", userName);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public String getPassword(String username) {
        return findByUserName(username).getPwd();
    }

    @Override
    public PageInfo<UserVO> getPage(BaseDTO dto) {
        PageHelper.startPage(dto.getPage(),dto.getSize());
        List<User> userList =findAll();
        List<UserVO> voList = UserVOConverter.INSTANCE.toDataList(userList);
        PageInfo<UserVO> userVOPageInfo = new PageInfo<>();
        PageInfoUtil.transform(new PageInfo<>(userList),userVOPageInfo);
        userVOPageInfo.setList(voList);
        return userVOPageInfo;
    }
}
