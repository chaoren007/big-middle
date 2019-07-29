package com.morning.star.retail.facade.dto;

public class ThirdServiceDTO{
	private static final long serialVersionUID = 559028683041454996L;

	private String requestApi;

	private String requestParam;

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
}
