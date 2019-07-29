package com.morning.star.retail.admin.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/20.
 */
public class ClerkShiftBO implements Serializable {
    private static final long serialVersionUID = 5044803589953357538L;

    private String companyCode;

    private String storeCode;

    private String account;

    private String surrenderAccount;

    private String surrenderPassword;

    private String receiverAccount;

    private String receiverPassword;

    private BigDecimal cash;

    private String orderFiled;
    
    private Date handoverTime;
    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 记录数
     */
    private Integer pageSize;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSurrenderAccount() {
        return surrenderAccount;
    }

    public void setSurrenderAccount(String surrenderAccount) {
        this.surrenderAccount = surrenderAccount;
    }

    public String getSurrenderPassword() {
        return surrenderPassword;
    }

    public void setSurrenderPassword(String surrenderPassword) {
        this.surrenderPassword = surrenderPassword;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverPassword() {
        return receiverPassword;
    }

    public void setReceiverPassword(String receiverPassword) {
        this.receiverPassword = receiverPassword;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getOrderFiled() {
        return orderFiled;
    }

    public void setOrderFiled(String orderFiled) {
        this.orderFiled = orderFiled;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public Date getHandoverTime() {
		return handoverTime;
	}

	public void setHandoverTime(Date handoverTime) {
		this.handoverTime = handoverTime;
	}
    
}
