package com.morning.star.retail.admin.po;

/**
 * 角色资源
 * 
 * @author jiangyf
 */
public class RoleResourcePO {
	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 权限id
	 */
	private Long permissionId;

	/**
	 * 资源id
	 */
	private Long resourceId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}