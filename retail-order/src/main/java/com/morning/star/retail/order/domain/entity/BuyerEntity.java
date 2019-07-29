package com.morning.star.retail.order.domain.entity;

import javax.persistence.Column;
import javax.persistence.Comment;


public class BuyerEntity {

    @Comment("购买人编号")
    @Column(length = 36)
    private String buyerCode;

    @Comment("购买者姓名")
    @Column(length = 50)
    private String buyerName;

    @Comment("购买者电话")
    @Column(length = 11)
    private String buyerPhone;

    public BuyerEntity() {
    }

    public BuyerEntity(String buyerCode, String buyerName, String buyerPhone) {
        this.buyerCode = buyerCode;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

}
