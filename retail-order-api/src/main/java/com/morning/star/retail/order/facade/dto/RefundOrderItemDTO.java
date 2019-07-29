package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退货订单信息
 *
 * @author jiangyf
 * @date 2017/12/28
 */
public class RefundOrderItemDTO implements Serializable {
    private static final long serialVersionUID = -1813764090197064548L;

    /**
     * 货品编码
     */
    private String code;

    /**
     * 货品名称
     */
    private String name;
    /**
     * 商品图片
     */
    private String image;

    /**
     * 货品UPC编码
     */
    private String upcCode;

    /**
     * 单价
     */
    private BigDecimal unitPrice;
    
    private BigDecimal originalPrice;       // 原价

    /**
     * 总金额
     */
    private BigDecimal realPrice;

    /**
     * 购买数量
     */
    private BigDecimal buyNum;

    /**
     * 已退货数量
     */
    private BigDecimal refundNum;

    /**
     * 可退货数量
     */
    private BigDecimal canRefundNum;

    private BigDecimal halfPriceNum;
    private BigDecimal canRefundHalfPriceNum;
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(BigDecimal refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getCanRefundNum() {
        return canRefundNum;
    }

    public void setCanRefundNum(BigDecimal canRefundNum) {
        this.canRefundNum = canRefundNum;
    }

    public BigDecimal getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(BigDecimal buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getHalfPriceNum() {
        return halfPriceNum;
    }

    public void setHalfPriceNum(BigDecimal halfPriceNum) {
        this.halfPriceNum = halfPriceNum;
    }

    public BigDecimal getCanRefundHalfPriceNum() {
        return canRefundHalfPriceNum;
    }

    public void setCanRefundHalfPriceNum(BigDecimal canRefundHalfPriceNum) {
        this.canRefundHalfPriceNum = canRefundHalfPriceNum;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }
    
}
