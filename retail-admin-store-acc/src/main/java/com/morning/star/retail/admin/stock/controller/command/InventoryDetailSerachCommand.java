package com.morning.star.retail.admin.stock.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 盘点查询
 *
 * @author jiangyf
 */
public class InventoryDetailSerachCommand implements Serializable {
	private static final long serialVersionUID = -2057226001277716774L;
	@ApiModelProperty(required = true, value = "盘点编码")
	private String inventoryCode;

	// 1:盘盈 2：盘亏 3：漏盘
	@ApiModelProperty(value = "12:异常  3:盘亏")
	private Integer status;

	@ApiModelProperty(required = true)
	private Integer pageNo;
	@ApiModelProperty(required = true)
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

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
