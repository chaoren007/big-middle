package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class PurchaseQueryDTO implements Serializable {
	private static final long serialVersionUID = -8137520453003973871L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty(value = "市")
	private Long cityId;

	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty(value = "订单状态")
	private String status;

	@ApiModelProperty(value = "查询页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页个数")
	private Integer pageSize;

	@ApiModelProperty(value = "订单创建人")
	private String creator;

	@ApiModelProperty(value = "供货商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供货商名称")
	private String supplierName;

	@ApiModelProperty(value = "订单创建开始时间")
	private Date beginTime;

	@ApiModelProperty(value = "订单创建结束时间")
	private Date endTime;

	@ApiModelProperty(value = "提交类型(10：总部-集采  20：分城市-区采)")
	private Integer submitType;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Integer getSubmitType() {
		return submitType;
	}

	public void setSubmitType(Integer submitType) {
		this.submitType = submitType;
	}
}
