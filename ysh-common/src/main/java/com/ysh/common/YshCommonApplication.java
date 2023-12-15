package com.ysh.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ysh"})
public class YshCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(YshCommonApplication.class, args);
    }

}
