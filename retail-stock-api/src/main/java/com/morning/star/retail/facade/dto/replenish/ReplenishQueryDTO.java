package com.morning.star.retail.facade.dto.replenish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 补货查询条件Dto
 */
@ApiModel
public class ReplenishQueryDTO implements Serializable {
    private static final long serialVersionUID = -2822886127305845502L;

    @ApiModelProperty(value = "补货单号")
    private String replenishCode;

    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;

    @ApiModelProperty(value = "入库城市")
    private Long cityId;

    @ApiModelProperty(value = "门店编码", hidden = true)
    private String storeCode;

    @ApiModelProperty(value = "集团编码", hidden = true)
    private String groupCode;

    @ApiModelProperty(value = "补货状态（0：待确认，1：已确认，2：驳回）")
    private String status;

    @ApiModelProperty(value = "订单创建开始时间")
    private Date startTime;

    @ApiModelProperty(value = "订单创建结束时间")
    private Date endTime;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    public String getReplenishCode() {
        return replenishCode;
    }

    public void setReplenishCode(String replenishCode) {
        this.replenishCode = replenishCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
