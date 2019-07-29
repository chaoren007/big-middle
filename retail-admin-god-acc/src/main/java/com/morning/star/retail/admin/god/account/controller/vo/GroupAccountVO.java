package com.morning.star.retail.admin.god.account.controller.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录账号
 */
public class GroupAccountVO implements Serializable {

	private static final long serialVersionUID = 3180911585619876463L;
	/**
	 * 记录ID
	 */
	private Long id;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 集团编码
	 */
	private String groupCode;

	/**
	 * 集团名称
	 */
	private String groupName;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 账号等级
	 */
	private String accountLevel;
	
	
	private String levelName;

	/**
	 * 集团权限
	 */
	private String accessIds;

	/**
	 * 是否在线（0：离线；1：在线）
	 */
	private Integer isOnline;

	/**
	 * 状态（0：正常；1：冻结；2：作废）
	 */
	private Integer status;

	/**
	 * 登录次数
	 */
	private Integer loginCount;

	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;
	
	/**
	 * 操作人ID
	 */
	private String operatorId;

	/**
	 * 操作人名称
	 */
	private String operatorName;

	/**
	 * 创建人账号
	 */
	private Long creatorId;

	/**
	 * 创建人名称
	 */
	private String creatorName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
	
}