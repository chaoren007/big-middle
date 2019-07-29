package com.morning.star.retail.stock.dto;

import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "盘点单")
public class InventoryDTO implements Serializable {
    private static final long serialVersionUID = 730707159029157153L;

    @ApiModelProperty(value = "盘点编码")
    private String inventoryCode;

    @ApiModelProperty(value = "盘点名称")
    private String inventoryName;

    @ApiModelProperty("集团编码")
    private String groupCode;

    @ApiModelProperty("集团名称")
    private String groupName;

    @ApiModelProperty("门店编码")
    private String storeCode;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty(value = "盘点类型（0：抽盘；1：全盘）")
    private Integer type;

    @ApiModelProperty(value = "录入状态（0：未录入；1：已录入）")
    private Integer entryStatus;

    @ApiModelProperty(value = "扎帐状态（0：未扎帐；1：已扎帐）")
    private Integer stashStatus;

    @ApiModelProperty(value = "盘点长短单状态（0：未生成；1：已生成；2：已确认；3：已存档）")
    private Integer statementStatus;

    @ApiModelProperty(value = "阅读状态（0：未查阅；1：已查阅）")
    private Integer readStatus;

    @ApiModelProperty(value = "审核状态（0：未审核；1：审核成功；2：审核失败）")
    private Integer auditStatus;

    @ApiModelProperty(value = "状态（0：使用中；1：已废弃）")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "盘点时间")
    private Date createTime;

    @ApiModelProperty(value = "操作人id")
    private Long operatorId;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    @ApiModelProperty(value = "盘点统计")
    private InventoryStatDTO stat;

    @ApiModelProperty(value = "盘点明细")
    private PageBean<InventoryItemDTO> items;

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

    public Integer getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
    }

    public Integer getStashStatus() {
        return stashStatus;
    }

    public void setStashStatus(Integer stashStatus) {
        this.stashStatus = stashStatus;
    }

    public Integer getStatementStatus() {
        return statementStatus;
    }

    public void setStatementStatus(Integer statementStatus) {
        this.statementStatus = statementStatus;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public InventoryStatDTO getStat() {
        return stat;
    }

    public void setStat(InventoryStatDTO stat) {
        this.stat = stat;
    }

    public PageBean<InventoryItemDTO> getItems() {
        return items;
    }

    public void setItems(PageBean<InventoryItemDTO> items) {
        this.items = items;
    }
}
