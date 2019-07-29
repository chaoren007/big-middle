package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderActDTO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String actId;
    private String actType;
    private int canUseCoupon;   // 是否可用优惠券 0不可用 1可用
    private String itemCode;
    private String desc;
    
    public String getActId() {
        return actId;
    }
    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getActType() {
        return actType;
    }
    public void setActType(String actType) {
        this.actType = actType;
    }
    public int getCanUseCoupon() {
        return canUseCoupon;
    }
    public void setCanUseCoupon(int canUseCoupon) {
        this.canUseCoupon = canUseCoupon;
    }
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
