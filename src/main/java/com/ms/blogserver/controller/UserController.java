package com.ms.blogserver.controller;

import com.ms.blogserver.constant.LoginContexts;
import com.ms.blogserver.constant.exception.CustomException;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.EncryptPassword;
import com.ms.blogserver.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "api/authentication")
    public Result authentication(HttpServletRequest request){
        String token = request.getHeader("token");
        return tokenService.hasLogin(token)?
                ResultFactory.buildSuccessResult("") :
                ResultFactory.buildResult(ResultCode.UNAUTHORIZED,LoginContexts.NO_LOGIN_USER);
    }

    @PostMapping(value = "/login")
    public Result userLogin(String username, String pwd, HttpServletResponse response){
        String realPassword =userService.getPassword(username);
        if (realPassword == null){
            return ResultFactory.buildFailResult(LoginContexts.USER_IS_NOT_EXIST);
        }else if (realPassword.equals(EncryptPassword.encrypt(pwd))){
            Map<String,Object> map = new HashMap<>();
            map.put("token",tokenService.CreateToken(username,response));
            map.put("username",username);
            map.put("id",userService.findByUserName(username).getId());
            return ResultFactory.buildSuccessResult(map);
        }
        return ResultFactory.buildFailResult(LoginContexts.PASSWORD_IS_ERROR);
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
        return ResultFactory.buildSuccessResult(LoginContexts.REGISTER_SUCCESS);
    }

    @PostMapping(value = "/update")
    public Result userUpdate(@RequestBody User u) throws CustomException {
        userService.updateUser(u);
        return ResultFactory.buildSuccessResult(userService.findAll());
    }
    @PostMapping(value = "/remove")
    public Result userDelete(Long  id) throws CustomException {
        if (userService.removeById(id) == 1){
            return ResultFactory.buildSuccessResult(userService.findAll());
        }
        throw new CustomException("There is no data with ID "+ id+" in the database");

    }

    @GetMapping(value = "/logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        return tokenService.removeToken(token) ?
                ResultFactory.buildSuccessResult(LoginContexts.LOGOUT_SUCCESS) :
                ResultFactory.buildFailResult(LoginContexts.NO_LOGIN_USER);
    }

    @PostMapping(value = "/delete")
    public Result phyDelete(){
        userService.deleteById(1392754664565116930L);
        return ResultFactory.buildSuccessResult(userService.findAll());
    }


}
