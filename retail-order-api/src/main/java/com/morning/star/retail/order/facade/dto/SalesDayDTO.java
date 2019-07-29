package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2018/1/29.
 */
public class SalesDayDTO implements Serializable {

    private static final long serialVersionUID = 2486487106512911158L;

    //日期
    private String dayTime;
    private BigDecimal amount;

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
