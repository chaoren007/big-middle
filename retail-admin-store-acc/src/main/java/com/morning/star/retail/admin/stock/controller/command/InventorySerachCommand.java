package com.morning.star.retail.admin.stock.controller.command;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class InventorySerachCommand implements Serializable {
	private static final long serialVersionUID = -2057226001277716774L;
	@ApiModelProperty(value="盘点编码")
	private String inventoryCode;
	private String inventoryName;
	
	private Date beginTime;
	private Date endTime;
	
	@ApiModelProperty(value="0正常  1异常")
	private Integer status;
	@ApiModelProperty(value="0未读  1已读")
	private Integer operType;

	@ApiModelProperty(value="0：未审核；1：审核成功；2：审核失败")
	private Integer auditStatus;

	@ApiModelProperty(value="盘点模式：0：抽盘，1：全盘")
	private Integer modeType;
	
	@ApiModelProperty(required=true)
	private Integer page;
	
	@ApiModelProperty(required=true)
	private Integer pageSize;


	

	public Date getBeginTime() {
		return beginTime;
	}



	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}



	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public Integer getOperType() {
		return operType;
	}

	public void setOperType(Integer operType) {
		this.operType = operType;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}


	public Integer getModeType() {
		return modeType;
	}

	public void setModeType(Integer modeType) {
		this.modeType = modeType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
