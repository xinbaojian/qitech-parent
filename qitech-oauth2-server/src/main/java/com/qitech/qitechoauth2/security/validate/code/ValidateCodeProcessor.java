package com.qitech.qitechoauth2.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码 创建 验证接口抽象
 * 抽象策略
 *
 * @author xinbj
 * @date 2019/12/21 14:01
 */
public interface ValidateCodeProcessor {

    /**
     * 创建验证码
     *
     * @param target 创建验证码的对象
     * @throws Exception 异常
     */
    void create(ServletWebRequest target) throws Exception;

    /**
     * 验证验证码
     *
     * @param target 验证验证码的对象
     */
    void validate(ServletWebRequest  target);
}
