package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusAfterSalesDTO implements Serializable {
    private static final long serialVersionUID = 1213829454950205914L;

    @ApiModelProperty(value = "售后类型")
    private String afterSalesCode;

    @ApiModelProperty("供货单号")
    private String supplyCode;

    @ApiModelProperty("商品ID")
    private String pCode;
    @ApiModelProperty("商品名称")
    private String pName;

    @ApiModelProperty("数量")
    private BigDecimal count;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("售后城市ID")
    private String cityId;
    @ApiModelProperty("售后城市名称")
    private String cityName;

    @ApiModelProperty("售后申请时间")
    private Date afterSalesTime;

    @ApiModelProperty("售后类型-1退货退款 2换货 3补货 4仅退款")
    private Integer afterSalesType;
    @ApiModelProperty("售后类型名称")
    private String afterSalesTypeName;

    @ApiModelProperty("状态0待处理  1已处理")
    private Integer status;
    @ApiModelProperty("状态名称")
    private String statusName;

    @ApiModelProperty("原因")
    private String reason;
    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("凭证地址")
    private String imgPath;

    private BigDecimal price;
    private String brandName;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAfterSalesCode() {
        return afterSalesCode;
    }

    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getAfterSalesTime() {
        return afterSalesTime;
    }

    public void setAfterSalesTime(Date afterSalesTime) {
        this.afterSalesTime = afterSalesTime;
    }

    public Integer getAfterSalesType() {
        return afterSalesType;
    }

    public void setAfterSalesType(Integer afterSalesType) {
        this.afterSalesType = afterSalesType;
    }

    public String getAfterSalesTypeName() {
        return afterSalesTypeName;
    }

    public void setAfterSalesTypeName(String afterSalesTypeName) {
        this.afterSalesTypeName = afterSalesTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
