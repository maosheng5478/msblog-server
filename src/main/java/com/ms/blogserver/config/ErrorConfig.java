package com.ms.blogserver.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: z
 * @time: 2021/5/14
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/err/400");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/err/401");
        ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/err/403");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/err/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/err/500");
        registry.addErrorPages(error400Page,error401Page,error403Page,error404Page,error500Page);
    }
}
