package com.example.msblogserver;

import com.ms.blogserver.entity.User;
import com.ms.blogserver.result.Result;
import com.ms.blogserver.result.ResultFactory;
import com.ms.blogserver.service.UserService;
import com.sun.glass.ui.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
class MsblogServerApplicationTests {


    @Test
    public void userUpdate(){
        User user = new User();
        user.setId(1392752115447533570L);
        user.setUsername("1456461");
        user.setPwd("131");
        user.setEmail("123@qq.com");

        System.out.println( ResultFactory.buildSuccessResult("userService.findAll()"));
    }

}
