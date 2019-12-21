package com.qitech.qitechoauth2.constant;

import cn.hutool.core.map.MapUtil;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 获取验证码URL
     */
    String CODE_SMS_URL = "/api/code/**";

    String CUSTOM_OAUTH_URL_PATTERN = "/custom/oauth/**";

    /**
     * 指纹登录请求处理url
     */
    String LOGIN_PROCESSING_URL_FINGERPRINT = "/auth/fingerprintLogin";

    /**
     * Authorization header
     */
    String BASIC_TYPE = "basic ";

    /**
     * Authorization
     */
    String AUTHORIZATION = "Authorization";

}
