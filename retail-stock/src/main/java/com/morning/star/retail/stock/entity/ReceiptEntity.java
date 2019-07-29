package com.morning.star.retail.stock.entity;

import com.morning.star.retail.stock.enums.ReceiptStatusEnum;
import com.morning.star.retail.stock.enums.ReceiptTypeEnum;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Table(name = "retail_receipt")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReceiptEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 64)
    @Comment(value = "入库单号")
    private String receiptCode;

    @Column(length = 64)
    @Comment(value = "关联单号")
    private String trackCode;

    @Column(length = 64)
    @Comment(value = "供应商编码(调拨门店编码)")
    private String supplierCode;

    @Column(length = 64)
    @Comment(value = "供应商名称(调拨门店名称)")
    private String supplierName;

    @Column(length = 64)
    @Comment("仓库编码")
    private String warehouseCode;

    @Column(length = 64)
    @Comment("仓库名称")
    private String warehouseName;

    @Column
    @Comment("城市id")
    private Long cityId;

    @Column(length = 16)
    @Comment("城市名称")
    private String cityName;

    @Column(length = 64)
    @Comment(value = "门店编码")
    private String storeCode;

    @Column(length = 64)
    @Comment(value = "门店名称")
    private String storeName;

    @Column(length = 64)
    @Comment(value = "集团编码")
    private String groupCode;

    @Column(length = 64)
    @Comment(value = "集团名称")
    private String groupName;

    @Convert(converter = ReceiptTypeEnum.DBConverter.class)
    @Comment(value = "入库类型（0：采购入库，1：退货入库）")
    private ReceiptTypeEnum type;

    @Convert(converter = ReceiptStatusEnum.DBConverter.class)
    @Comment(value = "入库状态(0：未入库，1：已入库)")
    private ReceiptStatusEnum status;

    @Comment(value = "入库时间")
    private Date receiptTime;

    @Comment(value = "备注说明")
    private String remark;

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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ReceiptTypeEnum getType() {
        return type;
    }

    public void setType(ReceiptTypeEnum type) {
        this.type = type;
    }

    public ReceiptStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReceiptStatusEnum status) {
        this.status = status;
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
