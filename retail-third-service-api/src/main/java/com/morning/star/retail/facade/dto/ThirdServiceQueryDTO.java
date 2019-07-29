package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ThirdServiceQueryDTO {
	private static final long serialVersionUID = 559028683041454996L;

	@ApiModelProperty(value = "请求类型")
	private String requestType;

	@ApiModelProperty(value = "请求标签")
	private String requestTag;

	@ApiModelProperty(value = "请求状态")
	private String requestStatus;

	@ApiModelProperty(value = "查询页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页个数")
	private Integer pageSize;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestTag() {
		return requestTag;
	}

	public void setRequestTag(String requestTag) {
		this.requestTag = requestTag;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
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
