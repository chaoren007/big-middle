package com.morning.star.retail.enums;

/**
 * 设备状态（0：未激活 ；1：已激活；2：已锁定）
 *
 * @author jiangyf
 */
public enum SupGoodsTypeEnum {
    LOGISTICS(1, "物流配送"), AUTONOMOUS(2, "自主配送");

    private Integer code;
    private String desc;

    SupGoodsTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupGoodsTypeEnum getEnum(Integer code) {
        for (SupGoodsTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
