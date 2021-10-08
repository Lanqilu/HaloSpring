package com.halo.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Halo
 * @date Created in 2021/04/15 8:08 PM
 * @description
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }
}
