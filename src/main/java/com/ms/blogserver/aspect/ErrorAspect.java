package com.ms.blogserver.aspect;

import com.ms.blogserver.aspect.annotation.ErrorLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/14
 */

@Aspect
@Component
@Slf4j
public class ErrorAspect {

    @Pointcut("execution(public * com.ms.blogserver.controller..*(..))")
    public void err(){

    }

    @AfterThrowing(pointcut="within(com.ms.blogserver..*) && @annotation(rl)", throwing="ex")
    public void addLog(JoinPoint jp, ErrorLog rl, Exception ex){
      log.error(ex.getMessage());
    }
}
