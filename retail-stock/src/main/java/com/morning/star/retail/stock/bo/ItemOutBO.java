package com.morning.star.retail.stock.bo;

import java.math.BigDecimal;

/**
 * 出库物品
 *
 * @author Tim
 */
public class ItemOutBO {

    // private String goodsName;
    // private String goodsUnit;
    // private String goodsSpec;
    private String goodsId; // 货品编号
    private String serialId; // 序列号
    private String barCode; // 条形码
    private String orderId; // 订单编号
    private String logisticsId; // 物流单号
    private BigDecimal sellingPrice;// 售价
    private BigDecimal salesPrice; // 销售指导价

    private boolean serialCode; // 是否序列号管理

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public boolean isSerialCode() {
        return serialCode;
    }

    public void setSerialCode(boolean serialCode) {
        this.serialCode = serialCode;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }


}
