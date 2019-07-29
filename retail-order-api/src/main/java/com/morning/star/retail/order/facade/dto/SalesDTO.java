package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal amount;
    private int num;
    
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
    
}
