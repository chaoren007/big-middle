package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConfirmRefundDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int channel;
    private int target;     // 1 支付金额退款 2 预付款退款
    private String refundInfo;
    private Integer way;    // 退款方式  1 线下 2线上
    private String refundWaterCode;		//退款流水单号
    private Integer status;
    private BigDecimal refundAmount;  // 退款金额
    private String payRequestNo;    // 退款支付requestNo
    
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        this.channel = channel;
    }
    public String getRefundInfo() {
        return refundInfo;
    }
    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
    }
	public String getRefundWaterCode() {
		return refundWaterCode;
	}
	public void setRefundWaterCode(String refundWaterCode) {
		this.refundWaterCode = refundWaterCode;
	}

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getPayRequestNo() {
        return payRequestNo;
    }

    public void setPayRequestNo(String payRequestNo) {
        this.payRequestNo = payRequestNo;
    }
}
