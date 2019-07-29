package com.morning.star.retail.facade.dto.purchasein;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PurchaseInOrderDTO implements Serializable {

	private static final long serialVersionUID = 7117356089100225871L;

	@ApiModelProperty(value = "采购入库单号")
	private String purchaseInCode;

	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

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

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "审核状态：0、未审核 10、已审核 ")
	private Integer status;

	@ApiModelProperty(value = "单据状态：0、未入库 10、已入库")
	private Integer transStatus;

	@ApiModelProperty(value = "总金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "采购总金额(含税)")
	private BigDecimal rateAmount;

	@ApiModelProperty(value = "操作人编码")
	private String operatorId;

	@ApiModelProperty(value = "操作时间")
	private String operatorName;

	@ApiModelProperty(value = "审核人")
	private String approveId;

	@ApiModelProperty(value = "审核时间")
	private Date approveDate;

	@ApiModelProperty(value = "创建名字")
	private String creatorId;

	@ApiModelProperty(value = "创建人名字")
	private String creatorName;

	@ApiModelProperty(value = "采购合同")
	private String contract;

	@ApiModelProperty(value = "供应商合同")
	private String supplierContract;

	@ApiModelProperty(value = "支付方式")
	private Integer payments;

	@ApiModelProperty(value = "备注信息")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;

	@ApiModelProperty("预计入库时间")
	private Date preReceiptDate;

	@ApiModelProperty(value = "采购单明细")
	private List<PurchaseInOrderDetailDTO> orderDetail;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(Integer transStatus) {
		this.transStatus = transStatus;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
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

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getSupplierContract() {
		return supplierContract;
	}

	public void setSupplierContract(String supplierContract) {
		this.supplierContract = supplierContract;
	}

	public Integer getPayments() {
		return payments;
	}

	public void setPayments(Integer payments) {
		this.payments = payments;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<PurchaseInOrderDetailDTO> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<PurchaseInOrderDetailDTO> orderDetail) {
		this.orderDetail = orderDetail;
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

	public Date getPreReceiptDate() {
		return preReceiptDate;
	}

	public void setPreReceiptDate(Date preReceiptDate) {
		this.preReceiptDate = preReceiptDate;
	}
}
