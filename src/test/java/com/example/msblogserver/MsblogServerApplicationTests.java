package com.example.msblogserver;

import com.ms.blogserver.entity.User;
import com.ms.blogserver.constant.result.ResultFactory;
import com.sun.glass.ui.Application;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)

class MsblogServerApplicationTests {


    @Test
    public void userUpdate(){
        User user = new User();
        user.setId(1392752115447533570L);
        user.setUsername("1456461");
        user.setPwd("131");
        user.setEmail("123@qq.com");


    }

}
