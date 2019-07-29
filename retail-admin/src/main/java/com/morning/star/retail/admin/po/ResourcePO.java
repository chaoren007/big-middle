package com.morning.star.retail.admin.po;

import java.util.Date;

/**
 * 资源
 * 
 * @author jiangyf
 */
public class ResourcePO {
	/**
	 * 资源id
	 */
	private Long id;

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源类型（menu：菜单；button：按钮）
	 */
	private String type;

	/**
	 * 级别（group：分组；mode：模块；method：方法）
	 */
	private String resourceLevel;

	/**
	 * 分类
	 */
	private String classify;

	/**
	 * 路径
	 */
	private String url;

	/**
	 * 上级资源id
	 */
	private Long parentId;

	/**
	 * 上级资源id集
	 */
	private String parentIds;

	/**
	 * 资源
	 */
	private String power;

	/**
	 * 序号
	 */
	private Integer priority;

	/**
	 * 状态（0：正常，1：删除；2：锁定）
	 */
	private Integer status;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(String resourceLevel) {
		this.resourceLevel = resourceLevel;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
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
}