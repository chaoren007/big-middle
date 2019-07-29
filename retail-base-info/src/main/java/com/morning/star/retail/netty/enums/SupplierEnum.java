package com.morning.star.retail.netty.enums;

/**
 * 供应商
 *
 * @author obama
 */
public enum SupplierEnum {
    SELF_SUPPORT("0", "自营");

    private String code;
    private String desc;

    private SupplierEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierEnum get(String code) {
        for (SupplierEnum e : values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
