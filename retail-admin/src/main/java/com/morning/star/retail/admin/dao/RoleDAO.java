package com.morning.star.retail.admin.dao;

import com.morning.star.retail.admin.dto.RoleQueryDTO;
import com.morning.star.retail.admin.po.RolePO;

import java.util.List;

public interface RoleDAO {

	List<RolePO> select(RoleQueryDTO queryDTO);

	List<Long> selectRoleId(RoleQueryDTO queryDTO);

	int count(RoleQueryDTO queryDTO);

}
