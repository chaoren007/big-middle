package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;
import com.retail.push.msg.api.info.BaseMsg;

/**
 * Created by Dell on 2018/7/17.
 */
public class ConnectRequestMsg extends BaseMsg {
	private String userName;
	private String password;
	private String token;

	public ConnectRequestMsg() {
		super();
		setType(MessageType.CONNECT_REQ);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
