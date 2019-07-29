package com.morning.star.retail.stock.dto;

import com.morning.star.retail.consts.RetailDefaultConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 盘点查询
 *
 * @author jiangyf
 */
@ApiModel(value = "盘点查询")
public class InventoryQueryDTO implements Serializable {

    private static final long serialVersionUID = 2489075143023580869L;

    @ApiModelProperty(value = "盘点编码")
    private String inventoryCode;

    @ApiModelProperty(value = "盘点名称")
    private String inventoryName;

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

    @ApiModelProperty(value = "状态（0：正常；1：异常）")
    private Integer status;

    @ApiModelProperty(value = "开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    private String storeCode;

    private String groupCode;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getPageNo() {
        if (pageNo == null) {
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return RetailDefaultConst.ADMIN_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
