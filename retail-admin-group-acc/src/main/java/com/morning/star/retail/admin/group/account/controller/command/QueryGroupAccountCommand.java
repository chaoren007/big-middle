package com.morning.star.retail.admin.group.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 */
public class QueryGroupAccountCommand implements Serializable {

	private static final long serialVersionUID = 8027237682870063372L;

	@ApiModelProperty(value = "登录账号")
	private String account;

	@ApiModelProperty(value = "联系人姓名")
	private String name;

	@ApiModelProperty(value = "联系人手机")
	private String mobile;

	@ApiModelProperty(value = "联系人邮箱")
	private String email;

	@ApiModelProperty(value = "账号等级（group:超级管理员 normal:普通管理员）")
	private String accountLevel;

	@ApiModelProperty(value = "页码",required = true)
	private Integer pageNo;

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

	public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
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
