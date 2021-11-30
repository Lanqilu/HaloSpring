package com.halo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Halo
 * @create 2021/11/19 下午 05:27
 * @description
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String username;
}