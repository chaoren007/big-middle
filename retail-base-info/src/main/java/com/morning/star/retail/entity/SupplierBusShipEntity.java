package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "retail_supplier_bus_ship")
@Where(clause = "delete_flag <> 1")
public class SupplierBusShipEntity extends BaseEntity {
    private static final long serialVersionUID = -1932115876410624055L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment(value = "供应商编码")
    private String supplierCode;
    @Comment(value = "供应商名称")
    private String supplierName;
    @Comment(value = "运货单号")
    private String shipCode;
    @Comment(value = "1物流配送 2自主配送")
    private Integer type;
    @Comment(value = "物流单号")
    private String logisticsCode;
    @Comment(value = "物流公司")
    private String logisticsName;
    @Comment(value = "承运人")
    private String carrier;
    @Comment(value = "承运人电话")
    private String carrierTel;
    @Comment(value = "到货仓库编码")
    private String depotCode;
    @Comment(value = "到货仓库名称")
    private String depotName;
    @Comment(value = "发货时间")
    private Date startTime;
    @Comment(value = "预计到货时间")
    private Date endTime;
    @Comment(value = "发货地址")
    private String address;
    @Comment(value = "供货城市")
    private String cityId;
    @Comment(value = "供货城市名称")
    private String cityName;


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
