package com.morning.star.retail.admin.facade;

import java.util.List;

import com.morning.star.retail.admin.dto.ChangeRoleDTO;
import com.morning.star.retail.admin.dto.ResourceDTO;
import com.morning.star.retail.admin.dto.RoleDTO;
import com.morning.star.retail.admin.dto.RoleDetailDTO;
import com.morning.star.retail.admin.dto.RoleFormDTO;
import com.morning.star.retail.admin.dto.RoleQueryDTO;
import com.morning.star.retail.base.page.PageBeans;

/**
 * 角色
 * 
 * @author jiangyf
 * @date 2017年10月16日 下午5:55:06
 */
public interface RoleFacade {

	/**
	 * 分页查询角色
	 * 
	 * @param queryDTO
	 * @return
	 */
	PageBeans<RoleDTO> page(RoleQueryDTO queryDTO);

	/**
	 * 查询有效角色（用于授权下拉列表）
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<RoleDTO> list(RoleQueryDTO queryDTO);

	/**
	 * 创建角色
	 * 
	 * @param formDTO
	 */
	void create(RoleFormDTO formDTO);

	/**
	 * 修改角色
	 * 
	 * @param formDTO
	 */
	void modify(RoleFormDTO formDTO);

	/**
	 * 删除角色
	 * 
	 * @param formDTO
	 */
	void delete(RoleFormDTO formDTO);

	/**
	 * 根据角色id查询有效角色
	 * 
	 * @param roleIds
	 *            角色id(逗号分隔)
	 * @return
	 */
	List<String> queryRole(String roleIds);

	/**
	 * 根据角色id查询有效权限
	 * 
	 * @param roleIds
	 *            角色id(逗号分隔)
	 * @return
	 */
	List<String> queryResource(String roleIds);

	/**
	 * 查询角色详情
	 * 
	 * @param queryDTO
	 * @return
	 */
	RoleDetailDTO detail(RoleQueryDTO queryDTO);

	/**
	 * 根据登录账户查询权限信息
	 * 
	 * @param account
	 * @return
	 */
	List<ResourceDTO> accessInfo(String account,String level);

	/**
	 * 变更集团的集团/门店方案（上帝端），变更门店的门店方案（门店端）
	 *
	 * @param changeRoleDTO
	 */
	void changeRole(ChangeRoleDTO changeRoleDTO);
}
