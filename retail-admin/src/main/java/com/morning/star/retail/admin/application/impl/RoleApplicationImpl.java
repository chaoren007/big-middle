package com.morning.star.retail.admin.application.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.admin.application.RoleApplication;
import com.morning.star.retail.admin.bean.RoleDO;
import com.morning.star.retail.admin.dao.RoleDAO;
import com.morning.star.retail.admin.dto.RoleQueryDTO;
import com.morning.star.retail.admin.entity.RoleEntity;
import com.morning.star.retail.admin.entity.repository.RoleRepository;
import com.morning.star.retail.admin.enums.RoleStatusEnum;
import com.morning.star.retail.admin.po.RolePO;
import com.morning.star.retail.admin.utils.entity.BeanUtils;
import com.morning.star.retail.admin.utils.entity.DeleteFlagEnum;

@Service
public class RoleApplicationImpl implements RoleApplication {

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public boolean isExist(RoleQueryDTO queryDTO) {
		return roleDAO.count(queryDTO) > 0 ? true : false;
	}

	@Override
	public List<Long> checkGetRoleIds(String roleIds, RoleStatusEnum statusEnum) {
		if (RoleStatusEnum.NORMAL.equals(statusEnum)) {
			String[] idsStr = roleIds.split(",");
			List<Long> idList = new ArrayList<>();
			for (String idStr : idsStr) {
				long id = Long.parseLong(idStr);
				if (isExist(RoleQueryDTO.of(id, statusEnum.getCode()))) {
					idList.add(id);
				}
			}
			return idList;
		}
		return Arrays.stream(roleIds.split(","))
			.map(s -> Long.parseLong(s.trim()))
			.collect(Collectors.toList());
	}

	@Override
	public List<RolePO> query(RoleQueryDTO queryDTO) {
		return roleDAO.select(queryDTO);
	}

	@Override
	public RolePO queryOne(RoleQueryDTO queryDTO) {
		List<RolePO> list = query(queryDTO);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	@Transactional
	public Long create(RoleDO roleDO) {
		RoleEntity roleEntity = new RoleEntity();
		BeanUtils.copy(roleDO, roleEntity);
		roleEntity.setId(null);
		roleRepository.save(roleEntity);
		return roleEntity.getId();
	}

	@Override
	@Transactional
	public void modify(RoleDO roleDO) {
		RoleEntity roleEntity = roleRepository.findOne(roleDO.getId());
		roleEntity.setName(roleDO.getName());
		roleEntity.setPriority(roleDO.getPriority());
		roleEntity.setDescription(roleDO.getDescription());
		roleEntity.setStatus(roleDO.getStatus());
		roleRepository.save(roleEntity);
	}

	@Override
	@Transactional
	public void delete(RoleDO roleDO) {
		RoleEntity roleEntity = roleRepository.findOne(roleDO.getId());
		Validate.notNull(roleEntity, "删除角色不存在：" + roleDO.getId());
		roleEntity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
		roleEntity.setStatus(RoleStatusEnum.DELETE.getCode());
		roleRepository.save(roleEntity);
	}

	@Override
	public List<String> queryRole(List<Long> roleIds) {
		List<RoleEntity> entities = roleRepository.queryByIdIn(roleIds);
		return entities.stream()
			.map(RoleEntity::getName)
			.collect(Collectors.toList());
	}

	@Override
	public List<Long> queryRoleIds(RoleQueryDTO queryDTO) {
		return roleDAO.selectRoleId(queryDTO);
	}

}
