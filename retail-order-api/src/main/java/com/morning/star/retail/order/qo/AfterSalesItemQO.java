package com.morning.star.retail.order.qo;

import java.io.Serializable;

public class AfterSalesItemQO implements Serializable {

    /**
     * 退回数量
     */
    private Integer refundNum;

    /**
     * 货品code
     */
    private String code;

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
