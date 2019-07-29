package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ReceiptQueryDTO implements Serializable {

    private static final long serialVersionUID = -1269462207476501539L;

    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(value = "关联单号（如：采购单号）")
    private String trackCode;

    @ApiModelProperty(value = "入库仓库")
    private String warehouseCode;

    @ApiModelProperty(value = "入库城市")
    private Long cityId;

    @ApiModelProperty(value = "入库类型（0：采购入库，1：退货入库）")
    private Integer type;

    @ApiModelProperty(value = "入库状态(0：未入库，1：已入库)")
    private Integer status;

    @ApiModelProperty(value = "供应商（调拨门店）编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商（调拨门店）名称")
    private String supplierName;

    @ApiModelProperty(value = "开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(hidden = true)
    private String storeCode;

    @ApiModelProperty(hidden = true)
    private String groupCode;

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
