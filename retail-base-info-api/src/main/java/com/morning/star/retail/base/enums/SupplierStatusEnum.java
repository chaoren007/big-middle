package com.morning.star.retail.base.enums;

/**
 * 供应商状态
 *
 * @author jiangyf
 */
public enum SupplierStatusEnum {
    ENABLE(0, "启用"), DISABLE(1, "禁用");

    private Integer code;
    private String desc;

    private SupplierStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierStatusEnum getEnum(Integer code) {
        for (SupplierStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
