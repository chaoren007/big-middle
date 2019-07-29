package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class BusAfterSalesQueryDTO implements Serializable {
	private static final long serialVersionUID = 1213829454950205914L;

	@ApiModelProperty(value = "售后类型")
	private Integer afterSalesType;
	@ApiModelProperty(value = "售后状态")
	private Integer afterSalesStatus;
	@ApiModelProperty(value = "售后起始时间")
	private Date startTime;
	@ApiModelProperty(value = "售后起始时间")
	private Date endTime;
	@ApiModelProperty(value = "售后单号")
	private String afterSalesCode;
	@ApiModelProperty(value = "供货单号")
	private String supplyCode;
	@ApiModelProperty(value = "商品名称")
	private String pName;
	@ApiModelProperty(value = "售后城市")
	private String cityName;

	private Integer pageNo;
	private Integer pageSize;


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

	public Integer getAfterSalesType() {
		return afterSalesType;
	}

	public void setAfterSalesType(Integer afterSalesType) {
		this.afterSalesType = afterSalesType;
	}

	public Integer getAfterSalesStatus() {
		return afterSalesStatus;
	}

	public void setAfterSalesStatus(Integer afterSalesStatus) {
		this.afterSalesStatus = afterSalesStatus;
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

	public String getAfterSalesCode() {
		return afterSalesCode;
	}

	public void setAfterSalesCode(String afterSalesCode) {
		this.afterSalesCode = afterSalesCode;
	}

	public String getSupplyCode() {
		return supplyCode;
	}

	public void setSupplyCode(String supplyCode) {
		this.supplyCode = supplyCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
