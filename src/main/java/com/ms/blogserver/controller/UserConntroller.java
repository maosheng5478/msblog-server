package com.ms.blogserver.controller;

import com.ms.blogserver.entity.User;
import com.ms.blogserver.result.Result;
import com.ms.blogserver.result.ResultFactory;
import com.ms.blogserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class UserConntroller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public Result<String> index(){
        return new ResultFactory().buildSuccessResult("index");
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result userLogin(){
        User  user = userService.getUser("admin","admin");
        log.debug(user.toString());
        return ResultFactory.buildSuccessResult(user);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Result userAdd(){
        userService.insertUser(new User("admin","admin"));
        List<User> userList = userService.findAll();
        return ResultFactory.buildSuccessResult(userList);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Result userUpdate(){
        User user = userService.getUserByID(1392754664565116930L);
        user.setUsername("11131");
        user.setPwd("131");
        user.setEmail("123@qq.com");

        userService.updateUser(user);

        return ResultFactory.buildSuccessResult(userService.findAll());
    }
}
