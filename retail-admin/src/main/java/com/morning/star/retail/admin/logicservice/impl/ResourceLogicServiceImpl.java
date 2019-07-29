package com.morning.star.retail.admin.logicservice.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.admin.application.ResourceApplication;
import com.morning.star.retail.admin.application.RoleApplication;
import com.morning.star.retail.admin.application.RoleResourceApplication;
import com.morning.star.retail.admin.constant.AccessConstant;
import com.morning.star.retail.admin.dto.ResourceDTO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.entity.RoleResourcePK;
import com.morning.star.retail.admin.entity.repository.RoleResourceRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.ResourceStatusEnum;
import com.morning.star.retail.admin.enums.RoleStatusEnum;
import com.morning.star.retail.admin.facade.StoreAccountFacade;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.admin.logicservice.ResourceLogicService;
import com.morning.star.retail.admin.po.ResourcePO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.objectcopier.ObjectCopier;

@Service
public class ResourceLogicServiceImpl implements ResourceLogicService {

	@Autowired
	private ResourceApplication resourceApplication;
	@Autowired
	private RoleApplication roleApplication;
	@Autowired
	private RoleResourceApplication roleResourceApplication;
	@Autowired
	private StoreAccountFacade storeAccountFacade;
	@Autowired
	private GroupService groupService;

	@Autowired
	private RoleResourceRepository roleResourceRepository;

	@Override
	public List<ResourceDTO> list(String groupCode, String storeCode, String resourceLevel, String classify) {
		return list(null, groupCode, storeCode, resourceLevel, classify);
	}

	@Override
	public List<ResourceDTO> list(Long roleId, String groupCode, String storeCode, String resourceLevel, String classify) {
		String accessIds = null;
		if (!AccountLevelEnum.GOD.getCode().equals(resourceLevel)) {
			if (AccountLevelEnum.GROUP_ADMIN.getCode().equals(resourceLevel) ||
				AccountLevelEnum.GROUP_NORMAL.getCode().equals(resourceLevel)) {
				GroupInfoDTO groupInfoDTO = groupService.get(groupCode);
				if ("group".equals(classify)) {
					//集团权限
					accessIds = groupInfoDTO.getAccessIds();
				} else {
					//集团以下权限
					accessIds = groupInfoDTO.getRoleIds();
				}
			} else {
				accessIds = storeAccountFacade.getAdmin(storeCode).getAccessIds();
			}
		}
		List<Long> resourceIds = null;
		// 判断上帝端登录账号的级别，若为集团级别账号，则需要筛选授权资源
		if (StringUtils.isNotBlank(accessIds)) {
			List<Long> roleIds = roleApplication.checkGetRoleIds(accessIds, RoleStatusEnum.NORMAL);
			if (roleIds.isEmpty()) {
				return new ArrayList<>();
			}
			// 查询角色授权的资源
			resourceIds = roleResourceApplication.queryResourceId(roleIds);

		}
		if (roleId == null) {
			return list(resourceIds, classify);
		}
		return list(roleId, resourceIds, classify);

	}

	@Override
	public List<ResourceDTO> list(List<Long> resourceIds, String classify) {
		// 一级资源
		ResourceQueryDTO resourceQueryDTO = ResourceQueryDTO.of(AccessConstant.RESOURCE_ROOT_ID, resourceIds, ResourceStatusEnum.NORMAL.getCode(), classify);
		List<ResourcePO> groupList = resourceApplication.query(resourceQueryDTO);
		List<ResourceDTO> groupRescs = new ArrayList<>(groupList.size());
		for (ResourcePO groupRescPO : groupList) {
			ResourceDTO groupResc = ObjectCopier.copyObject(ResourceDTO.class, groupRescPO);

			// 二级资源
			List<ResourcePO> modeList = resourceApplication.query(groupRescPO.getId(), resourceIds);
			List<ResourceDTO> modeRescs = new ArrayList<>(modeList.size());
			for (ResourcePO modeRescPO : modeList) {
				ResourceDTO modeResc = ObjectCopier.copyObject(ResourceDTO.class, modeRescPO);

				// 三级资源
				List<ResourcePO> methodList = resourceApplication.query(modeRescPO.getId(), resourceIds);
				modeResc.setChildren(ObjectCopier.copyList(ResourceDTO.class, methodList));
				modeRescs.add(modeResc);
			}

			groupResc.setChildren(modeRescs);
			groupRescs.add(groupResc);
		}
		return groupRescs;
	}

	/**
	 * 查询上帝端角色的资源详情
	 */
	private List<ResourceDTO> list(Long roleId, List<Long> resourceIds, String classify) {
		// 一级资源
		//List<ResourcePO> groupList = resourceApplication.query(AccessConstant.RESOURCE_ROOT_ID, resourceIds);
		ResourceQueryDTO resourceQueryDTO = ResourceQueryDTO.of(AccessConstant.RESOURCE_ROOT_ID, resourceIds, ResourceStatusEnum.NORMAL.getCode(), classify);
		List<ResourcePO> groupList = resourceApplication.query(resourceQueryDTO);
		List<ResourceDTO> groupRescs = new ArrayList<>(groupList.size());
		for (ResourcePO groupRescPO : groupList) {
			ResourceDTO groupResc = ObjectCopier.copyObject(ResourceDTO.class, groupRescPO);

			// 二级资源
			List<ResourcePO> modeList = resourceApplication.query(groupRescPO.getId(), resourceIds);
			List<ResourceDTO> modeRescs = new ArrayList<>(modeList.size());
			for (ResourcePO modeRescPO : modeList) {
				ResourceDTO modeResc = ObjectCopier.copyObject(ResourceDTO.class, modeRescPO);

				// 三级资源
				List<ResourcePO> methodList = resourceApplication.query(modeRescPO.getId(), resourceIds);
				List<ResourceDTO> methodRescs = new ArrayList<>(methodList.size());
				for (ResourcePO methodRescPO : methodList) {
					ResourceDTO methodResc = ObjectCopier.copyObject(ResourceDTO.class, methodRescPO);
					methodResc.setHasResource(hasResource(roleId, methodResc.getId()));
					methodRescs.add(methodResc);
				}

				modeResc.setHasResource(hasResource(roleId, modeResc.getId()));
				modeResc.setChildren(methodRescs);
				modeRescs.add(modeResc);
			}

			groupResc.setHasResource(hasResource(roleId, groupResc.getId()));
			groupResc.setChildren(modeRescs);
			groupRescs.add(groupResc);
		}
		return groupRescs;
	}

	/**
	 * 查询上帝端角色是否拥有该资源
	 */
	private boolean hasResource(Long roleId, Long resourceId) {
		RoleResourcePK roleResourcePK = new RoleResourcePK(roleId, resourceId);
		return roleResourceRepository.existsById(roleResourcePK);
	}
}
