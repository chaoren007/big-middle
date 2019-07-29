package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SalesOrderPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String code;
    private BigDecimal amount;
    private Integer channel;
    private Integer client;
    private int status;
    private Date payTime;
    private String tradeNo;
    
    
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getAmount() {
        return amount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    
}
