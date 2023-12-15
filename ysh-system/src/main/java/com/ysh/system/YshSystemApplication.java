package com.ysh.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ysh"})
@MapperScan(basePackages = {"com.ysh.**.dao"})
public class YshSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(YshSystemApplication.class, args);
    }

}
