package com.morning.star.retail.admin.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


public class CreateStoreAccountCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号",required = true)
    private String account;

	@ApiModelProperty(value = "登录密码",required = true)
    private String password;

	@ApiModelProperty(value = "联系人姓名",required = true)
	private String name;
	
	@ApiModelProperty(value = "联系人手机",required = true)
	private String mobile;
	
	@ApiModelProperty(value = "联系人邮箱",required = true)
	private String email;
	
	@ApiModelProperty(value = "折扣",required = true)
    private Integer discount;

	@ApiModelProperty(value = "等级 store-管理员；clerk-普通员工；seller-促销员",required = true)
    private String accountLevel;
	
	@ApiModelProperty(value = "权限ID（逗号分隔）",required = true)
    private String accessIds;

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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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

}
