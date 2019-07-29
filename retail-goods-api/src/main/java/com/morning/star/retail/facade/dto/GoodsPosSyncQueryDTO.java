package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 门店货品
 */
@ApiModel
public class GoodsPosSyncQueryDTO implements Serializable {
	private static final long serialVersionUID = 4720371191153018716L;

	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	@ApiModelProperty(value = "截止修改时间")
	private Date lastModifyTime;

	@ApiModelProperty(value = "页码数")
	private Integer pageNo;

	@ApiModelProperty(value = "每页数量")
	private Integer pageSize;

	@ApiModelProperty(value = "UPC编码列表", hidden = true)
	private List<String> upcCodes;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
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

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public List<String> getUpcCodes() {
		return upcCodes;
	}

	public void setUpcCodes(List<String> upcCodes) {
		this.upcCodes = upcCodes;
	}
}