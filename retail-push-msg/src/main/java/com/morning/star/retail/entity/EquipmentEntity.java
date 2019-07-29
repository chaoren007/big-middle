package com.morning.star.retail.entity;

import com.morning.star.retail.enums.EquipmentStatus;
import com.morning.star.retail.enums.EquipmentTypeEnum;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "t_push_equipment")
@Where(clause = "delete_flag <> 1")
public class EquipmentEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment(value = "用户ID")
	private Long uin;

	@Comment(value = "链接推送ID")
	private String equipmentId;

	@Comment(value = "集团编码")
	@Column(length = 64)
	private String groupCode;

	@Comment(value = "门店编码")
	@Column(length = 64)
	private String storeCode;

	@Comment(value = "用户账号")
	private String account;

	@Comment(value = "授权TOKEN")
	private String token;

	@Comment(value = "用户类型")
	private Integer userType;

	@Convert(converter = EquipmentTypeEnum.Convert.class)
	private EquipmentTypeEnum equipmentType = EquipmentTypeEnum.POS;

	@Convert(converter = EquipmentStatus.Convert.class)
	private EquipmentStatus status = EquipmentStatus.INIT;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public EquipmentTypeEnum getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentTypeEnum equipmentType) {
		this.equipmentType = equipmentType;
	}

	public EquipmentStatus getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatus status) {
		this.status = status;
	}
}
