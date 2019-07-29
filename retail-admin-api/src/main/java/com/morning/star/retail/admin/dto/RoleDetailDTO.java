package com.morning.star.retail.admin.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 角色详情
 * 
 * @author jiangyf
 * @date 2017年10月16日 下午5:58:46
 */
public class RoleDetailDTO implements Serializable {
	private static final long serialVersionUID = 1557714985756477687L;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色权限
	 */
	private List<ResourceDTO> perms;

	public RoleDetailDTO() {
	}

	public RoleDetailDTO(String roleName, List<ResourceDTO> perms) {
		this.roleName = roleName;
		this.perms = perms;
	}

	public static RoleDetailDTO of(String roleName, List<ResourceDTO> perms) {
		return new RoleDetailDTO(roleName, perms);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<ResourceDTO> getPerms() {
		return perms;
	}

	public void setPerms(List<ResourceDTO> perms) {
		this.perms = perms;
	}

}
