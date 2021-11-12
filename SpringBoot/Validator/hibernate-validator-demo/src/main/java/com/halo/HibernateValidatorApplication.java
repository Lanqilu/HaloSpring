package com.halo;

import com.halo.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Halo
 * @create 2021/11/12 下午 03:29
 * @description
 */
@SpringBootApplication
@EnableFormValidator
public class HibernateValidatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateValidatorApplication.class, args);
    }
}
