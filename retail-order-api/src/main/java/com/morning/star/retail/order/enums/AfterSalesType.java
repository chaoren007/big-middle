package com.morning.star.retail.order.enums;

/**
 * Created by liangguobin on 2017/5/23.
 */
public enum  AfterSalesType {
    REFUND_ITEM(1, "退货售后"),
    EXCHANGE_ITEM(2, "换货售后");

    private Integer code;
    private String desc;

    AfterSalesType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDesc(Integer code) {
        if(code == null) {
            return "";
        }

        for(AfterSalesType status :AfterSalesType.values()) {
            if(status.getCode().equals(code)) {
                return  status.getDesc();
            }
        }
        return "";
    }
}
