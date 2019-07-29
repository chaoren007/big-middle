package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/12/28.
 */
public class ClerkShiftDetailDO implements Serializable {

    private static final long serialVersionUID = 6213978248938410136L;
    private Integer shiftRecordId;
    private Integer payment;
    private String paymentName;
    private Integer type;
    private Integer num;
    private BigDecimal amount;

    public Integer getShiftRecordId() {
        return shiftRecordId;
    }

    public void setShiftRecordId(Integer shiftRecordId) {
        this.shiftRecordId = shiftRecordId;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
