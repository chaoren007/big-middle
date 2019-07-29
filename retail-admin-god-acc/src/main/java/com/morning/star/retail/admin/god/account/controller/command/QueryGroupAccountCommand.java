package com.morning.star.retail.admin.god.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 */
public class QueryGroupAccountCommand implements Serializable {

	private static final long serialVersionUID = 8027237682870063372L;

	/**
	 * 账号
	 */
	@ApiModelProperty(value = "登录账号")
	private String account;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "联系人姓名")
	private String name;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "联系人手机")
	private String mobile;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "联系人邮箱")
	private String email;


	/**
	 * 集团编码
	 */
	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	/**
	 * 集团名称
	 */
	@ApiModelProperty(value = "集团名称")
	private String groupName;

	/**
	 * 页码
	 */
	@ApiModelProperty(value = "页码",required = true)
	private Integer pageNo;

	/**
	 * 记录数
	 */
	@ApiModelProperty(value = "记录数",required = true)
	private Integer pageSize;


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

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
