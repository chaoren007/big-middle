package com.morning.star.retail.order.enums;

public enum  RefundWay {

    OFF_LINE(1, "线下退款"),
    ON_LINE(2, "线上退款");

    private Integer code;
    private String desc;

    RefundWay(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
