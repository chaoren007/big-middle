package com.morning.star.retail.pay.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 聚合支付退款
 * @author Administrator
 *
 */
public class ScanRefund {

	private Long id;		//记录id
	private String code;	//退款编号
	private String transactionId;	//平台退款编号
	private String merchantCode;	//商户号
	private String orderCode;		//订单号
	private String payBillCode;		//原支付单号
	private BigDecimal refundAmount;	//退款金额
	private Integer refundChannel;		//退款渠道
	private String status;				//退款状态		退款状态 SUCC、FAIL、REFUNDING、ERROR
	private String remark;				//退款备注		
	private String type;				//退款类型   REVOKE-撤销    REFUND-退款
	private Date createTime;			//创建时间
	private Date modifyTime;			//修改时间
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPayBillCode() {
		return payBillCode;
	}
	public void setPayBillCode(String payBillCode) {
		this.payBillCode = payBillCode;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public Integer getRefundChannel() {
		return refundChannel;
	}
	public void setRefundChannel(Integer refundChannel) {
		this.refundChannel = refundChannel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	
	
	
}
