package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/18.
 */
public class ClerkShiftVO implements Serializable {


    private static final long serialVersionUID = 2424337672292884423L;
    /**
     * 记录ID
     */
    private Integer id;

    private String storeCode;

    private String storeName;

    private String surrenderAccount;

    private String surrenderName;

    private String receiverAccount;

    private String receiverName;

    private Date handoverTime;

    private BigDecimal cash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSurrenderAccount() {
        return surrenderAccount;
    }

    public void setSurrenderAccount(String surrenderAccount) {
        this.surrenderAccount = surrenderAccount;
    }

    public String getSurrenderName() {
        return surrenderName;
    }

    public void setSurrenderName(String surrenderName) {
        this.surrenderName = surrenderName;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(Date handoverTime) {
        this.handoverTime = handoverTime;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }
}
