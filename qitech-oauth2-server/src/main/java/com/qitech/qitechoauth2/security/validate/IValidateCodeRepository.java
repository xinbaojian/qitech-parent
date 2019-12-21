package com.qitech.qitechoauth2.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码资源处理
 * @author xinbj
 * @date 2019/12/21 15:01
 */
public interface IValidateCodeRepository {

    /**
     * 保存
     *
     * @param request 请求
     * @param code    验证码
     * @param type    类型
     */
    void save(ServletWebRequest request, String code, String type);

    /**
     * 获取
     *
     * @param request 请求
     * @param type    类型
     * @return 验证码
     */
    String get(ServletWebRequest request, String type);

    /**
     * 移除
     *
     * @param request 请求
     * @param type    类型
     */
    void remove(ServletWebRequest request, String type);

}
