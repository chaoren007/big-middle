package com.morning.star.retail.admin.controller;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 *
 * @author wumengzhen
 */
public class AddGroupAccountCommand implements Serializable {

    private static final long serialVersionUID = -9057076021816031093L;

    public static final String DEFAULT_PASSWORD = "12345678";


    /**
     * 账号
     */
    @ApiModelProperty(value = "账号",required = true)
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    private String password;


    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",required = true)
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;

    /**
     * 集团编码
     */
    @ApiModelProperty(value = "集团编码",required = true)
    private String groupCode;

    /**
     * 集团名称
     */
    @ApiModelProperty(value = "集团名称",required = true)
    private String groupName;


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

}