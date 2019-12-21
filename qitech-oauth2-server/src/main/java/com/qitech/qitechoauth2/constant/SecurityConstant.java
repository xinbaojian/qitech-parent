package com.qitech.qitechoauth2.constant;

/**
 * security 相关常量类
 *
 * @author xinbj
 * @date 2019/12/20 16:27
 */
public interface SecurityConstant {

    /**
     * 用户名密码登录请求处理url
     */
    String LOGIN_PROCESSING_URL_FORM = "/auth/login";

    String CODE_SMS_URL = "/api/code/**";
    /**
     * 指纹登录请求处理url
     */
    String LOGIN_PROCESSING_URL_FINGERPRINT = "/auth/fingerprintLogin";
}
