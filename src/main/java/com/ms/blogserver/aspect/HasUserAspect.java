package com.ms.blogserver.aspect;

import com.ms.blogserver.aspect.annotation.PermissionCheck;
import com.ms.blogserver.constant.result.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class HasUserAspect {


    @Pointcut("execution(public * com.ms.blogserver.controller..*(..))")
    public void login(){

    }

    @Around("login() && @annotation(permissionCheck)")
    public Object LoginAround(ProceedingJoinPoint pjp, PermissionCheck permissionCheck) throws Throwable {
        if (2==2000){
            return ResultFactory.buildFailResult("用户未登录");
        }
        return pjp.proceed();
    }

}
