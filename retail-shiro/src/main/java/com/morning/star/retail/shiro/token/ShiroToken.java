package com.morning.star.retail.shiro.token;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Shiro token
 *
 * @author jiangyf
 */
public class ShiroToken extends UsernamePasswordToken implements Serializable {
    private static final long serialVersionUID = -6451794657814516274L;

    public ShiroToken(String username, String pswd) {
        super(username, pswd);
        this.pswd = pswd;
    }

    private String pswd;

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

}
