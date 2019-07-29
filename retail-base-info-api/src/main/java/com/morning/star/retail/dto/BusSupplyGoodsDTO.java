package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "运营端供货列表")
public class BusSupplyGoodsDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "供货订单编码")
    private String supplyCode;

    @ApiModelProperty(value = "商品编码")
    private String pCode;

    @ApiModelProperty(value = "商品名称")
    private String pName;

    @ApiModelProperty(value = "商品版本")
    private String versionCode;

    @ApiModelProperty(value = "供货数量")
    private BigDecimal count;

    @ApiModelProperty(value = "供货价")
    private BigDecimal supplyPrice;

    @ApiModelProperty(value = "供货金额")
    private BigDecimal supplyAmount;

    @ApiModelProperty(value = "供货城市")
    private String cityName;

    @ApiModelProperty(value = "供货城市ID")
    private String cityId;

    @ApiModelProperty(value = "状态 0待发货 1已发货 2已完成")
    private Integer status;

    @ApiModelProperty(value = "状态 0待发货 1已发货 2已完成")
    private String statusName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "期数")
    private String priod;

    @ApiModelProperty(value = "交易时间")
    private Date shipTime;

    @ApiModelProperty(value = "服务费率")
    private BigDecimal rate;

    @ApiModelProperty(value = "服务费")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "应收费用")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "账单生成时间")
    private Date orderTime;

    @ApiModelProperty(value = "结算单号")
    private String payOrder;

    @ApiModelProperty(value = "交易类型")
    private String typeFrom;


    @ApiModelProperty("仓库编码")
    private String depotCode;

    @ApiModelProperty("仓库编码")
    private String depotName;

    public String getDepotCode() {
        return depotCode;
    }

    public void setDepotCode(String depotCode) {
        this.depotCode = depotCode;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getTypeFrom() {
        return typeFrom;
    }

    public void setTypeFrom(String typeFrom) {
        this.typeFrom = typeFrom;
    }

    public String getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(String payOrder) {
        this.payOrder = payOrder;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }



    public String getPriod() {
        return priod;
    }

    public void setPriod(String priod) {
        this.priod = priod;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
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

    public BigDecimal getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(BigDecimal supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public BigDecimal getSupplyAmount() {
        return supplyAmount;
    }

    public void setSupplyAmount(BigDecimal supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
