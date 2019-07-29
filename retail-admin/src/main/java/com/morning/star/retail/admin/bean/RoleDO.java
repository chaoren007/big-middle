package com.morning.star.retail.admin.bean;

import java.util.Date;

import com.morning.star.retail.admin.dto.RoleFormDTO;
import com.morning.star.retail.admin.enums.RoleStatusEnum;

/**
 * 角色
 * 
 * @author jiangyf
 */
public class RoleDO {
	/**
	 * 角色id
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 角色描述
	 */
	private String description;

	/**
	 * 序号
	 */
	private Integer priority;

	/**
	 * 状态（0：正常，1：删除；2：锁定）
	 */
	private Integer status;

	/**
	 * 集团编码
	 */
	private String groupCode;

	/**
	 * 门店编码
	 */
	private String storeCode;

	/**
	 * 分类
	 */
	private String classify;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 操作人id
	 */
	private String operatorId;

	/**
	 * 操作人名称
	 */
	private String operatorName;

	public RoleDO() {
	}

	public RoleDO(Long id, String name, String description, Integer priority, Integer status,
			String groupCode, String storeCode, Date createTime, Date modifyTime, String operatorId,
			String operatorName) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.groupCode = groupCode;
		this.storeCode = storeCode;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}

	public static RoleDO from(RoleFormDTO formDTO) {
		RoleDO roleDO = new RoleDO();
		roleDO.setId(formDTO.getRoleId());
		roleDO.setName(formDTO.getRoleName());
		roleDO.setGroupCode(formDTO.getGroupCode());
		roleDO.setStoreCode(formDTO.getStoreCode());
		roleDO.setOperatorId(formDTO.getOperatorId());
		roleDO.setOperatorName(formDTO.getOperatorName());
		// 默认值
		roleDO.setPriority(0);
		roleDO.setStatus(RoleStatusEnum.NORMAL.getCode());
		roleDO.setDescription("");
		roleDO.setClassify(formDTO.getClassify());
		return roleDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
}