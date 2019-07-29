package com.morning.star.retail.export.dto;


import java.io.Serializable;

public class UserInfoDTO implements Serializable {
	private static final long serialVersionUID = 4902286490144330656L;

    private Long userId; // 用户id
    private String userName; // 用户名
	private String groupCode;
	private String storeCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
