package com.yuzhe.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootMain {
    public static void main(String[] args){
        SpringApplication.run(SpringBootMain.class,args);
    }
}
