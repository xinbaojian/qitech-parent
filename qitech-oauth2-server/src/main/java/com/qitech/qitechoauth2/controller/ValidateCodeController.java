package com.qitech.qitechoauth2.controller;

import com.qitech.qitechoauth2.security.validate.code.ValidateCodeProcessorHolder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取验证码接口
 *
 * @author xinbj
 * @date 2019/12/21 15:06
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ValidateCodeController {

    private final @NonNull ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response,
                           @PathVariable("type") String type) throws Exception {
        validateCodeProcessorHolder.
                findValidateCodeProcessor(type)
                .create(new ServletWebRequest(request, response));
    }
}
