package com.morning.star.retail.admin.application.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.admin.application.ResourceApplication;
import com.morning.star.retail.admin.bean.ResourceDO;
import com.morning.star.retail.admin.constant.AccessConstant;
import com.morning.star.retail.admin.dao.ResourceDAO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.entity.ResourceEntity;
import com.morning.star.retail.admin.entity.repository.ResourceRepository;
import com.morning.star.retail.admin.enums.ResourceLevelEnum;
import com.morning.star.retail.admin.enums.ResourceStatusEnum;
import com.morning.star.retail.admin.enums.ResourceTypeEnum;
import com.morning.star.retail.admin.po.ResourcePO;
import com.morning.star.retail.admin.utils.entity.BeanUtils;

@Service
public class ResourceApplicationImpl implements ResourceApplication {

	@Autowired
	private ResourceDAO resourceDAO;
	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public void checkExist(Long id, Long parentId) {
		Validate.isTrue(resourceRepository.existsByIdAndParentId(id, parentId),
			String.format("上级资源编码【%d】下资源编码【%d】对应资源不存在", id, parentId));
	}

	@Override
	public List<ResourcePO> query(ResourceQueryDTO queryDTO) {
		return resourceDAO.select(queryDTO);
	}

	@Override
	public List<ResourcePO> query(Long parentId, List<Long> resourceIds) {
		return resourceDAO
				.select(ResourceQueryDTO.of(parentId, resourceIds, ResourceStatusEnum.NORMAL.getCode(),null));
	}

	@Override
	public ResourcePO checkQueryById(Long id) {
		ResourceEntity resourceEntity = resourceRepository.findOne(id);
		Validate.notNull(resourceEntity, String.format("未找到资源编码【%d】对应资源", id));
		ResourcePO resourcePO = new ResourcePO();
		BeanUtils.copy(resourceEntity, resourcePO);
		return resourcePO;
	}

	@Override
	@Transactional
	public void create(ResourceDO resourceDO) {
		Validate.isTrue(!resourceRepository.existsById(resourceDO.getId()),
			String.format("资源编码【%d】已存在", resourceDO.getId()));
		Validate.isTrue(!resourceRepository.existsByNameAndParentIdAndClassify(resourceDO.getName(), resourceDO.getParentId(), resourceDO.getClassify()),
			String.format("上级资源编码【%d】下资源名称【%s】已存在", resourceDO.getParentId(), resourceDO.getName()));

		if (ResourceLevelEnum.METHOD.getCode().equals(resourceDO.getResourceLevel())) {
			resourceDO.setType(ResourceTypeEnum.BUTTON.getCode());
		} else {
			resourceDO.setType(ResourceTypeEnum.MENU.getCode());
		}
		if (resourceDO.getParentId() != AccessConstant.RESOURCE_ROOT_ID) {
			ResourcePO parentPerm = checkQueryById(resourceDO.getParentId());
			resourceDO.setParentIds(parentPerm.getParentIds() + "/" + parentPerm.getId());
		} else {
			resourceDO.setParentIds("0");
		}
		ResourceEntity resourceEntity = new ResourceEntity();
		BeanUtils.copy(resourceDO, resourceEntity);
		resourceEntity.setStatus(0);
		resourceEntity.setPriority(0);
		resourceRepository.save(resourceEntity);
//		resourceDAO.insertLog(resourceDO);
	}

	@Override
	@Transactional
	public void modify(ResourceDO resourceDO) {
		ResourceEntity resourceEntity = resourceRepository.findOne(resourceDO.getId());
		Validate.notNull(resourceEntity, "资源不存在：" + resourceDO.getId());
		resourceEntity.setName(resourceDO.getName());
		resourceRepository.save(resourceEntity);
//		resourceDAO.insertLog(resourceLog);
	}

	@Override
	@Transactional
	public void delete(ResourceDO resourceDO) {
//		resourceDAO.insertLog(supply(resourceDO));
		resourceRepository.deleteById(resourceDO.getId());
	}

	@Override
	public List<String> queryResource(List<Long> resourceIds) {
		if(resourceIds != null && resourceIds.size() > 0){
			return resourceDAO.selectResource(resourceIds);
		}
		return Collections.emptyList();
	}

}
