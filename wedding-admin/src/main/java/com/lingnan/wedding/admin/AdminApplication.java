package com.lingnan.wedding.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-10 17:58
 **/

@MapperScan("com.lingnan.wedding.mapper")
@SpringBootApplication(scanBasePackages = "com.lingnan.wedding.admin")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
