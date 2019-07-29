package com.morning.star.retail.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/18.
 */
public class ClerkShiftVO implements Serializable {
    private static final long serialVersionUID = -2466949220078053690L;

    /**
     * 记录ID
     */
    private Integer id;

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
