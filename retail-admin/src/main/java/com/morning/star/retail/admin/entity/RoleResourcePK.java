package com.morning.star.retail.admin.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author ethan
 * @create_time 2018/8/11 14:43
 */
@Embeddable
public class RoleResourcePK implements Serializable {
	private static final long serialVersionUID = -7189167162738318201L;
	private Long roleId;
	private Long resourceId;

	public RoleResourcePK() {
	}

	public RoleResourcePK(Long roleId, Long resourceId) {
		this.roleId = roleId;
		this.resourceId = resourceId;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RoleResourcePK that = (RoleResourcePK) o;
		return Objects.equals(roleId, that.roleId) &&
			Objects.equals(resourceId, that.resourceId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(roleId, resourceId);
	}
}
