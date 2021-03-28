package com.lingnan.wedding.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 13:50
 **/
@MapperScan("com.lingnan.wedding.mapper")
@SpringBootApplication(excludeName = "com.lingnan.wedding.client")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
