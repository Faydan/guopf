package com.faydan.guopf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.faydan.guopf.mapper")
public class GuopfApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuopfApplication.class, args);
    }
}
