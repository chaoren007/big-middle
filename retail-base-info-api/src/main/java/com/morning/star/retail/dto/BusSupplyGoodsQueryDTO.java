package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "供应商-查询")
public class BusSupplyGoodsQueryDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "供货单创建时间 begin")
    private Date startTime;
    @ApiModelProperty(value = "供货单创建时间 end")
    private Date endTime;

    @ApiModelProperty(value = "供货单号")
    private String supplyCode;

    @ApiModelProperty(value = "供货商名称")
    private String supplierName;

    @ApiModelProperty(value = "供货商编码")
    private String supplierCode;

    @ApiModelProperty(value = "商品名称")
    private String pName;

    @ApiModelProperty(value = "供货城市")
    private String cityName;

    @ApiModelProperty(value = "结算单号")
    private String payOrder;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "账单生成时间")
    private Date orderTime;

    @ApiModelProperty(value = "是否生成账单")
    private Integer bill;

    @ApiModelProperty(value = "1已出帐 2已结算")
    private Integer payStatus;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;


    public String getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(String payOrder) {
        this.payOrder = payOrder;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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
