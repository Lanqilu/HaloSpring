package com.halo.hello.entity;

import lombok.Data;

/**
 * @author Halo
 * @create 2021/10/08 上午 11:23
 * @description 数据表对应的实体类
 */
@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
}