package com.ms.blogserver.aspect;

import com.ms.blogserver.aspect.annotation.PermissionCheck;
import com.ms.blogserver.constant.result.ResultFactory;
import com.ms.blogserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class HasUserAspect {

    @Autowired
    private UserService service;

    @Pointcut("execution(public * com.ms.blogserver.controller..*(..))")
    public void login(){

    }

    @Around("login() && @annotation(permissionCheck)")
    public Object LoginAround(ProceedingJoinPoint pjp, PermissionCheck permissionCheck) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求路径 : " + request.getRequestURL());
        if (2==2000){
            return ResultFactory.buildFailResult("用户未登录");
        }
        return pjp.proceed();
    }

}
