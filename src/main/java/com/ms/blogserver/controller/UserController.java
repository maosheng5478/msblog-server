package com.ms.blogserver.controller;

import com.ms.blogserver.constant.contexts.LoginContexts;
import com.ms.blogserver.constant.contexts.VerifyContexts;
import com.ms.blogserver.config.exception.CustomException;
import com.ms.blogserver.constant.controller.BaseController;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.dto.LoginDTO;
import com.ms.blogserver.dto.UserDTO;
import com.ms.blogserver.vo.UserVO;
import com.ms.blogserver.service.CaptchaService;
import com.ms.blogserver.service.TokenService;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.EncryptPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaptchaService captchaService;

    @PostMapping(value = "api/authentication")
    public Result authentication(HttpServletRequest request){
        String token = request.getHeader("token");
        return tokenService.hasLogin(token)?
                ResultFactory.buildSuccessResult("") :
                ResultFactory.buildResult(ResultCode.UNAUTHORIZED,LoginContexts.NO_LOGIN_USER);
    }

    @PostMapping(value = "/login")
    public Result userLogin(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws Exception {
        try {
            String username = loginDTO.getUsername();
            String pwd = loginDTO.getPassword();
            //判断验证码
            //captchaService.verifyArithmetic(loginDTO.getKey(), loginDTO.getCode());
            String realPassword =userService.getPassword(username);
            if (realPassword == null){
                return ResultFactory.buildFailResult(LoginContexts.USER_IS_NOT_EXIST);
            }else if (realPassword.equals(EncryptPassword.encrypt(pwd))){
                UserVO userVO = tokenService.setToken(userService.findByUserName(username),tokenService.CreateToken(username,response));
                return ResultFactory.buildSuccessResult(userVO);
            }
            return ResultFactory.buildFailResult(LoginContexts.PASSWORD_IS_ERROR);
        } catch (Exception e) {
           throw this.exceptionHandle(e);
        }
    }

    @PostMapping(value = "/add")
    public Result userAdd(@RequestBody UserDTO userDTO,Integer code){
        if (!tokenService.getVerifyCode(code)){
            return ResultFactory.buildFailResult(VerifyContexts.VERIFY_ERROR);
        }
        String username = userDTO.getUsername();
        username = HtmlUtils.htmlEscape(username);
        userDTO.setUsername(username);
        if (userService.hasUserName(username)){
            return ResultFactory.buildFailResult(LoginContexts.NAME_HAS_EXIST);
        }
        userService.insertUser(userDTO);
        return ResultFactory.buildSuccessResult(LoginContexts.REGISTER_SUCCESS);
    }

    @PostMapping(value = "/update")
    public Result userUpdate(@RequestBody UserDTO u) throws Exception {
        try {
            userService.updateUser(u);
            return ResultFactory.buildSuccessResult(userService.findAll());
        }catch (Exception e){
            throw this.exceptionHandle(e);
        }

    }
    @PostMapping(value = "/remove")
    public Result userDelete(@RequestBody Long id) throws CustomException {
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
    public Result phyDelete() throws Exception {
        try {
            userService.deleteById(1392754664565116930L);
            return ResultFactory.buildSuccessResult(userService.findAll());
        } catch (Exception e) {
            throw this.exceptionHandle(e);
        }
    }


}
