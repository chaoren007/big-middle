package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Comment("长短单明细")
@Table(name = "retail_statement_item")
@Entity
public class InventoryStatementItemEntity extends BaseEntity {
    private static final long serialVersionUID = 692695806729879986L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("盘点编码")
    @Column(length = 32)
    private String statementCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("货品编码")
    @Column(length = 32, nullable = false)
    private String productCode;

    @Comment("货品名称")
    @Column(length = 200, nullable = false)
    private String productName;

    @Comment("货架数量")
    @Column
    private BigDecimal shelfNum;

    @Comment("仓库数量")
    @Column
    private BigDecimal warehouseNum;

    @Comment("调整数量")
    @Column
    private BigDecimal adjustNum;

    @Comment("货架调整数量（暂未使用，默认为0）")
    @Column
    private BigDecimal shelfAdjustNum;

    @Comment("仓库调整数量（暂未使用，默认为0）")
    @Column
    private BigDecimal warehouseAdjustNum;

    @Comment("货架合计数量（货架数量+货架调整）")
    @Column
    private BigDecimal shelfTotalNum;

    @Comment("仓库合计数量（仓库数量+仓库调整）")
    @Column
    private BigDecimal warehouseTotalNum;

    @Comment("合计数量（货架数量+仓库数量+调整数量）")
    @Column
    private BigDecimal totalNum;

    @Comment("扎帐（在库）数量")
    @Column
    private BigDecimal doneInStockNum;

    @Comment("长短数量")
    @Column
    private BigDecimal statementNum;

    @Comment("进价")
    @Column
    private BigDecimal price;

    @Comment("总进价")
    @Column
    private BigDecimal totalPrice;

    @Comment("平均进价")
    @Column
    private BigDecimal averagePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
