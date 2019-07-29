package com.morning.star.retail.netty.enums;

/**
 * Created by lenovo on 2017/11/1.
 */
public enum SupplierOperTypeEnum {
    CREATE("C", "增"), READ("R", "查"), UPDATE("U", "改"), DELETE("D", "删");

    private String code;
    private String desc;

    private SupplierOperTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierOperTypeEnum getSupplierOperType(String code) {
        for (SupplierOperTypeEnum supplierOperTypeEnum : values()) {
            if (supplierOperTypeEnum.getCode().equals(code)) {
                return supplierOperTypeEnum;
            }
        }
        return null;
    }
}
