package com.morning.star.retail.order.facade.order.dto;

import java.io.Serializable;

public class BuyerDTO implements Serializable {
    private String buyerCode;
    private String buyerName;
    private String buyerPhone;

    public BuyerDTO(String buyerCode, String buyerName, String buyerPhone) {
        this.buyerCode = buyerCode;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
    }

    public BuyerDTO(){};

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
