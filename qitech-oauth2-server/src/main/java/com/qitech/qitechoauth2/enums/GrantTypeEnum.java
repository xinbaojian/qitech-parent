package com.qitech.qitechoauth2.enums;

/**
 * @author xinbj
 * @date 2019/12/21 16:43
 */
public enum GrantTypeEnum {

    /**
     * 手机短信模式
     */
    SMS("手机短信验证登录", "sms"),

    /**
     * 邮箱验证模式
     */
    EMAIL("邮箱验证登录", "email"),
    ;

    private String name;

    private String code;

    GrantTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * 验证是否有验证类型
     *
     * @param code 验证类型
     * @return boolean true 有 false 无
     */
    public static boolean hasGrantType(String code) {
        for (GrantTypeEnum value : GrantTypeEnum.values()) {
            if (value.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
