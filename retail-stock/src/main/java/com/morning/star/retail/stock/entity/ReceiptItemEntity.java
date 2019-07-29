package com.morning.star.retail.stock.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "retail_receipt_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReceiptItemEntity extends BaseEntity {
    private static final long serialVersionUID = 6366465855733174380L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 64)
    @Comment(value = "入库单号")
    private String receiptCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("商品名称")
    @Column(length = 32, nullable = false)
    private String goodsName;

    @Comment("条形码")
    @Column
    private String upcCode;

    @Column(length = 64)
    @Comment(value = "货品编码")
    private String productCode;

    @Column(length = 128)
    @Comment(value = "货品名称")
    private String productName;

    @Comment("规格信息")
    @Column(length = 64, updatable = false)
    private String spuInfo;

    @Comment(value = "货品类型:SP-单品,PP-套装")
    @Column
    private String productType;

    @Comment(value = "包装数量")
    @Column
    private Integer packSpecNum;

    @Comment(value = "包装单位")
    @Column
    private String packSpecUnits;

    @Column(length = 20)
    @Comment(value = "单位id")
    private Long unitsId;

    @Column(length = 64)
    @Comment(value = "单位名称")
    private String unitsName;

    @Comment("标准类型（0：非称重，1：称重）")
    @Column(length = 1)
    private Integer standardType;

    @Column(precision = 19, scale = 3)
    @Comment(value = "需要入库数量")
    private BigDecimal needNum;

    @Column(precision = 19, scale = 3)
    @Comment(value = "实收入库数量")
    private BigDecimal realNum;

    @Comment("库存成本（不含税）")
    @Column
    private BigDecimal totalCost;

    @Comment("库存成本（含税）")
    @Column
    private BigDecimal totalTaxCost;

    @Comment(value = "保质期")
    @Column
    private Integer shelfLife;

    @Comment(value = "生产日期")
    @Column
    private Date productionDate;

    @Comment(value = "过期日期")
    @Column
    private Date expirationDate;

    @Comment(value = "备注说明")
    @Column
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
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

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getPackSpecNum() {
        return packSpecNum;
    }

    public void setPackSpecNum(Integer packSpecNum) {
        this.packSpecNum = packSpecNum;
    }

    public String getPackSpecUnits() {
        return packSpecUnits;
    }

    public void setPackSpecUnits(String packSpecUnits) {
        this.packSpecUnits = packSpecUnits;
    }

    public Long getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Long unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public BigDecimal getNeedNum() {
        return needNum;
    }

    public void setNeedNum(BigDecimal needNum) {
        this.needNum = needNum;
    }

    public BigDecimal getRealNum() {
        return realNum;
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalTaxCost() {
        return totalTaxCost;
    }

    public void setTotalTaxCost(BigDecimal totalTaxCost) {
        this.totalTaxCost = totalTaxCost;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
