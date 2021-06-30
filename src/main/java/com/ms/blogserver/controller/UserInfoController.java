package com.ms.blogserver.controller;

import com.ms.blogserver.constant.contexts.LoginContexts;
import com.ms.blogserver.constant.contexts.PermissionContexts;
import com.ms.blogserver.constant.contexts.RoleContexts;
import com.ms.blogserver.constant.controller.BaseController;
import com.ms.blogserver.exception.CustomException;
import com.ms.blogserver.constant.result.Result;
import com.ms.blogserver.constant.result.ResultCode;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.constant.result.ResultString;
import com.ms.blogserver.model.dto.BaseDTO;
import com.ms.blogserver.service.MenuService;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/21
 */
@RestController
@RequestMapping(value = "/info")
public class UserInfoController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/menu")
    @RequiresRoles(value = {RoleContexts.SYSTEM_ADMIN,RoleContexts.CONTENT_MANAGER},logical = Logical.OR)
    public Result getMenu() throws Exception {
        try {
            String token = getHeaderToken();
            String username = TokenUtils.getAccount(token);
            if (StringUtils.isEmpty(username)){
                throw new CustomException(LoginContexts.USER_IS_NOT_EXIST);
            }
            Long uid = userService.findByUserName(username).getId();
            return ResultFactory.buildSuccessResult(menuService.getMenusByCurrentUser(uid));
        } catch (Exception e) {
            throw exceptionHandle(e);
        }
    }
    @PostMapping(value = "/user/page")
    @RequiresPermissions(logical = Logical.AND, value = {PermissionContexts.USERS_MANAGEMENT})
    public Result getByPage(BaseDTO dto) throws Exception {
        try {
            return ResultFactory.buildSuccessResult(userService.getPage(dto));
        } catch (Exception e) {
            throw exceptionHandle(e);
        }
    }


}
