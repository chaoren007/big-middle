package com.morning.star.retail.admin.application;

import java.util.List;

/**
 * 角色资源关联
 * 
 * @author jiangyf
 * @date 2017年10月17日 下午4:56:58
 */
public interface RoleResourceApplication {

	/**
	 * 创建角色资源关联
	 * 
	 * @param roleId
	 * @param resourceId
	 */
	int create(Long roleId, Long resourceId);

	/**
	 * 删除角色资源关联
	 * 
	 * @param roleId
	 */
	int deleteByRoleId(Long roleId);

	/**
	 * 删除角色资源关联
	 * 
	 * @param resourceId
	 */
	int deleteByResourceId(Long resourceId);

	/**
	 * 删除角色资源关联
	 *
	 * @param roleIds
	 * @param resourceIds
	 */
	int delete(List<Long> roleIds, List<Long> resourceIds);

	/**
	 * 根据角色id查询资源id
	 * 
	 * @param roleId
	 * @return
	 */
	List<Long> queryResourceId(Long roleId);

	/**
	 * 根据角色id查询资源id
	 * 
	 * @param roleIds
	 * @return
	 */
	List<Long> queryResourceId(List<Long> roleIds);
}
