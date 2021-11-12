package com.halo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Halo
 * @create 2021/11/12 下午 11:14
 * @description
 */
@SpringBootApplication
// 启用异步处理
@EnableAsync
public class SpringEventApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringEventApp.class,args);
    }
}
