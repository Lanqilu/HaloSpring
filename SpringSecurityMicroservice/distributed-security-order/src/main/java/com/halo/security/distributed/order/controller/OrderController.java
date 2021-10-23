package com.halo.security.distributed.order.controller;

import com.halo.security.distributed.order.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Halo
 * @create 2021/10/23 下午 05:04
 * @description
 */
@Slf4j
@RestController
public class OrderController {


    /**
     * 拥有 p1 权限方可访问此 URL
     */
    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1() {
        return "访问资源1成功";
    }

}