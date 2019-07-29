package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "供应商-查询")
public class BusSupplyConfireDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

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
    @ApiModelProperty(value = "供货商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供货编码,逗号分隔")
    private String supplyCodes;





    public String getSupplyCodes() {
        return supplyCodes;
    }

    public void setSupplyCodes(String supplyCodes) {
        this.supplyCodes = supplyCodes;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
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
