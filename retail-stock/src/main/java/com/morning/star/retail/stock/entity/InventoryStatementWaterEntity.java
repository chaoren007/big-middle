package com.morning.star.retail.stock.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.morning.star.retail.stock.enums.InventoryStatementStatus;
import com.morning.star.retail.stock.enums.InventoryStatementType;

@Comment("长短单流水")
@Table(name = "retail_statement_water")
@Entity
public class InventoryStatementWaterEntity extends WaterEntity {
    private static final long serialVersionUID = -8141872529794177353L;

    @Comment("编码")
    @Column(length = 32)
    private String statementCode;

    @Comment("盘点编码")
    @Column(length = 32)
    private String inventoryCode;

    @Comment("集团编码")
    @Column(length = 64, updatable = false)
    private String groupCode;

    @Comment("集团名称")
    @Column(length = 64)
    private String groupName;

    @Comment("门店编码")
    @Column(length = 64, updatable = false)
    private String storeCode;

    @Comment("门店名称")
    @Column(length = 64)
    private String storeName;

    @Comment("类型（0：长货；1；短货）")
    @Column
    @Convert(converter = InventoryStatementType.DBConverter.class)
    private InventoryStatementType type;

    @Comment("盘点长短单状态（0：未生成；1：已生成；2：已确认；3：已存档）")
    @Column
    @Convert(converter = InventoryStatementStatus.DBConverter.class)
    private InventoryStatementStatus status;

    @Comment("备注")
    @Column(length = 100)
    private String remark;

    public String getStatementCode() {
        return statementCode;
    }

    public void setStatementCode(String statementCode) {
        this.statementCode = statementCode;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public InventoryStatementType getType() {
        return type;
    }

    public void setType(InventoryStatementType type) {
        this.type = type;
    }

    public InventoryStatementStatus getStatus() {
        return status;
    }

    public void setStatus(InventoryStatementStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
