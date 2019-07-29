package com.morning.star.retail.admin.facade;

import com.morning.star.retail.admin.dto.ResourceDTO;
import com.morning.star.retail.admin.dto.ResourceFormDTO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;

import java.util.List;

/**
 * 资源
 * 
 * @author jiangyf
 * @date 2017年10月16日 下午5:51:13
 */
public interface ResourceFacade {

	/**
	 * 查询资源
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<ResourceDTO> list(ResourceQueryDTO queryDTO);

	/**
	 * 创建资源
	 * 
	 * @param formDTO
	 */
	void create(ResourceFormDTO formDTO);

	/**
	 * 修改资源（当前主要是修改名称）
	 * 
	 * @param formDTO
	 */
	void modify(ResourceFormDTO formDTO);

	/**
	 * 删除资源
	 * 
	 * @param formDTO
	 */
	void delete(ResourceFormDTO formDTO);

}
