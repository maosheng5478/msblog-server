package com.ms.blogserver.config.shiro;

import com.ms.blogserver.config.jwt.JWTToken;

import com.ms.blogserver.entity.User;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: zhh
 * @time: 2021/5/24
 */

@Component
@Slf4j
public class CustomRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("身份认证");
        String token= (String) authenticationToken.getCredentials();
        String username= TokenUtils.getAccount(token);
        //这里要去数据库查找是否存在该用户，这里直接放行
        User user = userService.findByUserName(username);
        if (user==null){
            throw new AuthenticationException("认证失败,用户不存在");
        }
        return new SimpleAuthenticationInfo(token,token,"MyRealm");

    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = TokenUtils.getAccount(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = userService.findByUserName(username);
//        //获得该用户角色
//        String role = userService.getRole(username);
//        //每个角色拥有默认的权限
//        String rolePermission = userService.getRolePermission(username);
//        //每个用户可以设置新的权限
//        String permission = userService.getPermission(username);
//        Set<String> roleSet = new HashSet<>();
//        Set<String> permissionSet = new HashSet<>();
//        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
//        roleSet.add(role);
//        permissionSet.add(rolePermission);
//        permissionSet.add(permission);
//        //设置该用户拥有的角色和权限
//        info.setRoles(roleSet);
//        info.setStringPermissions(permissionSet);
//        return info;
        return null;
    }

}
