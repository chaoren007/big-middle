package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "运营端发货单详情")
public class BusSupplyGoodsDetailDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "运营点编码")
    private String opc;

    @ApiModelProperty(value = "供货编码")
    private String supplyCode;

    @ApiModelProperty(value = "商品编码")
    private String pCode;

    @ApiModelProperty(value = "商品名称")
    private String pName;

    @ApiModelProperty(value = "仓库编码")
    private String depotCode;

    @ApiModelProperty(value = "仓库")
    private String depotName;

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

    @ApiModelProperty(value = "订单编码")
    private String orderNo;

    @ApiModelProperty(value = "状态 0待发货 1已发货 2已完成")
    private Integer status;

    @ApiModelProperty(value = "状态 0待发货 1已发货 2已完成")
    private String statusName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "单位")
    private String unitName;

    private BusShipGoodsDTO busShipGoodsDTO;


    public BusShipGoodsDTO getBusShipGoodsDTO() {
        return busShipGoodsDTO;
    }

    public void setBusShipGoodsDTO(BusShipGoodsDTO busShipGoodsDTO) {
        this.busShipGoodsDTO = busShipGoodsDTO;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
