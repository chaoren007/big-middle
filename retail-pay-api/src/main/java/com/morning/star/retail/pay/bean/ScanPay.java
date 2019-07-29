package com.morning.star.retail.pay.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.pay.enums.PayChannel;

public class ScanPay implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private PayChannel payChannel;
    
    private int ownerId;
    
    private String merchantCode;		//商户号
    private String terminal_id;			//终端编号
    private String auth_code;			//支付授权码
    private String orderCode;			//订单号
    private String subject;				//商品信息
    private BigDecimal total_amount;	//支付金额（单位分）
    private String deviceIp;			//设备IP
    private String out_trade_no;		//随机字符串（关联订单跟支付的键）
    private String pay_start_time;		//支付开始时间	yyyymmddhhmmss	
    private String pay_timeout;			//支付结束时间	yyyymmddhhmmss
    
    
    
    public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getPay_start_time() {
		return pay_start_time;
	}
	public void setPay_start_time(String pay_start_time) {
		this.pay_start_time = pay_start_time;
	}
	public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getAuth_code() {
        return auth_code;
    }
    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTerminal_id() {
        return terminal_id;
    }
    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }
    public BigDecimal getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }
    public String getPay_timeout() {
        return pay_timeout;
    }
    public void setPay_timeout(String pay_timeout) {
        this.pay_timeout = pay_timeout;
    }
    public PayChannel getPayChannel() {
        return payChannel;
    }
    public void setPayChannel(PayChannel payChannel) {
        this.payChannel = payChannel;
    }
    public String getDeviceIp() {
        return deviceIp;
    }
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    
}
