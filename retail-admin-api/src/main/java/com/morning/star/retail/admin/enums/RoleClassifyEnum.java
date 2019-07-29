package com.morning.star.retail.admin.enums;

/**
 * 分类（store:门店角色，group:集团角色）
 *
 * @author jiangyf
 */
public enum RoleClassifyEnum {
    STORE("store", "门店角色"), GROUP("group", "集团角色");

    private String code;
    private String desc;

    RoleClassifyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RoleClassifyEnum getEnum(String code) {
        for (RoleClassifyEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}