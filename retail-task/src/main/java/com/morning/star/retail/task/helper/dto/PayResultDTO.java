package com.morning.star.retail.task.helper.dto;

/**
 * 支付结果
 * @author Tim
 *
 */
public class PayResultDTO {

    private String tradeNo;     // 支付流水号
    private String payNo;       // 支付订单号
    private String date;        // 支付时间
    private String payMoney;    // 支付金额 单位元
    private String payType;     // 支付类型
    private String account;     // 预留字段 
    private String isPay;       // T已支付，F未支付
    
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getPayNo() {
        return payNo;
    }
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPayMoney() {
        return payMoney;
    }
    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getIsPay() {
        return isPay;
    }
    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public boolean isPaySucc() {
        return "T".equalsIgnoreCase(isPay);
    }
    
    public boolean isPayFail() {
        return false;
    }
    
    public boolean isPaying() {
        return "F".equalsIgnoreCase(isPay);
    }
    
    @Override
    public String toString() {
        return "PayResultDTO [tradeNo=" + tradeNo + ", payNo=" + payNo + ", date=" + date + ", payMoney=" + payMoney
                + ", payType=" + payType + ", account=" + account + ", isPay=" + isPay + "]";
    }
    
}
