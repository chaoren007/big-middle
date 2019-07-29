package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.facade.dto.SalesOrderPaymentDTO;

public class SalesOrderPaymentVO implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = 7112152712294805665L;
	private BigDecimal amount;
    private Integer channel;
    private Integer client;
    private String channelDesc;
    private int status;
    private Date payTime;
    private String tradeNo;

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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public static SalesOrderPaymentVO from(SalesOrderPaymentDTO payment) {
        SalesOrderPaymentVO vo = new SalesOrderPaymentVO();
        BeanUtils.copyProperties(payment, vo);
        if(payment.getChannel() != null) {
            PayChannel c = PayChannel.getStatusByCode(payment.getChannel());
            if(c == null) {
                throw new NullPointerException("channel:" + payment.getChannel());
            } else {
                vo.setChannelDesc(c.getDesc());
            }
        }
        return vo;
    }
}
