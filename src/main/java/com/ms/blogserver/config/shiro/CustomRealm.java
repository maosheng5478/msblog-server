package com.ms.blogserver.config.shiro;

import com.ms.blogserver.config.jwt.JWTToken;

import com.ms.blogserver.entity.Permission;
import com.ms.blogserver.entity.Role;
import com.ms.blogserver.entity.RolePermission;
import com.ms.blogserver.entity.User;
import com.ms.blogserver.service.*;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private PermissionService permissionService;

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
        String token = (String) authenticationToken.getCredentials();
        String username = TokenUtils.getAccount(token);
        //这里要去数据库查找是否存在该用户，这里直接放行
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new AuthenticationException("认证失败,用户不存在");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");

    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = TokenUtils.getAccount(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        User user = userService.findByUserName(username);
        //获得该用户角色
        Role role = roleService.findByID(userRoleService.getRidByUid(user.getId()));
        List<Long> pid = rolePermissionService.getAllPermissionByRoleId(role.getId())
                .stream()
                .map(RolePermission::getPid)
                .collect(Collectors.toList());
        pid.forEach(item -> {
            //Permission permission = permissionService.getById(item);
            permissionSet.add(permissionService.getNameById(item));
        });
        roleSet.add(role.getName());
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }

}
