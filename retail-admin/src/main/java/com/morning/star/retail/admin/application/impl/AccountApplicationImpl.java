package com.morning.star.retail.admin.application.impl;

import com.morning.star.retail.admin.application.AccountApplication;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.entity.AccountEntity;
import com.morning.star.retail.admin.entity.AccountEntityWater;
import com.morning.star.retail.admin.entity.repository.AccountRepository;
import com.morning.star.retail.admin.entity.repository.WaterRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.LineStatusEnum;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.admin.helper.StoreService;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.shiro.util.CryptoUtil;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/17 11:06
 */
@Service
@Transactional
public class AccountApplicationImpl implements AccountApplication {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private GroupService groupService;

	@Autowired
	private StoreService storeService;

	@Override
	public void addGroupAccount(AccountGroupAddDTO dto) {
		AccountEntity entity = new AccountEntity();
		GroupInfoDTO groupInfoDTO = groupService.get(dto.getGroupCode());
		Validate.notNull(groupInfoDTO, "集团不存在：" + dto.getGroupCode());

		Validate.isTrue(AccountLevelEnum.GROUP_ADMIN.getCode().equals(dto.getAccountLevel()) ||
				AccountLevelEnum.GROUP_NORMAL.getCode().equals(dto.getAccountLevel()),
			"账号等级错误：" + dto.getAccountLevel());

		copyBaseAccount(entity, dto);
		if (AccountLevelEnum.GROUP_ADMIN.getCode().equals(dto.getAccountLevel())) {
			Validate.isTrue(!accountRepository.existsByGroupCodeAndAccountLevel(dto.getGroupCode(), dto.getAccountLevel()),
				"该集团超级管理员已存在!");
			entity.setAccessIds(groupInfoDTO.getAccessIds());
		}


		entity.setGroupCode(groupInfoDTO.getGroupCode());
		entity.setGroupName(groupInfoDTO.getGroupName());

		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "创建集团账号");
	}

	@Override
	public void addStoreAccount(AccountStoreAddDTO dto) {
		AccountEntity entity = new AccountEntity();
		StoreDTO storeDTO = storeService.get(dto.getStoreCode());
		Validate.isTrue(AccountLevelEnum.STORE_ADMIN.getCode().equals(dto.getAccountLevel()) ||
				AccountLevelEnum.STORE_CLERK.getCode().equals(dto.getAccountLevel()) ||
				AccountLevelEnum.STORE_SELLER.getCode().equals(dto.getAccountLevel()),
			"账号等级错误：" + dto.getAccountLevel());
		copyBaseAccount(entity, dto);
		if (AccountLevelEnum.STORE_ADMIN.getCode().equals(dto.getAccountLevel())) {
			Validate.isTrue(!accountRepository.existsByStoreCodeAndAccountLevel(dto.getStoreCode(), dto.getAccountLevel()),
				"该门店已经存在管理员!");
			entity.setAccessIds(storeDTO.getAccessIds());
		}

		Validate.notNull(storeDTO, "门店不存在：" + dto.getStoreCode());
		Validate.isTrue(dto.getGroupCode().equals(storeDTO.getGroupCode()), "集团信息与门店不匹配");
		entity.setGroupCode(storeDTO.getGroupCode());
		entity.setGroupName(storeDTO.getGroupName());
		entity.setStoreCode(storeDTO.getStoreCode());
		entity.setStoreName(storeDTO.getStoreName());

		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "创建门店账号");
	}

	private void copyBaseAccount(AccountEntity entity, AccountBaseDTO dto) {
		Validate.isTrue(!accountRepository.existsByAccount(dto.getAccount()), "登录账号已存在");
		entity.setSalt(RandomUtil.generateString(RetailDefaultConst.SALT_LENGTH));
		entity.setIsOnline(LineStatusEnum.OFFLINE.getCode());
		entity.setStatus(LoginAccountStatusEnum.NORMAL.getCode());
		entity.setLoginCount(0);
		entity.setPassword(CryptoUtil.encryptPassword(dto.getPassword(), entity.getSalt()));
		entity.setAccount(dto.getAccount());
		entity.setEmail(dto.getEmail());
		entity.setAccessIds(dto.getAccessIds());
		entity.setAccountLevel(dto.getAccountLevel());
		entity.setMobile(dto.getMobile());
		entity.setName(dto.getName());
	}

	@Override
	public void modifyAccount(ModifyAccountDTO dto) {
		AccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.notNull(entity, "修改的账号不存在");
		checkPermission(entity);

		// 目前供应商账号无权限设置
		if (!AccountLevelEnum.SUPPLIER.getCode().equals(UserUtils.currentUser().getTag("accountLevel"))) {
			Validate.notEmpty(dto.getAccessIds(), "权限角色不能为空");
			entity.setAccessIds(dto.getAccessIds());
		}
		if (StringUtils.isNotBlank(dto.getName()))
			entity.setName(dto.getName());
		if (StringUtils.isNotBlank(dto.getEmail()))
			entity.setEmail(dto.getEmail());
		if (StringUtils.isNotBlank(dto.getMobile()))
			entity.setMobile(dto.getMobile());
		if (StringUtils.isNotBlank(dto.getIcon()))
			entity.setIcon(dto.getIcon());
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号");
	}

	@Override
	public void changePassword(ChangePasswordDTO dto) {
		Validate.notEmpty(dto.getPassword(), "密码不能为空");
		AccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.notNull(entity, "修改的账号不存在");
		checkPermission(entity);

		entity.setPassword(CryptoUtil.encryptPassword(dto.getPassword(), entity.getSalt()));
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号密码");
	}

	@Override
	public void delete(String account) {
		AccountEntity entity = accountRepository.getByAccount(account);
		Validate.notNull(entity, "登录账号不存在");
		Validate.isTrue(!entity.getId().equals(UserUtils.currentUser().getId()), "不能删除自己");
		checkPermission(entity);

		entity.delete();
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "删除账号");
	}

	@Override
	public void changeSelfPassword(ChangeSelfPasswordDTO dto) {
		Validate.notEmpty(dto.getNewPassword(), "密码不能为空");

		AccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.isTrue(entity != null, "修改的账号不存在");
		checkPermission(entity);

		String oldPassword = CryptoUtil.encryptPassword(dto.getOldPassword(), entity.getSalt());
		Validate.isTrue(oldPassword.equals(entity.getPassword()), "原密码不正确");

		// 修改密码
		entity.setPassword(CryptoUtil.encryptPassword(dto.getNewPassword(), entity.getSalt()));
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号密码");
	}

	@Override
	public void deleteByGroupCode(String groupCode) {
		List<AccountEntity> list = accountRepository.getByGroupCode(groupCode);
		for (AccountEntity entity : list) {
			checkPermission(entity);
			entity.delete();
		}
		accountRepository.save(list);
		for (AccountEntity entity : list) {
			waterRepository.save(entity, AccountEntityWater.class, "删除集团下所有集团账号");
		}
	}

	@Override
	public void changeGroupAdminAccessIds(String groupCode, String accessIds) {
		List<AccountEntity> list = accountRepository.getByGroupCodeAndAccountLevel(groupCode, AccountLevelEnum.GROUP_ADMIN.getCode());
		if (list == null) {
			return;
		}
		for (AccountEntity entity : list) {
			entity.setAccessIds(accessIds);
		}
		accountRepository.save(list);
		for (AccountEntity entity : list) {
			waterRepository.save(entity, AccountEntityWater.class, "修改集团超级管理员角色");
		}
	}

	@Override
	public void changeStoreAdminAccessIds(String storeCode, String accessIds) {
		List<AccountEntity> list = accountRepository.getByStoreCodeAndAccountLevel(storeCode, AccountLevelEnum.GROUP_ADMIN.getCode());
		if (list == null) {
			return;
		}
		for (AccountEntity entity : list) {
			entity.setAccessIds(accessIds);
		}
		accountRepository.save(list);
		for (AccountEntity entity : list) {
			waterRepository.save(entity, AccountEntityWater.class, "修改门店超级管理员角色");
		}
	}

	private void checkPermission(AccountEntity accountEntity) {
		UserInfo userInfo = UserUtils.currentUser();
		// 修改的账户级别
		String accountLevel = accountEntity.getAccountLevel();
		if (accountEntity.getId().equals(userInfo.getId())) {
			return;
		}
		if (AccountLevelEnum.GOD.getCode().equals(accountLevel)) {
			throw new IllegalArgumentException("不允许修改GOD账号");
		}
		if (AccountLevelEnum.GOD.getCode().equals(userInfo.getTag("accountLevel"))) {
			return;
		}

		if (AccountLevelEnum.GROUP_ADMIN.getCode().equals(accountLevel) ||
			AccountLevelEnum.GROUP_NORMAL.getCode().equals(accountLevel)) {

			Validate.isTrue(AccountLevelEnum.GROUP_ADMIN.getCode().equals(userInfo.getTag("accountLevel")),
				"非集团管理员不允许修改");
			new UserPermission(userInfo).tag("groupCode", accountEntity.getGroupCode()).pass();
		}
		if (AccountLevelEnum.STORE_ADMIN.getCode().equals(accountLevel) ||
			AccountLevelEnum.STORE_CLERK.getCode().equals(accountLevel) ||
			AccountLevelEnum.STORE_SELLER.getCode().equals(accountLevel)) {

			if (AccountLevelEnum.storeOwnLevel.contains(userInfo.getTag("accountLevel"))) {
				new UserPermission(userInfo)
					.tag("groupCode", accountEntity.getGroupCode())
					.tag("storeCode", accountEntity.getStoreCode())
					.pass();
			}
			if (AccountLevelEnum.groupOwnLevel.contains(userInfo.getTag("accountLevel"))) {
				new UserPermission(userInfo)
					.tag("groupCode", accountEntity.getGroupCode())
					.pass();
			}

		}
	}

	@Override
	public void updateLoginCount(String account) {
		AccountEntity accountEntity = accountRepository.getByAccount(account);
		if (accountEntity != null) {
			if (accountEntity.getLoginCount() == null) {
				accountEntity.setLoginCount(1);
			} else {
				accountEntity.setLoginCount(accountEntity.getLoginCount() + 1);
			}
			accountRepository.save(accountEntity);
		}
	}
}
