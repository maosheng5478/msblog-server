package com.ms.blogserver.converter;

import com.ms.blogserver.converter.core.Converter;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.vo.UserVO;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@org.mapstruct.Mapper
public interface UserVOConverter extends Converter<User, UserVO> {

    UserVOConverter INSTANCE = Mappers.getMapper(UserVOConverter.class);

    @Override
    UserVO toData(User user);

    @Override
    User fromData(UserVO userVO);

    @Override
    List<UserVO> toDataList(List<User> userList);
}
