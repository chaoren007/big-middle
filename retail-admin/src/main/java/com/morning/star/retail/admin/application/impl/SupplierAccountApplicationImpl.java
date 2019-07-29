package com.morning.star.retail.admin.application.impl;

import com.morning.star.retail.admin.application.SupplierAccountApplication;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.entity.AccountEntityWater;
import com.morning.star.retail.admin.entity.SupplierAccountEntity;
import com.morning.star.retail.admin.entity.repository.SupplierAccountRepository;
import com.morning.star.retail.admin.entity.repository.WaterRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.LineStatusEnum;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.group.GroupInfoDTO;
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

import java.util.Date;

/**
 * @author ethan
 * @create_time 2018/8/17 11:06
 */
@Service
@Transactional
public class SupplierAccountApplicationImpl implements SupplierAccountApplication {

	@Autowired
	private SupplierAccountRepository accountRepository;

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private GroupService groupService;

	@Override
	public void addAccount(AccountSupplierAddDTO dto) {
		SupplierAccountEntity entity = new SupplierAccountEntity();
		Validate.isTrue(AccountLevelEnum.SUPPLIER.getCode().equals(dto.getAccountLevel()),
			"账号等级错误：" + dto.getAccountLevel());
		copyBaseAccount(entity, dto);
		Validate.isTrue(!accountRepository.existsBySupplierCodeAndAccountLevel(dto.getSupplierCode(), dto.getAccountLevel()),
			"该供应商已经存在账号!");

		GroupInfoDTO groupInfoDTO = groupService.get(dto.getGroupCode());
		Validate.isTrue(groupInfoDTO != null, "集团信息不存在：%s", dto.getGroupCode());

		entity.setGroupCode(groupInfoDTO.getGroupCode());
		entity.setGroupName(groupInfoDTO.getGroupName());
		entity.setSupplierCode(dto.getSupplierCode());
		entity.setSupplierName(dto.getSupplierName());

		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "创建供应商账号");
	}

	private void copyBaseAccount(SupplierAccountEntity entity, AccountBaseDTO dto) {
		Validate.isTrue(!accountRepository.existsByAccount(dto.getAccount()), "登录账号已存在");
		if (StringUtils.isNotBlank(dto.getName())) {
			Validate.isTrue(!accountRepository.existsByName(dto.getName()), "用户名已存在");
		}
		entity.setSalt(RandomUtil.generateString(RetailDefaultConst.SALT_LENGTH));
		entity.setIsOnline(LineStatusEnum.OFFLINE.getCode());
		entity.setStatus(LoginAccountStatusEnum.NORMAL.getCode());
		entity.setLoginCount(0);
		entity.setPassword(CryptoUtil.encryptPassword(dto.getPassword(), entity.getSalt()));
		entity.setAccount(dto.getAccount());
		entity.setEmail(dto.getEmail());
		entity.setAccountLevel(dto.getAccountLevel());
		entity.setMobile(dto.getMobile());
		entity.setName(dto.getName());
	}

	@Override
	public void modifyAccount(FirstModifyAccountDTO dto) {
		SupplierAccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.isTrue(entity != null, "修改的账号不存在");
		Validate.isTrue(StringUtils.isBlank(entity.getName()), "账号已经首次修改过");
		checkPermission(entity);

		// 目前供应商账号无权限设置
		if (StringUtils.isNotBlank(dto.getName())) {
			if (!dto.getName().equals(entity.getName())) {
				Validate.isTrue(!accountRepository.existsByName(dto.getName()),
					"修改的用户名已存在");
				entity.setName(dto.getName());
			}
		}
		entity.setEmail(dto.getEmail());
		entity.setIcon(dto.getIcon());
		entity.setPassword(CryptoUtil.encryptPassword(dto.getPassword(), entity.getSalt()));
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号");
	}

	@Override
	public void changePassword(ChangePasswordDTO dto) {
		Validate.notEmpty(dto.getPassword(), "密码不能为空");
		SupplierAccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.notNull(entity, "修改的账号不存在");

		entity.setPassword(CryptoUtil.encryptPassword(dto.getPassword(), entity.getSalt()));
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号密码");
	}

	@Override
	public void changeSelfPassword(ChangeSelfPasswordDTO dto) {
		Validate.notEmpty(dto.getNewPassword(), "密码不能为空");

		SupplierAccountEntity entity = accountRepository.getByAccount(dto.getAccount());
		Validate.isTrue(entity != null, "修改的账号不存在");
		checkPermission(entity);

		String oldPassword = CryptoUtil.encryptPassword(dto.getOldPassword(), entity.getSalt());
		Validate.isTrue(oldPassword.equals(entity.getPassword()), "原密码不正确");

		// 修改密码
		entity.setPassword(CryptoUtil.encryptPassword(dto.getNewPassword(), entity.getSalt()));
		accountRepository.save(entity);
		waterRepository.save(entity, AccountEntityWater.class, "修改账号密码");
	}

	private void checkPermission(SupplierAccountEntity entity) {
		UserInfo userInfo = UserUtils.currentUser();
		String accountLevel = entity.getAccountLevel();
		new UserPermission(userInfo).tag("supplierCode", entity.getSupplierCode()).pass();
	}

	@Override
	public void addLoginCount(String account, AccountLevelEnum levelEnum) {
		SupplierAccountEntity accountEntity = accountRepository.getByAccountAndAccountLevel(account, levelEnum.getCode());
		if (accountEntity != null) {
			if (accountEntity.getLoginCount() == null) {
				accountEntity.setLoginCount(1);
			} else {
				accountEntity.setLoginCount(accountEntity.getLoginCount() + 1);
			}
			accountEntity.setLastLoginTime(new Date());
			accountRepository.save(accountEntity);
		}
	}
}
