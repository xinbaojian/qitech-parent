package com.qitech.qitechoauth2.security.validate;

/**
 * 自定义验证码处理器
 *
 * @author xinbj
 * @date 2019/12/21 14:58
 */
public class ValidateCodeException extends RuntimeException {

    public ValidateCodeException(String message) {
        super(message);
    }

}
