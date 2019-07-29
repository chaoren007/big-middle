package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

import com.morning.star.retail.order.enums.ClientType;
import com.morning.star.retail.order.enums.PayChannel;

public class StartPayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private PayChannel payChannel;
    private ClientType clientType;
    private String callBackUrl;
    private String openId;
    private String resource;
    private boolean newAli;
    
    public PayChannel getPayChannel() {
        return payChannel;
    }
    public void setPayChannel(PayChannel payChannel) {
        this.payChannel = payChannel;
    }
    public ClientType getClientType() {
        return clientType;
    }
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
    public String getCallBackUrl() {
        return callBackUrl;
    }
    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public boolean isNewAli() {
        return newAli;
    }
    public void setNewAli(boolean newAli) {
        this.newAli = newAli;
    }
    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
    
}
