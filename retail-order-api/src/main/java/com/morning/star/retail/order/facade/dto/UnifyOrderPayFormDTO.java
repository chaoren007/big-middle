package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 聚合支付提交的信息
 *
 * @author Administrator
 */
public class UnifyOrderPayFormDTO implements Serializable {

    private static final long serialVersionUID = 2553347437153227988L;
    @ApiModelProperty(value = "授权码", required = true)
    private String authCode;    //授权码
    @ApiModelProperty(value = "终端ip", required = true)
    private String deviceIp;    // 终端ip
    @ApiModelProperty(value = "终端编号", required = true)
    private String terminalId;  // 终端编号
    @ApiModelProperty(value = "订单号", required = true)
    private String orderCode;
    @ApiModelProperty(value = "支付金额", required = true)
    private BigDecimal paid;    //支付金额

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }
}
