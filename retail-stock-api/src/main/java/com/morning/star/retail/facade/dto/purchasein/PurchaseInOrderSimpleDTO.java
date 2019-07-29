package com.morning.star.retail.facade.dto.purchasein;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class PurchaseInOrderSimpleDTO implements Serializable {

	private static final long serialVersionUID = 4955457147471318782L;

	@ApiModelProperty(value = "采购入库单号")
	private String purchaseInCode;

	@ApiModelProperty(value = "采购单编码")
	private String purchaseCode;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty("预计入库时间")
	private Date preReceiptDate;

	@ApiModelProperty(value = "创建人编码")
	private String creatorId;

	@ApiModelProperty(value = "创建人名字")
	private String creatorName;

	@ApiModelProperty(value = "市")
	private Long cityId;

	@ApiModelProperty(value = "市名")
	private String cityName;

	@ApiModelProperty("仓库市")
	private Long warehouseCityId;

	@ApiModelProperty("仓库市名")
	private String warehouseCityName;

	@ApiModelProperty("仓库编码")
	private String warehouseCode;

	@ApiModelProperty("仓库名称")
	private String warehouseName;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名字")
	private String supplierName;

	@ApiModelProperty(value = "采购总金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "采购总金额(含税)")
	private BigDecimal rateAmount;

	@ApiModelProperty(value = "采购单状态")
	private Integer status;

	@ApiModelProperty(value = "采购单提交类型 10:集采 20:区采")
	private Integer submitType;

	@ApiModelProperty(value = "采购单状态名")
	private String statusName;

	public String getPurchaseInCode() {
		return purchaseInCode;
	}

	public void setPurchaseInCode(String purchaseInCode) {
		this.purchaseInCode = purchaseInCode;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public Integer getSubmitType() {
		return submitType;
	}

	public void setSubmitType(Integer submitType) {
		this.submitType = submitType;
	}

	public Date getPreReceiptDate() {
		return preReceiptDate;
	}

	public void setPreReceiptDate(Date preReceiptDate) {
		this.preReceiptDate = preReceiptDate;
	}

	public Long getWarehouseCityId() {
		return warehouseCityId;
	}

	public void setWarehouseCityId(Long warehouseCityId) {
		this.warehouseCityId = warehouseCityId;
	}

	public String getWarehouseCityName() {
		return warehouseCityName;
	}

	public void setWarehouseCityName(String warehouseCityName) {
		this.warehouseCityName = warehouseCityName;
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
}
