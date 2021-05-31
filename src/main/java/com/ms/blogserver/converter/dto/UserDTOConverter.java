package com.ms.blogserver.converter.dto;

import com.ms.blogserver.converter.Converter;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.entity.dto.UserDTO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
@org.mapstruct.Mapper
public interface UserDTOConverter extends Converter<User, UserDTO> {

    UserDTOConverter INSTANCE = Mappers.getMapper(UserDTOConverter.class);

    @Override
    UserDTO toData(User user);

    @Override
    User fromData(UserDTO userDTO);
}
