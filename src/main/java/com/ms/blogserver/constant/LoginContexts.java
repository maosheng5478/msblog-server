package com.ms.blogserver.constant;

import com.ms.blogserver.aspect.annotation.PermissionCheck;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/14
 */
public interface LoginContexts {

    String INPUT_USER_NAME = "请输入用户名";

    String INPUT_PASSWORD = "请输入密码";

    String USER_IS_NOT_EXIST = "用户不存在";

    String AUTHENTIC_FAIL = "认证失败：身份验证异常";

    String PASSWORD_IS_ERROR = "密码错误";

    String LOGOUT_SUCCESS = "成功登出";

    String NO_LOGIN_USER = "用户未登录";

    String NAME_HAS_EXIST = "用户名已存在";

    String REGISTER_SUCCESS = "注册成功";
}
