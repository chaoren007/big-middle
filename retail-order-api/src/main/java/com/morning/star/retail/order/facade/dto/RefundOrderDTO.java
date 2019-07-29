package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 退货订单信息
 *
 * @author jiangyf
 * @date 2017/12/28
 */
public class RefundOrderDTO implements Serializable {
    private static final long serialVersionUID = -8941884770625084515L;

    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品金额
     */
    private BigDecimal totalPrice;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 支付渠道
     */
    private Integer paymentChannel;
    /**
     * 支付渠道
     */
    private String paymentChannelDesc;
    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;
    /**
     * 预付卡支付状态（0：未使用；1：已使用）
     */
    private Integer prepayCardStatus;
    /**
     * 预付卡支付金额
     */
    private BigDecimal prepayCardAmount;
    /**
     * 订单明细
     */
    private List<RefundOrderItemDTO> items;

    public RefundOrderDTO() {
    }

    public RefundOrderDTO(String orderCode, BigDecimal totalPrice, BigDecimal payAmount, Integer paymentChannel, BigDecimal paymentAmount, Integer prepayCardStatus, BigDecimal prepayCardAmount, List<RefundOrderItemDTO> items) {
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.payAmount = payAmount;
        this.paymentChannel = paymentChannel;
        this.paymentAmount = paymentAmount;
        this.prepayCardStatus = prepayCardStatus;
        this.prepayCardAmount = prepayCardAmount;
        this.items = items;
    }

    public static RefundOrderDTO of(String orderCode, BigDecimal totalPrice, BigDecimal payAmount, Integer paymentChannel, BigDecimal paymentAmount, Integer prepayCardStatus, BigDecimal prepayCardAmount, List<RefundOrderItemDTO> items) {
        return new RefundOrderDTO(orderCode, totalPrice, payAmount, paymentChannel, paymentAmount, prepayCardStatus, prepayCardAmount, items);
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(Integer paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getPaymentChannelDesc() {
        return paymentChannelDesc;
    }

    public void setPaymentChannelDesc(String paymentChannelDesc) {
        this.paymentChannelDesc = paymentChannelDesc;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getPrepayCardStatus() {
        return prepayCardStatus;
    }

    public void setPrepayCardStatus(Integer prepayCardStatus) {
        this.prepayCardStatus = prepayCardStatus;
    }

    public BigDecimal getPrepayCardAmount() {
        return prepayCardAmount;
    }

    public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
        this.prepayCardAmount = prepayCardAmount;
    }

    public List<RefundOrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<RefundOrderItemDTO> items) {
        this.items = items;
    }
}
