package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 库存明细
 *
 * @author jiangyf
 */
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = -7369338709416270303L;

    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 订单数量
     */
    private BigDecimal orderNum;
    /**
     * 实际数量
     */
    private BigDecimal realNum;
    /**
     * 采购价
     */
    private BigDecimal purchasePrice;
    /**
     * 单位
     */
    private String units;
    /**
     * 明细
     */
    private List<SupplierItemDTO> supplierItems;

    public ItemDTO() {
    }

    public ItemDTO(String goodsCode, BigDecimal orderNum, BigDecimal realNum, String units) {
        this.goodsCode = goodsCode;
        this.orderNum = orderNum;
        this.realNum = realNum;
        this.units = units;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getRealNum() {
        return realNum;
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public List<SupplierItemDTO> getSupplierItems() {
        return supplierItems;
    }

    public void setSupplierItems(List<SupplierItemDTO> supplierItems) {
        this.supplierItems = supplierItems;
    }
}
