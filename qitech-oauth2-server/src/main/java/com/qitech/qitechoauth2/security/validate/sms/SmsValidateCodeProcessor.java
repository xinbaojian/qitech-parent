package com.qitech.qitechoauth2.security.validate.sms;

import com.qitech.qitechoauth2.security.validate.code.AbstractValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 手机验证码处理器
 *
 * @author xinbj
 * @date 2019/12/21 14:42
 */
@Slf4j
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor {

    @Override
    protected void send(ServletWebRequest request, String validateCode) {
        //TODO 发送手机验证码
        log.info("手机验证码发送...");
        log.info("{}手机验证码发送成功，验证码为:{}", request.getParameter("sms"), validateCode);
    }
}
