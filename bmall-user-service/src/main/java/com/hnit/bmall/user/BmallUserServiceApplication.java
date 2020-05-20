package com.hnit.bmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hnit.bmall.user.mapper")
public class BmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmallUserServiceApplication.class, args);
    }

}
