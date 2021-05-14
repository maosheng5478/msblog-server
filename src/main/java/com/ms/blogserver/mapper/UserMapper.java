package com.ms.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.blogserver.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


public interface UserMapper extends BaseMapper<User> {

    @Delete("delete from ms_user where id = #{id}")
    int deletedByDel(@Param("id") Long id);

}
