package com.qitech.qitechoauth2.security.validate.email;

import cn.hutool.core.util.RandomUtil;
import com.qitech.qitechoauth2.security.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 邮件验证码生成器
 *
 * @author xinbj
 * @date 2019/12/21 14:53
 */
@Component
public class EmailValidateCodeGenerator implements ValidateCodeGenerator {

    /**
     * 邮件验证码生成
     *
     * @param request 请求
     * @return
     */
    @Override
    public String generate(ServletWebRequest request) {
        return RandomUtil.randomString(6);
    }
}
