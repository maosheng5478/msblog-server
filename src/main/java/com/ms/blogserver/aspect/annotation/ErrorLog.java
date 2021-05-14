package com.ms.blogserver.aspect.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ErrorLog {
}
