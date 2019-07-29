package com.morning.star.retail.base.enums;

/**
 * 供应商状态
 *
 * @author jiangyf
 */
public enum SupplierTypeEnum {
    HEAD(0, "总部"), BRANCH(1, "分支");

    private Integer code;
    private String desc;

    SupplierTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierTypeEnum getEnum(Integer code) {
        for (SupplierTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
