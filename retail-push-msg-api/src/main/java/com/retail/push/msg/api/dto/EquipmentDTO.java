package com.retail.push.msg.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class EquipmentDTO implements Serializable {

	private static final long serialVersionUID = -6570616364220630237L;

	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "用户ID")
	private Long uin;

	@ApiModelProperty(value = "推送编码ID")
	private String equipmentId;

	@ApiModelProperty(value = "用户TOKEN")
	private String token;

	@ApiModelProperty(value = "设备类型")
	private Integer equipmentType;

	@ApiModelProperty(value = "推送状态")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUin() {
		return uin;
	}

	public void setUin(Long uin) {
		this.uin = uin;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
