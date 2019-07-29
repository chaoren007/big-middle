package com.morning.star.retail.admin.application;

import java.util.List;

import com.morning.star.retail.admin.bean.RoleDO;
import com.morning.star.retail.admin.dto.RoleQueryDTO;
import com.morning.star.retail.admin.enums.RoleStatusEnum;
import com.morning.star.retail.admin.po.RolePO;

/**
 * 角色
 * 
 * @author jiangyf
 * @date 2017年10月17日 下午4:56:58
 */
public interface RoleApplication {

	/**
	 * 角色是否已存在
	 * 
	 * @param queryDTO
	 * @return
	 */
	boolean isExist(RoleQueryDTO queryDTO);

	/**
	 * 把逗号拼接的 角色id 转化为 List<Long> 类型集合
	 * 
	 * @param roleIds
	 * @param statusEnum
	 * @return
	 */
	List<Long> checkGetRoleIds(String roleIds, RoleStatusEnum statusEnum);

	/**
	 * 查询角色
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<RolePO> query(RoleQueryDTO queryDTO);

	/**
	 * 查询角色
	 *
	 * @param queryDTO
	 * @return
	 */
	RolePO queryOne(RoleQueryDTO queryDTO);

	/**
	 * 创建角色
	 * 
	 * @param roleDO
	 * @return
	 */
	Long create(RoleDO roleDO);

	/**
	 * 创建角色
	 * 
	 * @param roleDO
	 */
	void modify(RoleDO roleDO);

	/**
	 * 删除角色
	 * 
	 * @param roleDO
	 */
	void delete(RoleDO roleDO);

	/**
	 * 根据角色id查询角色
	 * 
	 * @param roleIds
	 * @return
	 */
	List<String> queryRole(List<Long> roleIds);

	/**
	 * 查询角色id
	 *
	 * @param queryDTO
	 * @return
	 */
	List<Long> queryRoleIds(RoleQueryDTO queryDTO);

}
