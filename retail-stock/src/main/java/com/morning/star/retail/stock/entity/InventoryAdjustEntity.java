package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Comment("盘点调整")
@Table(name = "retail_inventory_adjust")
@Where(clause = "delete_flag <> 1")
@Entity
public class InventoryAdjustEntity extends BaseEntity {
    private static final long serialVersionUID = -8141872529794177353L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("盘点编码")
    @Column(length = 32, nullable = false)
    private String inventoryCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("调整数量")
    @Column(nullable = false)
    private BigDecimal adjustNum;

    @Comment("备注（调整原因）")
    @Column(length = 100)
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getAdjustNum() {
        return adjustNum;
    }

    public void setAdjustNum(BigDecimal adjustNum) {
        this.adjustNum = adjustNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
