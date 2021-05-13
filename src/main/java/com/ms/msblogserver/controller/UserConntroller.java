package com.ms.msblogserver.controller;

import com.ms.msblogserver.result.Result;
import com.ms.msblogserver.result.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserConntroller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "index")
    @ResponseBody
    public Result<String> index(){
        return new ResultFactory().buildSuccessResult("index");
    }

    @RequestMapping(value = "login")
    @ResponseBody
    public Result userLogin(){
        return ResultFactory.buildSuccessResult("username");
    }
}
