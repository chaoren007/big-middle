package com.morning.star.retail.admin.facade.impl;

import com.google.gson.Gson;
import com.morning.star.retail.admin.application.ResourceApplication;
import com.morning.star.retail.admin.application.RoleResourceApplication;
import com.morning.star.retail.admin.bean.ResourceDO;
import com.morning.star.retail.admin.dto.ResourceDTO;
import com.morning.star.retail.admin.dto.ResourceFormDTO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.entity.repository.ResourceRepository;
import com.morning.star.retail.admin.facade.ResourceFacade;
import com.morning.star.retail.admin.logicservice.impl.ResourceLogicServiceImpl;
import com.morning.star.retail.admin.po.ResourcePO;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceFacadeImpl implements ResourceFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFacadeImpl.class);
	private static final Gson GSON = new Gson();

	@Autowired
	private ResourceApplication resourceApplication;
	@Autowired
	private ResourceLogicServiceImpl resourceLogicService;
	@Autowired
	private RoleResourceApplication roleResourceApplication;

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public List<ResourceDTO> list(ResourceQueryDTO queryDTO) {
		return resourceLogicService.list(queryDTO.getGroupCode(),
			queryDTO.getStoreCode(), queryDTO.getAccountLevel(), queryDTO.getClassify());
	}

	@Override
	public void create(ResourceFormDTO formDTO) {
		resourceApplication.create(ResourceDO.from(formDTO));
	}

	@Override
	public void modify(ResourceFormDTO formDTO) {
		ResourcePO resourcePO = resourceApplication.checkQueryById(formDTO.getId());
		// 检查新资源名是否和原来一致
		if (resourcePO.getName().equals(formDTO.getName())) {
			return;
		}
		// 检查同一上级资源下资源名称是否可用
		Validate.isTrue(!resourceRepository.existsByNameAndParentIdAndClassify(formDTO.getName(), resourcePO.getParentId(), resourcePO.getClassify()),
			"上级资源编码【%d】下资源名称【%s】已存在", resourcePO.getParentId(), formDTO.getName());
		resourceApplication.modify(ResourceDO.from(formDTO));
	}

	@Override
	@Transactional
	public void delete(ResourceFormDTO formDTO) {
		// 检查资源编码对应资源是否存在
		Validate.isTrue(resourceRepository.existsById(formDTO.getId()),
			"未找到资源编码【%d】对应资源", formDTO.getId());

		// 检查是否不存在下级资源
		Validate.isTrue(!resourceRepository.existsByParentId(formDTO.getId()),
			"资源编码【%d】对应资源下存在下级资源", formDTO.getId());
		// 删除资源
		resourceApplication.delete(ResourceDO.from(formDTO));
		// 删除角色资源关联
		roleResourceApplication.deleteByResourceId(formDTO.getId());
	}

}
