package com.morning.star.retail.admin.group.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class DeleteAccountCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号",required = true)
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}