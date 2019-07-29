package com.morning.star.retail.enums;

/**
 * 供应商变更类型
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum SupplierChangeTypeEnum {
    PUT_ON(0, "增加"),
    PUT_OFF(1, "取消");

    private Integer code;
    private String desc;

    SupplierChangeTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierChangeTypeEnum getEnum(Integer code) {
        for (SupplierChangeTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
