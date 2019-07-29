package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PayResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int status;        //  返回码
    private String msg;         //  返回码描述
    private String tradeNo;    //  第三方交易号
    private BigDecimal totalAmount;//  交易金额，单位：分
    private Integer channel;		//支付渠道
    private String channelDesc;		//支付渠道描述

	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getChannelDesc() {
		return channelDesc;
	}
	public void setChannelDesc(String channelDesc) {
		this.channelDesc = channelDesc;
	}
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
