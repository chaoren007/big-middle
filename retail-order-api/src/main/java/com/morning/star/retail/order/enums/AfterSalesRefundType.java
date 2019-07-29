package com.morning.star.retail.order.enums;

/**
 * Created by liangguobin on 2017/5/22.
 */
public enum  AfterSalesRefundType {
    ALL_REFUND(1, "全部退货"),
    PORTION_REFUND(2, "部分退货"),
    REJECTION(3, "拒收");

    private Integer code;
    private String desc;

    AfterSalesRefundType(Integer code, String desc) {
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
        for(AfterSalesRefundType status :AfterSalesRefundType.values()) {
            if(status.getCode().equals(code)) {
                return  status.getDesc();
            }
        }
        return "";
    }
}
