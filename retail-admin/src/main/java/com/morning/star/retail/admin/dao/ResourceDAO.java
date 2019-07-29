package com.morning.star.retail.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.po.ResourcePO;

public interface ResourceDAO {

	List<ResourcePO> select(ResourceQueryDTO queryDTO);

	List<String> selectResource(@Param("resourceIds") List<Long> resourceIds);

	int count(ResourceQueryDTO queryDTO);

}