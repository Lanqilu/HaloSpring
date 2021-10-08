package com.halo.annotation.controller;

import com.halo.annotation.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Halo";
    }

    @GetMapping("index")
    public String index() {
        return "Hello Index";
    }

    @GetMapping("secured")
    @Secured({"ROLE_sale", "ROLE_manager"})
    public String secured() {
        return "Hello Secured";
    }

    @GetMapping("PreAuthorize")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String preAuthorize() {
        System.out.println("进入了PreAuthorize");
        return "Hello PreAuthorize";
    }

    @GetMapping("PostAuthorize")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String postAuthorize() {
        System.out.println("进入了PostAuthorize");
        return "Hello PostAuthorize";
    }

    @GetMapping("PostFilter")
    @PreAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username=='admin'")
    public List<Users> postFilter() {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users(1, "Halo", "Halo"));
        users.add(new Users(2, "admin", "admin"));
        return users;
    }

    @RequestMapping("PreFilter")
    @PreAuthorize("hasAnyAuthority('admins')")
    @PreFilter(value = "filterObject.id%2==0")
    public List<Users> preFilter(@RequestBody List<Users> list) {
        list.forEach(t -> System.out.println(t.getId() + "\t" + t.getUsername()));
        return list;
    }

}
