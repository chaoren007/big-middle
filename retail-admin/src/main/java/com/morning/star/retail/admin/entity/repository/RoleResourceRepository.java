package com.morning.star.retail.admin.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.admin.entity.RoleResourceEntity;
import com.morning.star.retail.admin.entity.RoleResourcePK;

/**
 * @author ethan
 * @create_time 2018/8/11 9:31
 */
public interface RoleResourceRepository extends Repository<RoleResourceEntity, RoleResourcePK> {
	void save(RoleResourceEntity roleResourceEntity);

	List<RoleResourceEntity> queryByIdRoleId(Long roleId);

	List<RoleResourceEntity> queryByIdRoleIdIn(List<Long> roleIds);

	RoleResourceEntity findOne(RoleResourcePK id);

	Boolean existsById(RoleResourcePK id);

	void deleteByIdRoleId(Long roleId);

	void deleteByIdResourceId(Long resourceId);

	void deleteByIdRoleIdInAndIdResourceIdIn(List<Long> roleIds, List<Long> resourceIds);
}
