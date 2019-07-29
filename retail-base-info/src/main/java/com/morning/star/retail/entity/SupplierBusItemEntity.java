package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "retail_supplier_bus_item")
@Where(clause = "delete_flag <> 1")
public class SupplierBusItemEntity extends BaseEntity {
    private static final long serialVersionUID = -1932115876410624055L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("供应商编码")
    @Column(nullable = false, length = 32)
    private String supplierCode;

    @Comment("供应商名称")
    @Column(nullable = false, length = 32)
    private String supplierName;


    @Comment("供货订单编码")
    @Column(updatable = false, length = 32)
    private String supplyCode;

    @Comment("商品编码")
    @Column(length = 32)
    private String pCode;

    @Comment("商品名称")
    @Column(length = 64)
    private String pName;

    @Comment("供货数量")
    @Column(length = 19)
    private BigDecimal count;

    @Comment("供货价")
    @Column(length = 19)
    private BigDecimal supplyPrice;

    @Comment("供货金额")
    @Column(length = 19)
    private BigDecimal supplyAmount;

    @Comment("供货城市")
    @Column(length = 36)
    private String cityName;

    @Comment("供货城市ID")
    @Column(length = 36)
    private String cityId;

    @Comment("状态 0待发货 1已发货 2已完成")
    @Column(length = 8)
    private Integer status;

    @Comment("期数")
    @Column(length = 64)
    private String priod;

    @Comment("发货单号")
    @Column(length = 255)
    private String shipCode;

    @Comment("发货时间")
    @Column(length = 255)
    private Date shipTime;

    @Comment("服务费率")
    @Column(length = 19)
    private BigDecimal rate;

    @Comment("应付服务费")
    @Column(length = 19)
    private BigDecimal payAmount;

    @Comment("实际因收金额")
    @Column(length = 19)
    private BigDecimal realAmount;

    @Comment("账单生成日期")
    @Column(length = 19)
    private Date orderTime;

    @Comment("仓库编码")
    @Column(length = 64)
    private String depotCode;

    @Comment("仓库名称")
    @Column(length = 64)
    private String depotName;

    @Comment("版本")
    @Column(length = 64)
    private String versionCode;


    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
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

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
