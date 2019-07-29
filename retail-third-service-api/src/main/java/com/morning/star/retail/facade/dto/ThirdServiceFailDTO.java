package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ThirdServiceFailDTO implements Serializable {
	private static final long serialVersionUID = 559028683041454996L;

	private Long id;

	@ApiModelProperty("请求链接")
	private String requestApi;

	@ApiModelProperty("请求参数")
	private String requestParam;

	@ApiModelProperty("错误原因信息")
	private String msg;

	@ApiModelProperty("请求服务类型")
	private Integer requestType;

	@ApiModelProperty("请求服务标示")
	private Integer requestTag;

	@ApiModelProperty("请求服务状态")
	private Integer requestStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestApi() {
		return requestApi;
	}

	public void setRequestApi(String requestApi) {
		this.requestApi = requestApi;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getRequestType() {
		return requestType;
	}

	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}

	public Integer getRequestTag() {
		return requestTag;
	}

	public void setRequestTag(Integer requestTag) {
		this.requestTag = requestTag;
	}

	public Integer getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}
}
