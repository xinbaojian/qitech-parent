package com.qitech.qitechoauth2.security.validate.email;

import com.qitech.qitechoauth2.security.validate.code.AbstractValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author xinbj
 * @date 2019/12/21 14:46
 */
@Slf4j
@Component
public class EmailValidateCodeProcessor extends AbstractValidateCodeProcessor {

    @Override
    protected void send(ServletWebRequest request, String validateCode) {
        //TODO 邮件验证码发送
        log.info("邮件验证码...");
        log.info("{}邮件验证码已发送，验证码为:{}", request.getParameter("email"), validateCode);
    }
}
