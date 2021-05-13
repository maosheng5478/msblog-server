package com.ms.blogserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsblogServerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MsblogServerApplication.class, args);
        try{
            SpringApplication.run(MsblogServerApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
