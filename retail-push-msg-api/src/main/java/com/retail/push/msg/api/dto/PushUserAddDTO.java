package com.retail.push.msg.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author ethan
 * @create_time 2018/9/21 9:55
 */
@ApiModel
public class PushUserAddDTO implements Serializable {
	private static final long serialVersionUID = 6677259118368621905L;

	@ApiModelProperty(value = "用户TOKEN信息")
	private String token;

	@ApiModelProperty(value = "设备ID")
	private String deviceId;

	@ApiModelProperty(value = "用户类型")
	private Integer userType;

	@ApiModelProperty(value = "设备类型")
	private Integer deviceType;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
}
