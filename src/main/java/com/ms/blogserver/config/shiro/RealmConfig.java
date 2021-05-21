package com.ms.blogserver.config.shiro;

import com.ms.blogserver.config.jwt.JWTToken;
import com.ms.blogserver.config.jwt.JWTUtil;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.service.UserService;
import org.apache.shiro.authc.*;
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

    /**
     * 必须重写此方法，不然Shiro会报错
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        //String userName =authenticationToken.getPrincipal().toString();
        String username = JWTUtil.getUsername(token);
        User user = userService.findByUserName(username);
        if (! JWTUtil.verify(token, username, user.getPwd())) {
            throw new AuthenticationException("qqqqqq");
        }
        return new SimpleAuthenticationInfo(username, user.getPwd(), getName());
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
        super.assertCredentialsMatch(token, info);
    }

}
