package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OfflineOrderActivityDTO implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String itemCode;            // 商品编码
    private String activityCode;        // 优惠id/活动id
    private String title;               // 活动描述
    private BigDecimal preferential;    // 优惠金额
    
    
    public String getItemCode() {
        return itemCode;
    }


    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    public String getActivityCode() {
        return activityCode;
    }


    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public BigDecimal getPreferential() {
        return preferential;
    }


    public void setPreferential(BigDecimal preferential) {
        this.preferential = preferential;
    }


}
