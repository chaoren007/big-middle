package com.morning.star.retail.order.enums;

/**
 * Created by lenovo on 2018/2/2.
 */
public enum BusinessType {
    GOLBAL(0, "全球购业务"), TOHOME(1, "到家业务"), SCAN(2, "扫码购业务"),POS(3, "线下业务");

    private int code;
    private String desc;

    private BusinessType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BusinessType getBusinessType(int code) {
        for (BusinessType businessType : values()) {
            if (businessType.getCode()==code) {
                return businessType;
            }
        }
        return null;
    }
}
