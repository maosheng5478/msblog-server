package com.ms.blogserver.config.shiro;

import com.ms.blogserver.entity.User;
import com.ms.blogserver.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/14
 */
public class RealmConfig extends AuthorizingRealm {

    @Autowired
    private UserService userService;



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName =authenticationToken.getPrincipal().toString();
        User user = userService.findByUserName(userName);
        //String passwordInDB = user.getPwd();
        return new SimpleAuthenticationInfo(userName, user.getPwd(), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
