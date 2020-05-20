package com.hnit.bmall.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hnit.bmall.book.mapper")
public class BmallBookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmallBookServiceApplication.class, args);
    }

}
