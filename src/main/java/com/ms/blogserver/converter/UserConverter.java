package com.ms.blogserver.converter;

import com.ms.blogserver.converter.core.Converter;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.entity.vo.UserVO;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@org.mapstruct.Mapper
public interface UserConverter extends Converter<User, UserVO> {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Override
    UserVO toData(User user);

    @Override
    User fromData(UserVO userVO);

    List<UserVO> toListData(List<User> userList);
}
