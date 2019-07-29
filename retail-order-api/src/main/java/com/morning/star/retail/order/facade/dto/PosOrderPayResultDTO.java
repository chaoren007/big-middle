package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PosOrderPayResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    List<PayResultDTO>  payResultDTOS;
    private String  orderCode;
    private BigDecimal paid;
    private BigDecimal unaid;
    public List<PayResultDTO> getPayResultDTOS() {
        return payResultDTOS;
    }

    public void setPayResultDTOS(List<PayResultDTO> payResultDTOS) {
        this.payResultDTOS = payResultDTOS;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getUnaid() {
        return unaid;
    }

    public void setUnaid(BigDecimal unaid) {
        this.unaid = unaid;
    }
}
