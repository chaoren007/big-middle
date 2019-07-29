package com.morning.star.retail.admin.facade.impl;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.morning.star.retail.admin.application.ResourceApplication;
import com.morning.star.retail.admin.application.RoleApplication;
import com.morning.star.retail.admin.application.RoleResourceApplication;
import com.morning.star.retail.admin.bean.RoleDO;
import com.morning.star.retail.admin.constant.AccessConstant;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.entity.RoleResourcePK;
import com.morning.star.retail.admin.entity.repository.RoleResourceRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.ChangeTypeEnum;
import com.morning.star.retail.admin.enums.RoleClassifyEnum;
import com.morning.star.retail.admin.enums.RoleStatusEnum;
import com.morning.star.retail.admin.exception.RoleErrorCode;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.admin.helper.StoreService;
import com.morning.star.retail.admin.logicservice.impl.ResourceLogicServiceImpl;
import com.morning.star.retail.admin.po.RolePO;
import com.morning.star.retail.admin.utils.BeanUtils;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.group.GroupQueryDTO;
import com.morning.star.retail.dto.group.GroupQueryListDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.objectcopier.ObjectCopier;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleFacadeImpl implements RoleFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleFacadeImpl.class);
	private static final Gson GSON = new Gson();

	@Autowired
	private RoleApplication roleApplication;
	@Autowired
	private ResourceApplication resourceApplication;
	@Autowired
	private RoleResourceApplication roleResourceApplication;
	@Autowired
	private ResourceLogicServiceImpl resourceLogicService;
	@Autowired
	private AccountFacade accountFacade;
	@Autowired
	private GroupService groupService;
	@Autowired
	private StoreService storeService;

	@Autowired
	private RoleResourceRepository roleResourceRepository;

	@Override
	public PageBeans<RoleDTO> page(RoleQueryDTO queryDTO) {
		if (queryDTO.getPageNo() != null && queryDTO.getPageSize() != null) {
			PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		}
		queryDTO.setStatus(RoleStatusEnum.NORMAL.getCode());
		List<RolePO> list = roleApplication.query(queryDTO);
		return ObjectCopier.copierPage(RoleDTO.class, new PageBeans<>(list));
	}

	@Override
	public List<RoleDTO> list(RoleQueryDTO queryDTO) {
		queryDTO.setStatus(RoleStatusEnum.NORMAL.getCode());
		List<RolePO> list = roleApplication.query(queryDTO);
		return ObjectCopier.copyList(RoleDTO.class, list);
	}

	@Override
	@Transactional
	public void create(RoleFormDTO formDTO) {
		// 检查角色名是否可用
		checkNotExist(formDTO);
		// 新增角色
		Long roleId = roleApplication.create(RoleDO.from(formDTO));
		// 新增角色资源关联
		createRoleResc(roleId, formDTO.getGroupPerms());
	}

	@Override
	@Transactional
	public void modify(RoleFormDTO formDTO) {
		RolePO rolePO = checkQueryOne(RoleQueryDTO.from(formDTO));
		// 权限回收
		List<Long> newList = getResourceIds(formDTO.getGroupPerms());
		List<Long> oldList = roleResourceApplication.queryResourceId(formDTO.getRoleId());
		// 修改后与修改前保持一致
		if (newList.size() == oldList.size() && newList.containsAll(oldList)) {
			return;
		}
		// 获取无效权限资源，即修改前与修改后的权限资源差集
		oldList.removeAll(newList);
		// 清理无效角色资源关联
		cleanInvalidResource(formDTO.getAccountLevel(), oldList, rolePO);

		// 删除老的角色资源关联
		roleResourceApplication.deleteByRoleId(formDTO.getRoleId());
		// 新增新的角色资源关联
		createRoleResc(formDTO.getRoleId(), formDTO.getGroupPerms());
	}

	/**
	 * 权限资源格式转化
	 */
	private List<Long> getResourceIds(List<GroupPermDTO> groupPerms) {
		List<Long> list = new ArrayList<>();
		for (GroupPermDTO groupPermDTO : groupPerms) {
			list.add(groupPermDTO.getPermId());
			for (ModePermDTO modePermDTO : groupPermDTO.getModePerms()) {
				list.add(modePermDTO.getPermId());
				list.addAll(modePermDTO.getMethodPerms());
			}
		}
		return list;
	}

	/**
	 * 清理无效权限资源
	 */
	private void cleanInvalidResource(String accountLevel, List<Long> invalidResourceIds, RolePO rolePO) {
		// 如果无效权限资源不存在，说明修改后的权限包含修改前的权限
		if (CollectionUtils.isEmpty(invalidResourceIds)) {
			return;
		}
		String roleId = String.valueOf(rolePO.getId());
		List<Long> roleIds = null;
		if (AccountLevelEnum.GOD.getCode().equals(accountLevel)) { // 上帝端账户
			if (RoleClassifyEnum.STORE.getCode().equals(rolePO.getClassify())) { // 门店方案
				// 获取使用该门店方案的集团
				List<String> groupCodes = queryGroupCode(roleId, null);
				if (groupCodes.isEmpty()) {
					return;
				}
				// 获取对应集团下的门店方案和对应集团所有门店下的角色
				roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(null, RoleClassifyEnum.GROUP.getCode(), groupCodes));
			} else if (RoleClassifyEnum.GROUP.getCode().equals(rolePO.getClassify())) { // 集团方案
				// 获取使用该集团方案的集团
				List<String> groupCodes = queryGroupCode(null, roleId);
				if (groupCodes.isEmpty()) {
					return;
				}
				// 获取对应集团下的集团方案
				roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(rolePO.getClassify(), null, groupCodes));
			}
		} else if (AccountLevelEnum.GROUP_ADMIN.getCode().equals(accountLevel)
			|| AccountLevelEnum.GROUP_NORMAL.getCode().equals(accountLevel)) { // 集团端账户
			if (RoleClassifyEnum.STORE.getCode().equals(rolePO.getClassify())) { // 门店方案
				// 获取使用该方案的门店
				List<String> storeCodes = queryStoreCodes(roleId);
				if (storeCodes.isEmpty()) {
					return;
				}
				// 获取对应门店下的角色
				roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(storeCodes, rolePO.getGroupCode()));
			}
		}
		if (CollectionUtils.isEmpty(roleIds)) {
			return;
		}
		// 删除角色资源关联
		roleResourceApplication.delete(roleIds, invalidResourceIds);
	}

	@Override
	@Transactional
	public void delete(RoleFormDTO formDTO) {
		// 检查角色是否存在
		RolePO rolePO = checkQueryOne(RoleQueryDTO.from(formDTO));
		// 检查角色是否未被使用
		checkNotUse(rolePO);
		// 删除角色
		roleApplication.delete(RoleDO.from(formDTO));
	}

	/**
	 * 检查角色
	 */
	private RolePO checkQueryOne(RoleQueryDTO queryDTO) {
		RolePO rolePO = roleApplication.queryOne(queryDTO);
		if (rolePO == null) {
			throw RoleErrorCode.ROLE_NOT_FIND.build(queryDTO.getId());
		}
		return rolePO;
	}

	/**
	 * 检查角色是否未被使用
	 */
	private void checkNotUse(RolePO rolePO) {
		String roleId = String.valueOf(rolePO.getId());
		if (RoleClassifyEnum.STORE.getCode().equals(rolePO.getClassify())) { // 门店方案
			if (StringUtils.isEmpty(rolePO.getStoreCode())) { // 上帝端或集团端创建的，需要校验集团，集团账户，门店是否使用
				checkNotUseByGroup(roleId, null);
				checkNotUseByStore(roleId);
			} else { // 门店端创建的，需要校验门店账户是否使用
				checkNotUseByLoginAccount(roleId);
			}
		} else if (RoleClassifyEnum.GROUP.getCode().equals(rolePO.getClassify())) { // 集团方案，需要校验集团，集团账户是否使用
			checkNotUseByGroup(null, roleId);
			checkNotUseByGodLoginAccount(roleId);
		}
	}

	/**
	 * 检查角色是否未被集团使用
	 */
	private void checkNotUseByGroup(String findRoleIds, String findGroupAccessIds) {
		List<GroupInfoDTO> groupPOS = queryGroup(findRoleIds, findGroupAccessIds);
		if (CollectionUtils.isNotEmpty(groupPOS)) {
			throw RoleErrorCode.ROLE_HAS_USED.build();
		}
	}

	/**
	 * 查询使用了指定门店方案或集团方案的集团编码
	 */
	private List<String> queryGroupCode(String findRoleIds, String findGroupAccessIds) {
		List<GroupInfoDTO> groupPOS = queryGroup(findRoleIds, findGroupAccessIds);
		List<String> groupCodes = new ArrayList<>(groupPOS.size());
		for (GroupInfoDTO groupInfoDTO : groupPOS) {
			groupCodes.add(groupInfoDTO.getGroupCode());
		}
		return groupCodes;
	}

	/**
	 * 查询使用了指定门店方案或集团方案的集团
	 */
	private List<GroupInfoDTO> queryGroup(String findRoleIds, String findGroupAccessIds) {
		GroupQueryDTO groupQueryDTO = new GroupQueryDTO();
		groupQueryDTO.setFindRoleIds(findRoleIds);
		groupQueryDTO.setFindGroupAccessIds(findGroupAccessIds);
		GroupQueryListDTO groupQueryListDTO = new GroupQueryListDTO();
		BeanUtils.copy(groupQueryDTO, groupQueryListDTO);
		return groupService.query(groupQueryListDTO);
	}

	/**
	 * 检查角色是否未被集团账号使用
	 */
	private void checkNotUseByGodLoginAccount(String findGroupAccessIds) {
		if (accountFacade.existsByAccessIds(findGroupAccessIds)) {
			throw RoleErrorCode.ROLE_HAS_USED.build();
		}
	}

	/**
	 * 检查角色是否未被门店使用
	 */
	private void checkNotUseByStore(String findAccessIds) {
		List<StoreDTO> companyPOS = storeService.queryStore(findAccessIds);
		if (CollectionUtils.isNotEmpty(companyPOS)) {
			throw RoleErrorCode.ROLE_HAS_USED.build();
		}
	}

	/**
	 * 查询使用了指定门店方案的门店编码
	 */
	private List<String> queryStoreCodes(String findAccessIds) {
		List<StoreDTO> stores = storeService.queryStore(findAccessIds);
		List<String> storeCodes = new ArrayList<>(stores.size());
		for (StoreDTO store : stores) {
			storeCodes.add(store.getStoreCode());
		}
		return storeCodes;
	}


	/**
	 * 检查角色是否未被门店账号使用
	 */
	private void checkNotUseByLoginAccount(String findAccessIds) {
		if (accountFacade.existsByAccessIds(findAccessIds)) {
			throw RoleErrorCode.ROLE_HAS_USED.build();
		}
	}

	/**
	 * 检查角色是否不存在
	 */
	private void checkNotExist(RoleFormDTO formDTO) {
		boolean isExist = roleApplication.isExist(RoleQueryDTO.from(formDTO));
		if (isExist) {
			throw RoleErrorCode.ROLE_NAME_EXIST.build(formDTO.getRoleName());
		}
	}

	/**
	 * 新增资源角色关联
	 */
	private void createRoleResc(Long roleId, List<GroupPermDTO> groupPerms) {
		for (GroupPermDTO groupPerm : groupPerms) {
			// 分组资源
			createRoleResc(roleId, groupPerm.getPermId(), AccessConstant.RESOURCE_ROOT_ID);
			List<ModePermDTO> modePerms = groupPerm.getModePerms();
			for (ModePermDTO modePerm : modePerms) {
				// 模块资源
				createRoleResc(roleId, modePerm.getPermId(), groupPerm.getPermId());
				List<Long> methodPerms = modePerm.getMethodPerms();
				for (Long methodPermId : methodPerms) {
					// 方法资源
					createRoleResc(roleId, methodPermId, modePerm.getPermId());
				}
			}
		}
	}

	/**
	 * 新增资源角色关联
	 */
	private void createRoleResc(Long roleId, Long resourceId, Long parentId) {
		// TODO 如果是集团管理员创建角色，需要验证集团管理员所有角色是否授权该资源
		resourceApplication.checkExist(resourceId, parentId);
		RoleResourcePK roleResourcePK = new RoleResourcePK(roleId, resourceId);
		Validate.isTrue(!roleResourceRepository.existsById(roleResourcePK),
			String.format("角色【%s】资源【%s】关联已存在", roleId, resourceId));
		roleResourceApplication.create(roleId, resourceId);
	}

	@Override
	public List<String> queryRole(String roleIds) {
		return roleApplication.queryRole(checkGetRoleIds(roleIds));
	}

	@Override
	public List<String> queryResource(String roleIds) {
		List<Long> resourceIds = roleResourceApplication.queryResourceId(checkGetRoleIds(roleIds));
		return resourceApplication.queryResource(resourceIds);
	}

	/**
	 * 获取有效角色id
	 */
	private List<Long> checkGetRoleIds(String roleIds) {
		return roleApplication.checkGetRoleIds(roleIds, RoleStatusEnum.NORMAL);
	}

	@Override
	public RoleDetailDTO detail(RoleQueryDTO queryDTO) {
		List<RolePO> list = roleApplication.query(queryDTO);
		if (list.isEmpty()) {
			throw RoleErrorCode.ROLE_NOT_FIND.build(queryDTO.getId());
		}
		List<ResourceDTO> resources = resourceLogicService.list(queryDTO.getId(), queryDTO.getGroupCode(),
			queryDTO.getStoreCode(), queryDTO.getAccountLevel(), queryDTO.getClassify());
		return RoleDetailDTO.of(list.get(0).getName(), resources);
	}

	@Override
	public List<ResourceDTO> accessInfo(String account, String resourceLevel) {
		AccountDTO loginAccount = accountFacade.getAccount(account);
		String strRoleIds = loginAccount.getAccessIds();

		if (!StringUtils.isEmpty(strRoleIds)) {
			// 获取有效角色id
			List<Long> roleIds = checkGetRoleIds(strRoleIds);
			// 查询角色拥有的资源id
			List<Long> resourceIds = roleResourceApplication.queryResourceId(roleIds);
			if (resourceIds.isEmpty()) {
				return new ArrayList<>();
			}
			return resourceLogicService.list(resourceIds, "");
		}
		return new ArrayList<>();
	}

	@Override
	public void changeRole(ChangeRoleDTO changeRoleDTO) {
		List<Long> newRoleIds = strToList(changeRoleDTO.getNewRoleIds());
		List<Long> oldRoleIds = strToList(changeRoleDTO.getOldRoleIds());
		// 新方案与原方案保持一致，即没有变更方案
		if (newRoleIds.size() == oldRoleIds.size() && newRoleIds.containsAll(oldRoleIds)) {
			return;
		}
		List<Long> newResourceIds = roleResourceApplication.queryResourceId(newRoleIds);
		List<Long> oldResourceIds = roleResourceApplication.queryResourceId(oldRoleIds);
		// 获取无效权限资源，即修改前与修改后的权限资源差集
		oldResourceIds.removeAll(newResourceIds);
		if (oldResourceIds.isEmpty()) {
			return;
		}
		List<Long> roleIds = null;
		if (ChangeTypeEnum.ROOT_GROUP_GROUP.equals(changeRoleDTO.getChangeType())) { // 上帝端变更集团的集团方案
			// 获取该集团下的集团方案
			roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(RoleClassifyEnum.GROUP.getCode(), null, changeRoleDTO.getGroupCode()));
		} else if (ChangeTypeEnum.ROOT_GROUP_COMPANY.equals(changeRoleDTO.getChangeType())) { // 上帝端变更集团的门店方案
			// 获取该集团下的门店方案和该集团所有门店下的角色
			roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(null, RoleClassifyEnum.GROUP.getCode(), changeRoleDTO.getGroupCode()));
		} else if (ChangeTypeEnum.GROUP_COMPANY_COMPANY.equals(changeRoleDTO.getChangeType())) { // 集团端变更门店的门店方案
			// 获取该门店下的角色
			roleIds = roleApplication.queryRoleIds(RoleQueryDTO.of(changeRoleDTO.getStoreCode(), changeRoleDTO.getGroupCode()));
		}
		if (CollectionUtils.isEmpty(roleIds)) {
			return;
		}
		// 删除角色资源关联
		roleResourceApplication.delete(roleIds, oldResourceIds);
	}

	/**
	 * 逗号分割的字符串转集合
	 */
	private List<Long> strToList(String roleIds) {
		if (StringUtils.isEmpty(roleIds)) {
			return new ArrayList<>();
		}
		return Arrays.stream(roleIds.split(","))
			.map(s -> Long.parseLong(s.trim()))
			.collect(Collectors.toList());
	}

}
