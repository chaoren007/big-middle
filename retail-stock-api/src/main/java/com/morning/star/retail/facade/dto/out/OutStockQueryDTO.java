package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class OutStockQueryDTO implements Serializable {
	private static final long serialVersionUID = 8604292107731703710L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@ApiModelProperty("调出仓库编码")
	private String outWarehouseCode;

	@ApiModelProperty(value = "出库类型（0：其他，1：调拨出库）")
	private String type;

	@ApiModelProperty(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、出库")
	private String status;

	@ApiModelProperty(value = "开始时间")
	private Date beginTime;

	@ApiModelProperty(value = "结束时间")
	private Date endTime;

	@ApiModelProperty(required = true, value = "页码")
	private Integer pageNo;

	@ApiModelProperty(required = true, value = "每页记录数")
	private Integer pageSize;

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

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

	public String getOutWarehouseCode() {
		return outWarehouseCode;
	}

	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}
