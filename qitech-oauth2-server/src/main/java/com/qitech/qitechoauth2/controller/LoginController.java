package com.qitech.qitechoauth2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinbj
 * @date 2019/12/20 15:34
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @PostMapping("/login")
    public String login() {
        return "123";
    }
}
