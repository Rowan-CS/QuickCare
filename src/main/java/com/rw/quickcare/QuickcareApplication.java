package com.rw.quickcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(basePackages = "com.rw.quickcare.mapper")
public class QuickcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickcareApplication.class, args);
    }

}
