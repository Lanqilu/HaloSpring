package com.halo.csrfsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author HALO
 */
@Controller
public class LoginController {
    @GetMapping("/userLogin")
    public String login() {
        return "login/login";
    }
}
