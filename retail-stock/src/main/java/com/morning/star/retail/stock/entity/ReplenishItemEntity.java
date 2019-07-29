package com.morning.star.retail.stock.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "retail_replenish_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReplenishItemEntity extends BaseEntity {
    private static final long serialVersionUID = 1111320370190733556L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("补货单编码")
    @Column(length = 64)
    private String replenishCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("商品名称")
    @Column(length = 32, nullable = false)
    private String goodsName;

    @Comment("货品编码")
    @Column(length = 32)
    private String productCode;

    @Comment("条形码")
    @Column
    private String upcCode;

    @Comment("单位ID")
    @Column
    private Long unitsId;

    @Comment("单位名称")
    @Column(length = 64)
    private String unitsName;

    @Comment("规格信息")
    @Column
    private String spuInfo;

    @Column(length = 64)
    @Comment("仓库编码")
    private String warehouseCode;

    @Column(length = 64)
    @Comment("仓库名称")
    private String warehouseName;

    @Comment("补货数量")
    @Column(nullable = false, precision = 19, scale = 3)
    private BigDecimal replenishNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplenishCode() {
        return replenishCode;
    }

    public void setReplenishCode(String replenishCode) {
        this.replenishCode = replenishCode;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
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

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public BigDecimal getReplenishNum() {
        return replenishNum;
    }

    public void setReplenishNum(BigDecimal replenishNum) {
        this.replenishNum = replenishNum;
    }
}
