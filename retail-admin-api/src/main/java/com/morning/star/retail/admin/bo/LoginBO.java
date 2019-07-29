package com.morning.star.retail.admin.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录
 *
 * @author jiangyf
 * @date 2017年5月25日 下午12:44:27
 */
@ApiModel
public class LoginBO implements Serializable {
	private static final long serialVersionUID = 6788733017005995734L;

	@ApiModelProperty(value = "登录账号")
	@NotNull(message = "登录账号不能为空")
	private String account;

	@ApiModelProperty(value = "登录密码")
	@NotNull(message = "登录密码不能为空")
	private String password;

	@ApiModelProperty(value = "设备ID")
	@NotNull(message = "设备ID不能为空")
	private String deviceId;
	/**
	 * 请求
	 */
	private HttpServletRequest request;
	/**
	 * 响应
	 */
	private HttpServletResponse response;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public LoginBO() {
	}

	public LoginBO(String account, String password, HttpServletRequest request,
	               HttpServletResponse response) {
		this.account = account;
		this.password = password;
		this.request = request;
		this.response = response;
	}

	public static LoginBO getInstance(String account, String password,
	                                  HttpServletRequest request, HttpServletResponse response) {
		return new LoginBO(account, password, request, response);
	}

}
