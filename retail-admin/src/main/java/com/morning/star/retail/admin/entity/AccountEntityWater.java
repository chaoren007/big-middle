package com.morning.star.retail.admin.entity;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;

import com.morning.star.retail.admin.utils.audit.Operator;

@Table(name = "retail_account_water")
@Where(clause = "delete_flag <> 1")
@Entity
public class AccountEntityWater extends WaterEntity {

	private static final long serialVersionUID = 1111320370190733557L;

	@Comment("集团编码")
	@Column(length = 64)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Column(length = 64)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64)
	@Comment("门店名称")
	private String storeName;

	@Comment("账号")
	private String account;

	@Comment("联系人姓名")
	private String name;

	@Comment("联系人手机")
	private String mobile;

	@Comment("联系人邮箱")
	private String email;

	@Comment("账号等级")
	private String accountLevel;

	@Comment("集团权限")
	private String accessIds;

	@Comment("是否在线（0：离线；1：在线）")
	private Integer isOnline;

	@Comment("状态（0：正常；1：冻结；2：作废）")
	private Integer status;

	@Comment("登录次数")
	private Integer loginCount;

	@Comment("上次登录时间")
	private Date lastLoginTime;

	/**
	 * 折扣
	 */
	@Comment("折扣")
	private Integer discount;

	/**
	 * 创建人
	 */
	@CreatedBy
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "operatorId", column = @Column(name = "creator_id")),
		@AttributeOverride(name = "operatorName", column = @Column(name = "creator_name"))
	})
	private Operator creator;


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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Operator getCreator() {
		return creator;
	}

	public void setCreator(Operator creator) {
		this.creator = creator;
	}
}
