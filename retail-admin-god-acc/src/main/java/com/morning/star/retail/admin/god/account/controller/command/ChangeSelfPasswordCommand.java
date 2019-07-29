package com.morning.star.retail.admin.god.account.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wumengzhen
 */
public class ChangeSelfPasswordCommand implements Serializable {

    private static final long serialVersionUID = -5645189964306400975L;

    /**
     * 旧密码
     */
    @ApiModelProperty(value = "旧密码",required = true)
    private String oldPassword;

    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码",required = true)
    private String newPassword;


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}