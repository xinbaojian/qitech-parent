package com.qitech.qitechoauth2.security.validate.sms;

import cn.hutool.core.util.RandomUtil;
import com.qitech.qitechoauth2.security.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 手机验证码生成器
 *
 * @author xinbj
 * @date 2019/12/21 14:51
 */
@Component
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    /**
     * 生成手机验证码逻辑
     *
     * @param request 请求
     * @return
     */
    @Override
    public String generate(ServletWebRequest request) {
        return RandomUtil.randomNumbers(6);
    }
}
