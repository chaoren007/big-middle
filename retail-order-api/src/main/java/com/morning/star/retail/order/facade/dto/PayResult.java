package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

import com.morning.star.retail.order.enums.PaymentStatus;

public class PayResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public static PayResult succ() {
        PayResult result = new PayResult();
        result.setStatus(PaymentStatus.PAY_SUCC.getCode());
        return result;
    }
    
    public static PayResult paying() {
        PayResult result = new PayResult();
        result.setStatus(PaymentStatus.PAY_ING.getCode());
        return result;
    }
}
