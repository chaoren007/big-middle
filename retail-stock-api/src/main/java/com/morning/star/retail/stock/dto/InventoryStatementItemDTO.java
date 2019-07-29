package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("长短单明细")
public class InventoryStatementItemDTO implements Serializable {
    private static final long serialVersionUID = 692695806729879986L;

    @ApiModelProperty("盘点编码")
    private String statementCode;

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("货品编码")
    private String productCode;

    @ApiModelProperty("货品名称")
    private String productName;

    @ApiModelProperty("货架数量")
    private BigDecimal shelfNum;

    @ApiModelProperty("仓库数量")
    private BigDecimal warehouseNum;

    @ApiModelProperty("调整数量")
    private BigDecimal adjustNum;

    @ApiModelProperty("货架调整数量（暂未使用，默认为0）")
    private BigDecimal shelfAdjustNum;

    @ApiModelProperty("仓库调整数量（暂未使用，默认为0）")
    private BigDecimal warehouseAdjustNum;

    @ApiModelProperty("货架合计数量（货架数量+货架调整）")
    private BigDecimal shelfTotalNum;

    @ApiModelProperty("仓库合计数量（仓库数量+仓库调整）")
    private BigDecimal warehouseTotalNum;

    @ApiModelProperty("合计数量（货架数量+仓库数量+调整数量）")
    private BigDecimal totalNum;

    @ApiModelProperty("扎帐（在库）数量")
    private BigDecimal doneInStockNum;

    @ApiModelProperty("长短数量")
    private BigDecimal statementNum;

    @ApiModelProperty("进价")
    private BigDecimal price;

    @ApiModelProperty("总进价")
    private BigDecimal totalPrice;

    @ApiModelProperty("平均进价")
    private BigDecimal averagePrice;

    public String getStatementCode() {
        return statementCode;
    }

    public void setStatementCode(String statementCode) {
        this.statementCode = statementCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(BigDecimal shelfNum) {
        this.shelfNum = shelfNum;
    }

    public BigDecimal getWarehouseNum() {
        return warehouseNum;
    }

    public void setWarehouseNum(BigDecimal warehouseNum) {
        this.warehouseNum = warehouseNum;
    }

    public BigDecimal getAdjustNum() {
        return adjustNum;
    }

    public void setAdjustNum(BigDecimal adjustNum) {
        this.adjustNum = adjustNum;
    }

    public BigDecimal getShelfAdjustNum() {
        return shelfAdjustNum;
    }

    public void setShelfAdjustNum(BigDecimal shelfAdjustNum) {
        this.shelfAdjustNum = shelfAdjustNum;
    }

    public BigDecimal getWarehouseAdjustNum() {
        return warehouseAdjustNum;
    }

    public void setWarehouseAdjustNum(BigDecimal warehouseAdjustNum) {
        this.warehouseAdjustNum = warehouseAdjustNum;
    }

    public BigDecimal getShelfTotalNum() {
        return shelfTotalNum;
    }

    public void setShelfTotalNum(BigDecimal shelfTotalNum) {
        this.shelfTotalNum = shelfTotalNum;
    }

    public BigDecimal getWarehouseTotalNum() {
        return warehouseTotalNum;
    }

    public void setWarehouseTotalNum(BigDecimal warehouseTotalNum) {
        this.warehouseTotalNum = warehouseTotalNum;
    }

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public BigDecimal getStatementNum() {
        return statementNum;
    }

    public void setStatementNum(BigDecimal statementNum) {
        this.statementNum = statementNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }
}
