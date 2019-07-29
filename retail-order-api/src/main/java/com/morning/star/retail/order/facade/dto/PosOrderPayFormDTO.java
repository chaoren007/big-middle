package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

import com.morning.star.retail.order.enums.PayChannel;

public class PosOrderPayFormDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private PayChannel payChannel;
    private String authCode;
    private String deviceIp;    // 终端ip
    private String terminalId;  // 终端编号
    
    
    public PayChannel getPayChannel() {
        return payChannel;
    }
    public void setPayChannel(PayChannel payChannel) {
        this.payChannel = payChannel;
    }
    public String getAuthCode() {
        return authCode;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public String getDeviceIp() {
        return deviceIp;
    }
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }
    public String getTerminalId() {
        return terminalId;
    }
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    
}
