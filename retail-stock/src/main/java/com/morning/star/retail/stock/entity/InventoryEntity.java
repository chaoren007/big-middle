package com.morning.star.retail.stock.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.morning.star.retail.stock.enums.InventoryAuditStatus;
import com.morning.star.retail.stock.enums.InventoryEntryStatus;
import com.morning.star.retail.stock.enums.InventoryReadStatus;
import com.morning.star.retail.stock.enums.InventoryStashStatus;
import com.morning.star.retail.stock.enums.InventoryStatementStatus;
import com.morning.star.retail.stock.enums.InventoryStatus;

@Comment("盘点单")
@Table(name = "retail_inventory")
@Where(clause = "delete_flag <> 1")
@Entity
public class InventoryEntity extends BaseEntity {
    private static final long serialVersionUID = -8141872529794177353L;

    @Id
    @Comment("盘点编码")
    @Column(length = 32)
    private String inventoryCode;

    @Comment("盘点名称")
    @Column(length = 64)
    private String inventoryName;

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

    @Comment("盘点类型（0：抽盘；1：全盘）")
    @Column
    private Integer type;

    @Comment("录入状态（0：未录入；1：已录入）")
    @Column
    @Convert(converter = InventoryEntryStatus.DBConverter.class)
    private InventoryEntryStatus entryStatus;

    @Comment("扎帐状态（0：未扎帐；1：已扎帐）")
    @Column
    @Convert(converter = InventoryStashStatus.DBConverter.class)
    private InventoryStashStatus stashStatus;

    @Comment("盘点长短单状态（0：未生成；1：已生成；2：已确认；3：已存档）")
    @Column
    @Convert(converter = InventoryStatementStatus.DBConverter.class)
    private InventoryStatementStatus statementStatus;

    @Comment("阅读状态（0：未查阅；1：已查阅）")
    @Column
    @Convert(converter = InventoryReadStatus.DBConverter.class)
    private InventoryReadStatus readStatus;

    @Comment("审核状态（0：待审核；1：已审核；2：已驳回）")
    @Column
    @Convert(converter = InventoryAuditStatus.DBConverter.class)
    private InventoryAuditStatus auditStatus;

    @Comment("状态（0：使用中；1：已废弃）")
    @Column
    @Convert(converter = InventoryStatus.DBConverter.class)
    private InventoryStatus status;

    @Comment("备注")
    @Column(length = 100)
    private String remark;

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public InventoryEntryStatus getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(InventoryEntryStatus entryStatus) {
        this.entryStatus = entryStatus;
    }

    public InventoryStashStatus getStashStatus() {
        return stashStatus;
    }

    public void setStashStatus(InventoryStashStatus stashStatus) {
        this.stashStatus = stashStatus;
    }

    public InventoryStatementStatus getStatementStatus() {
        return statementStatus;
    }

    public void setStatementStatus(InventoryStatementStatus statementStatus) {
        this.statementStatus = statementStatus;
    }

    public InventoryReadStatus getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(InventoryReadStatus readStatus) {
        this.readStatus = readStatus;
    }

    public InventoryAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(InventoryAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public InventoryStatus getStatus() {
        return status;
    }

    public void setStatus(InventoryStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
