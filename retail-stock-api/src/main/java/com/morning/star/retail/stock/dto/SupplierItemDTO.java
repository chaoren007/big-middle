package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 入库明细
 *
 * @author jiangyf
 * @date 2017/11/15
 */
public class SupplierItemDTO implements Serializable {
    private static final long serialVersionUID = -92861951599221691L;

    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 销售类型（0：自营；1：代销）
     */
    private Integer salesType;
    /**
     * 下单数量
     */
    private BigDecimal orderNum;
    /**
     * 实际数量
     */
    private BigDecimal realNum;

    public SupplierItemDTO() {
    }

    public SupplierItemDTO(String goodsCode, String supplierCode, String supplierName, Integer salesType, BigDecimal orderNum, BigDecimal realNum) {
        this.goodsCode = goodsCode;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.salesType = salesType;
        this.orderNum = orderNum;
        this.realNum = realNum;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
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

}
