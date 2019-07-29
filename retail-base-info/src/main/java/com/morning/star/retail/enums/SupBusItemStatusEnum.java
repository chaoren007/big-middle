package com.morning.star.retail.enums;

/**
 * 设备状态（0：未激活 ；1：已激活；2：已锁定）
 *
 * @author jiangyf
 */
public enum SupBusItemStatusEnum {
    NOTSHIPPED(0, "未发货"), SHIPPED(1, "已发货"), COMPLETED(2, "已完成");

    private Integer code;
    private String desc;

    SupBusItemStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupBusItemStatusEnum getEnum(Integer code) {
        for (SupBusItemStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
