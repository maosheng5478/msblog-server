package com.ms.blogserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MsblogServerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MsblogServerApplication.class);
    }

    public static void main(String[] args) {
        //SpringApplication.run(MsblogServerApplication.class, args);
        try{
            SpringApplication.run(MsblogServerApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
