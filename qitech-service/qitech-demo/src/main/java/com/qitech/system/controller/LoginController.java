package com.qitech.system.controller;

import com.qitech.system.constant.UrlConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinbj
 * @date 2019/12/21 11:33
 */
@RestController
@RequestMapping(UrlConstant.ROOT + "/oauth")
public class LoginController {


    @PostMapping("/login")
    public String login() {
        return "success";
    }
}
