package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 线下扫码付款提交的信息
 * @author Administrator
 *
 */
public class OfflineOrderPayFormDTO implements Serializable {
	private static final long serialVersionUID = -4047030548096027356L;

	private String operatorCode;		//操作人编码
	private String operatorName;		//操作人名字

	private String terminalCode;		//终端编号
	private String terminalHost;		//终端的IP
	private String authCode;			//支付授权码
	private String orderCode;			//订单号
	private BigDecimal paid;           //支付金额
	
	
	/**
	 * 校验交易参数是否正确
	 * @return
	 */
	public Boolean isCheckParamSucc(){
		if(this.operatorCode == null || this.operatorName == null 
				|| this.terminalCode == null || this.terminalHost == null
				|| this.orderCode == null || this.authCode == null){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}


	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getTerminalCode() {
		return terminalCode;
	}
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}
	public String getTerminalHost() {
		return terminalHost;
	}
	public void setTerminalHost(String terminalHost) {
		this.terminalHost = terminalHost;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	
}
