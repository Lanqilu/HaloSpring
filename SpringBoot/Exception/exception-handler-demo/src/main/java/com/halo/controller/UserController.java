package com.halo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Halo
 * @create 2021/11/30 下午 03:30
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/get")
    public String get(){
        int i = 1 / 0;
        return "success";
    }
}