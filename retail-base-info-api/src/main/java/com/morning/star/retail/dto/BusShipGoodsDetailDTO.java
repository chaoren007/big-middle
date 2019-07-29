package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "运营端送货单详情")
public class BusShipGoodsDetailDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;
    @ApiModelProperty(value = "供应商编码")
    private String supplierName;
    @ApiModelProperty(value = "送货单号")
    private String shipCode;
    @ApiModelProperty(value = "1物流配送 2自主配送")
    private Integer type;
    @ApiModelProperty(value = "物流单号")
    private String logisticsCode;
    @ApiModelProperty(value = "物流公司")
    private String logisticsName;
    @ApiModelProperty(value = "承运人")
    private String carrier;
    @ApiModelProperty(value = "承运人电话")
    private String carrierTel;
    @ApiModelProperty(value = "到货仓库编码")
    private String depotCode;
    @ApiModelProperty(value = "到货仓库名称")
    private String depotName;
    @ApiModelProperty(value = "发货时间")
    private Date startTime;
    @ApiModelProperty(value = "预计到货时间")
    private Date endTime;
    @ApiModelProperty(value = "发货地址")
    private String address;
    @ApiModelProperty(value = "供货城市")
    private String cityId;
    @ApiModelProperty(value = "供货城市名称")
    private String cityName;

    @ApiModelProperty(value = "商品明细")
    private List<BusSupplyGoodsDTO> list;



    public List<BusSupplyGoodsDTO> getList() {
        return list;
    }

    public void setList(List<BusSupplyGoodsDTO> list) {
        this.list = list;
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

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierTel() {
        return carrierTel;
    }

    public void setCarrierTel(String carrierTel) {
        this.carrierTel = carrierTel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
