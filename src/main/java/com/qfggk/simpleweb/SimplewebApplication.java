package com.qfggk.simpleweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.qfggk.simpleweb.mapper")
public class SimplewebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplewebApplication.class, args);
    }

}