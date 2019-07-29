package com.morning.star.retail.admin.application;

import java.util.List;

import com.morning.star.retail.admin.bean.ResourceDO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.po.ResourcePO;

/**
 * 资源
 * 
 * @author jiangyf
 * @date 2017年10月16日 下午6:13:13
 */
public interface ResourceApplication {

	/**
	 * 检查资源是否存在
	 * 
	 * @param id
	 * @param parentId
	 */
	void checkExist(Long id, Long parentId);

	/**
	 * 查询资源
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<ResourcePO> query(ResourceQueryDTO queryDTO);

	/**
	 * 查询指定上级资源id下且资源id在指定资源id范围的资源
	 * 
	 * @param parentId
	 * @param resourceIds
	 * @return
	 */
	List<ResourcePO> query(Long parentId, List<Long> resourceIds);

	/**
	 * 检查资源
	 * 
	 * @param id
	 * @return
	 */
	ResourcePO checkQueryById(Long id);

	/**
	 * 创建资源
	 * 
	 * @param resourceDO
	 */
	void create(ResourceDO resourceDO);

	/**
	 * 修改资源
	 * 
	 * @param resourceDO
	 */
	void modify(ResourceDO resourceDO);

	/**
	 * 删除资源
	 * 
	 * @param resourceDO
	 */
	void delete(ResourceDO resourceDO);

	/**
	 * 根据资源id集查询资源
	 * 
	 * @param resourceIds
	 * @return
	 */
	List<String> queryResource(List<Long> resourceIds);

}
