package com.morning.star.retail.admin.dto;

import java.io.Serializable;

/**
 * Created by wumengzhen
 */
public class ChangePasswordDTO implements Serializable {

    private static final long serialVersionUID = -5645189964306400975L;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
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