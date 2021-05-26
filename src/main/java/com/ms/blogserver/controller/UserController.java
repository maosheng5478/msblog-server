package com.ms.blogserver.controller;

import com.ms.blogserver.constant.LoginContexts;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.EncryptPassword;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "api/authentication")
    public Result authentication() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() ? ResultFactory.buildSuccessResult("") :
                ResultFactory.buildResult(ResultCode.UNAUTHORIZED,LoginContexts.NO_LOGIN_USER);
    }

    @RequestMapping(value = "/login")
    public Result userLogin(String username, String pwd, HttpServletResponse response){
        if (username == null){
            return ResultFactory.buildFailResult(LoginContexts.INPUT_USER_NAME);
        }else if(pwd == null){
            return ResultFactory.buildFailResult(LoginContexts.INPUT_PASSWORD);
        }
        String realPassword =userService.getPassword(username);
        if (realPassword == null){
            return ResultFactory.buildFailResult(LoginContexts.USER_IS_NOT_EXIST);
        }else if (!realPassword.equals(EncryptPassword.encrypt(pwd))){
            return ResultFactory.buildFailResult(LoginContexts.PASSWORD_IS_ERROR);
        }
        return ResultFactory.buildSuccessResult(tokenService.CreateToken(username,response));
    }

    @PostMapping(value = "/add")
    public Result userAdd(@RequestBody User user){
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        if (userService.hasUserName(username)){
            return ResultFactory.buildFailResult(LoginContexts.NAME_HAS_EXIST);
        }
        userService.insertUser(user);
        //List<User> userList = userService.findAll();
        return ResultFactory.buildSuccessResult(LoginContexts.REGISTER_SUCCESS);
    }

    @PostMapping(value = "/update")
    public Result userUpdate(@RequestBody User u){
        User user = userService.getUserByID(1392754664565116930L);
        user.setUsername("11131");
        user.setPwd("131");
        user.setEmail("123@qq.com");

        userService.updateUser(user);
        System.out.println();
        return ResultFactory.buildSuccessResult(userService.findAll());
    }
    @PostMapping(value = "/remove")
    public Result userDelete() throws Exception {
        if (userService.removeById(1392754664565116930L) == 1){
            return ResultFactory.buildSuccessResult(userService.findAll());
        }
        throw new Exception("There is no data with ID "+ "1392754664565116930L"+" in the database");

    }
    @PostMapping(value = "/delete")
    public Result phyDelete(){
        userService.deleteById(1392754664565116930L);
        return ResultFactory.buildSuccessResult(userService.findAll());
    }

    @GetMapping(value = "/logout")
    public Result logout() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        log.info(String.valueOf(subject.isAuthenticated()));
        if (subject.isAuthenticated()) {
            try {
                subject.logout();
            }catch (Exception e){
                e.printStackTrace();
            }

            return ResultFactory.buildSuccessResult(LoginContexts.LOGOUT_SUCCESS);
        }
        return ResultFactory.buildFailResult(LoginContexts.NO_LOGIN_USER);
    }




}
