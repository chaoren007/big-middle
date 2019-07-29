package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 外部服务采购dto（推送类型：P1-采购退单,PO-采购入库单）
 */
@ApiModel
public class PurchaseWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "采购入库单号")
    @NotNull(message = "采购入库单号不能为空")
    private String purchaseInCode;

    @ApiModelProperty(required = true, value = "分公司")
    @NotNull(message = "分公司不能为空")
    private String storeCode;

    @ApiModelProperty(required = true, value = "市名")
    @NotNull(message = "市名不能为空")
    private String cityName;

    @ApiModelProperty(required = true, value = "仓库编码")
    @NotNull(message = "仓库编码不能为空")
    private String warehouseCode;

    @ApiModelProperty(required = true, value = "供应商编码")
    @NotNull(message = "供应商不能为空")
    private String supplierCode;

    @ApiModelProperty(required = true, value = "备注")
    @NotNull(message = "备注不能为空")
    private String remark;

    @ApiModelProperty(required = true, value = "预计入库时间(具体到年月日时分秒，月和日之间为空格)")
//    @NotNull(message = "预计入库时间不能为空")
    private String preReceiptDate;

    @ApiModelProperty(required = true, value = "新增或者关闭（I-新增，D-关闭）")
    @NotNull(message = "新增或者关闭不能为空")
    private String flag;

    @ApiModelProperty(required = true, value = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private String createTime;

    @ApiModelProperty(required = true, value = "操作人")
    @NotNull(message = "操作人不能为空")
    private String operatorName;

    @ApiModelProperty(required = true, value = "详情")
    private List<PurchaseDetailWmsDTO> detail;

    @ApiModelProperty(required = true, value = "推送类型：P1-采购退单,PO-采购入库单")
    @NotNull(message = "推送类型不能为空（推送类型：P1-采购退单,PO-采购入库单）")
    private String pushType;

    public String getPurchaseInCode() {
        return purchaseInCode;
    }

    public void setPurchaseInCode(String purchaseInCode) {
        this.purchaseInCode = purchaseInCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPreReceiptDate() {
        return preReceiptDate;
    }

    public void setPreReceiptDate(String preReceiptDate) {
        this.preReceiptDate = preReceiptDate;
    }

    public List<PurchaseDetailWmsDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<PurchaseDetailWmsDTO> detail) {
        this.detail = detail;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }
}
