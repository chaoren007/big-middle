package com.morning.star.retail.admin.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ethan
 * @create_time 2018/8/11 9:34
 */
@Table(name = "access_role_resource")
@Entity
public class RoleResourceEntity implements Serializable {
	private static final long serialVersionUID = 3654480332669571337L;
	@EmbeddedId
	private RoleResourcePK id;

	public RoleResourceEntity() {
	}

	public RoleResourceEntity(Long roleId, Long resourceId) {
		this.id = new RoleResourcePK(roleId, resourceId);
	}

	public RoleResourcePK getId() {
		return id;
	}

	public void setId(RoleResourcePK id) {
		this.id = id;
	}
}
