package com.morning.star.retail.admin.logicservice;

import java.util.List;

import com.morning.star.retail.admin.dto.ResourceDTO;

/**
 * 资源
 *
 * @author jiangyf
 * @date 2017/11/1
 */
public interface ResourceLogicService {

	/**
	 * 查询资源
	 *
	 * @param groupCode
	 *            集团编码
	 * @param storeCode
	 *            门店编码
	 * @param resourceLevel
	 *            级别
	 * @return
	 */
	List<ResourceDTO> list(String groupCode, String storeCode, String resourceLevel,String classify);

	/**
	 * 查询资源
	 *
	 * @param roleId
	 *            角色id
	 * @param groupCode
	 *            集团编码
	 * @param storeCode
	 *            门店编码
	 * @param resourceLevel
	 *            级别
	 * @return
	 */
	List<ResourceDTO> list(Long roleId, String groupCode, String storeCode, String resourceLevel,String classify);

	/**
	 * 查询资源
	 *
	 * @param resourceIds
	 * @return
	 */
	List<ResourceDTO> list(List<Long> resourceIds,String classify);

}
