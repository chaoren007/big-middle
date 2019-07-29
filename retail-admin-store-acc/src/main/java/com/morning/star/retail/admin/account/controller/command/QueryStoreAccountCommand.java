package com.morning.star.retail.admin.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class QueryStoreAccountCommand implements Serializable {

    private static final long serialVersionUID = -2387415653949362755L;

    @ApiModelProperty(value = "登录账号",required = false)
    private String account;

    @ApiModelProperty(value = "联系人姓名",required = false)
    private String name;

    @ApiModelProperty(value = "联系人手机",required = false)
    private String mobile;

    @ApiModelProperty(value = "联系人邮箱",required = false)
    private String email;
    
    @ApiModelProperty(value = "等级 clerk:普通员工 seller:促销员 store:管理员",required = false)
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

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

}
