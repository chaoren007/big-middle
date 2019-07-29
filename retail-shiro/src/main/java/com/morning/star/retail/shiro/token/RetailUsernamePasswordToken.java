package com.morning.star.retail.shiro.token;

import com.morning.star.retail.shiro.bean.UserLogin;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author ethan
 * @create_time 2019/3/15 10:55
 */
public class RetailUsernamePasswordToken extends UsernamePasswordToken {
	private UserLogin userLogin;

	public RetailUsernamePasswordToken(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public RetailUsernamePasswordToken(String username, String password, boolean rememberMe, UserLogin userLogin) {
		super(username, password, rememberMe);
		this.userLogin = userLogin;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
}
