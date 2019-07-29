package com.morning.star.retail.admin.application.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.admin.application.RoleResourceApplication;
import com.morning.star.retail.admin.entity.RoleResourceEntity;
import com.morning.star.retail.admin.entity.repository.RoleResourceRepository;

@Service
public class RoleResourceApplicationImpl implements RoleResourceApplication {

	@Autowired
	private RoleResourceRepository roleResourceRepository;

	@Override
	public int create(Long roleId, Long resourceId) {
		roleResourceRepository.save(new RoleResourceEntity(roleId, resourceId));
		return 1;
	}

	@Override
	@Transactional
	public int deleteByRoleId(Long roleId) {
		roleResourceRepository.deleteByIdRoleId(roleId);
		return 1;
	}

	@Override
	@Transactional
	public int deleteByResourceId(Long resourceId) {
		roleResourceRepository.deleteByIdResourceId(resourceId);
		return 1;
	}

	@Override
	@Transactional
	public int delete(List<Long> roleIds, List<Long> resourceIds) {
		if (CollectionUtils.isNotEmpty(roleIds) && CollectionUtils.isNotEmpty(resourceIds)) {
			roleResourceRepository.deleteByIdRoleIdInAndIdResourceIdIn(roleIds, resourceIds);
		}
		return 1;
	}

	@Override
	public List<Long> queryResourceId(Long roleId) {
		List<RoleResourceEntity> entities = roleResourceRepository.queryByIdRoleId(roleId);
		return entities.stream().map(e -> e.getId().getResourceId()).collect(Collectors.toList());
	}

	@Override
	public List<Long> queryResourceId(List<Long> roleIds) {
		if (CollectionUtils.isEmpty(roleIds)) {
			return new ArrayList<>();
		}
		List<RoleResourceEntity> entities = roleResourceRepository.queryByIdRoleIdIn(roleIds);
		return entities.stream().map(e -> e.getId().getResourceId()).collect(Collectors.toList());
	}

}
