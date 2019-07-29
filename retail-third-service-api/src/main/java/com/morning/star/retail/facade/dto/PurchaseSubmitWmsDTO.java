package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务采购dto（推送类型：P1-采购退单,PO-采购入库单）
 */
@ApiModel
public class PurchaseSubmitWmsDTO implements Serializable {
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

	@ApiModelProperty(required = true, value = "创建时间")
	@NotNull(message = "创建时间不能为空")
	private String createTime;

	@ApiModelProperty(required = true, value = "操作人")
	@NotNull(message = "操作人不能为空")
	private String operatorName;

	@Valid
	@ApiModelProperty(required = true, value = "详情")
	private List<PurchaseDetailSubmitWmsDTO> detail;

	public PurchaseSubmitWmsDTO() {
	}

	public PurchaseSubmitWmsDTO(String purchaseInCode, String storeCode, String cityName, String warehouseCode, String supplierCode, String remark, String createTime, String operatorName, List<PurchaseDetailSubmitWmsDTO> detail) {
		this.purchaseInCode = purchaseInCode;
		this.storeCode = storeCode;
		this.cityName = cityName;
		this.warehouseCode = warehouseCode;
		this.supplierCode = supplierCode;
		this.remark = remark;
		this.createTime = createTime;
		this.operatorName = operatorName;
		this.detail = detail;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public List<PurchaseDetailSubmitWmsDTO> getDetail() {
		return detail;
	}

	public void setDetail(List<PurchaseDetailSubmitWmsDTO> detail) {
		this.detail = detail;
	}
}
