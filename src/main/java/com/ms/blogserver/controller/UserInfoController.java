package com.ms.blogserver.controller;

import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@RestController
@RequestMapping(value = "/info")
public class UserInfoController {

    @Autowired
    private AdminMenuService adminMenuService;

    @GetMapping(value = "/menu")
    public Result getMenu(){

        return ResultFactory.buildSuccessResult("");
    }
    @GetMapping(value = "/m")
    public Result getMdenu(){

        return ResultFactory.buildSuccessResult("");
    }

}
