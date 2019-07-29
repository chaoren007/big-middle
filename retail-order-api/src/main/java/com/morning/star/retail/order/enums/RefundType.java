package com.morning.star.retail.order.enums;

public enum RefundType {
    CANCEL_REFUND(0, "取消退款"),
    AFTER_SALES_REFUND(1, "售后退款");

    private int code;
    private String desc;

    RefundType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
