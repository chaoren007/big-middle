package com.morning.star.retail.admin.dto;

import java.io.Serializable;

/**
 * 角色
 * 
 * @author jiangyf
 * @date 2017年10月16日 下午6:17:15
 */
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 615368429280779029L;

	/**
	 * 权限id
	 */
	private Long id;

	/**
	 * 权限名称
	 */
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
