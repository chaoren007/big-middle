package com.morning.star.retail.export.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 导出传参通用
 *
 * @author kimhuhg
 */
public class ExportMqDTO implements Serializable {
	private static final long serialVersionUID = 4902286490144330656L;

	//查询条件
	private Map<String, String> item;

	//导出类型(指哪个导出)
	private String type;

	//插入记录表的返回id
	private Long id;

	//用户信息
	private UserInfoDTO userCommand;

	public Map<String, String> getItem() {
		return item;
	}

	public void setItem(Map<String, String> item) {
		this.item = item;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInfoDTO getUserCommand() {
		return userCommand;
	}

	public void setUserCommand(UserInfoDTO userCommand) {
		this.userCommand = userCommand;
	}
}
