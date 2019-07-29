package com.morning.star.retail.pay.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.enums.PayChannel;
import com.morning.star.retail.pay.enums.ScanPayStatus;

public class ScanPayPO {
    private Integer id;
    private Integer payChannel;
    private int ownerId;
    private String merchantCode;
    private String outTradeNo;
    private String tradeNo;
    private String authCode;
    private String subject;
    private String terminalId;
    private BigDecimal totalAmount;
    private String payTimeout;
    private String deviceIp;
    private Date createTime;
    private Date modifyTime;
    private String status;
    private String desc;
    private String orderCode;
    
    
    public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPayChannel() {
        return payChannel;
    }
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    public String getAuthCode() {
        return authCode;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTerminalId() {
        return terminalId;
    }
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getPayTimeout() {
        return payTimeout;
    }
    public void setPayTimeout(String payTimeout) {
        this.payTimeout = payTimeout;
    }
    public String getDeviceIp() {
        return deviceIp;
    }
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getOrderCode() {
        return orderCode;
    }
    
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    
    public ScanPayTradeResult createScanPayTradeResult() {
        if(ScanPayStatus.SUCC.equals(status)) {
            ScanPayTradeResult result = ScanPayTradeResult.succ();
            result.setOut_trade_no(outTradeNo);
            result.setTotal_amount(totalAmount);
            result.setTrade_no(tradeNo);
            result.setPayChannel(PayChannel.get(payChannel));
            return result;
        }
        return new ScanPayTradeResult(status, desc);
    }
    public static ScanPayPO from(ScanPay scanPay) {
        ScanPayPO po = new ScanPayPO();
        po.setTotalAmount(scanPay.getTotal_amount());
        po.setTerminalId(scanPay.getTerminal_id());
        po.setSubject(scanPay.getSubject());
        po.setPayTimeout(scanPay.getPay_timeout());
        po.setOwnerId(scanPay.getOwnerId());
        po.setMerchantCode(scanPay.getMerchantCode());
        po.setDeviceIp(scanPay.getDeviceIp());
        po.setAuthCode(scanPay.getAuth_code());
        po.setOrderCode(scanPay.getOrderCode());
        po.setOutTradeNo(scanPay.getOut_trade_no());
        po.setPayChannel(scanPay.getPayChannel() == null? null : scanPay.getPayChannel().getCode());
        po.setStatus(ScanPayStatus.WAITING);
        po.setCreateTime(new Date());
        po.setModifyTime(new Date());
        return po;
    }
    
}
