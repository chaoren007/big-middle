package com.morning.star.retail.order.enums;

public enum  RefundTarget {
    AMOUNT(1, "付款金额退款"),
    PREPAY(2, "预付款退款");


    private int code;
    private String desc;

    RefundTarget(int code, String desc) {
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
