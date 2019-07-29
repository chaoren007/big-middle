package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "入库单")
public class ReceiptAddDTO implements Serializable {
    private static final long serialVersionUID = 6366465855733174380L;

    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(value = "关联单号")
    private String trackCode;

    @ApiModelProperty(value = "供应商编码(调拨门店编码)")
    private String supplierCode;

    @ApiModelProperty("仓库编码")
    private String warehouseCode;

    @ApiModelProperty(value = "入库类型(0、采购入库 1、退货入库)")
    private Integer receiptType;

    @ApiModelProperty(value = "备注说明")
    private String remark;

    @ApiModelProperty(value = "入库单详情")
    private List<ReceiptItemAddDTO> items;

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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ReceiptItemAddDTO> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItemAddDTO> items) {
        this.items = items;
    }
}
