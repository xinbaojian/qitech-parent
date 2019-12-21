package com.qitech.qitechoauth2.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成
 *
 * @author xinbj
 * @date 2019/12/21 14:50
 */
public interface ValidateCodeGenerator {

    /**
     * 生成验证码
     *
     * @param request 请求
     * @return 生成结果
     */
    String generate(ServletWebRequest request);
}
