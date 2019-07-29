package com.morning.star.retail.admin.group.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 */
public class ChangePasswordCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号",required = true)
    private String account;

	@ApiModelProperty(value = "新密码",required = true)
    private String password;
    
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
    
}