package com.morning.star.retail.admin.bean;

/**
 * 角色资源
 * 
 * @author jiangyf
 */
public class RoleResourceDO {
	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 资源id
	 */
	private Long resourceId;

	public RoleResourceDO() {
	}

	public RoleResourceDO(Long roleId, Long resourceId) {
		this.roleId = roleId;
		this.resourceId = resourceId;
	}

	public static RoleResourceDO of(Long roleId, Long resourceId) {
		return new RoleResourceDO(roleId, resourceId);
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}