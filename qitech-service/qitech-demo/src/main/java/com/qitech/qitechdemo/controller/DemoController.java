package com.qitech.qitechdemo.controller;

import com.qitech.qitechdemo.constant.UrlConstant;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author xinbj
 * @date 2019/12/13 15:19
 */
@RestController
@RequestMapping(UrlConstant.ROOT)
public class DemoController {


    /**
     * 获取当前登录的用户信息
     *
     * @param principal 用户信息
     * @return http 响应
     */
    @GetMapping("/auth/me")
    public HttpEntity<?> oauthMe(Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
