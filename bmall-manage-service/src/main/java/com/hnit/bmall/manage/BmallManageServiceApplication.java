package com.hnit.bmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hnit.bmall.manage.mapper")
public class BmallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmallManageServiceApplication.class, args);
    }

}
