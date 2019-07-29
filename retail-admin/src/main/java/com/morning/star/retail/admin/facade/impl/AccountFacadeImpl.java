package com.morning.star.retail.admin.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.application.AccountApplication;
import com.morning.star.retail.admin.dao.AccountDAO;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.entity.AccountEntity;
import com.morning.star.retail.admin.entity.repository.AccountRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.admin.utils.entity.BeanUtils;
import com.morning.star.retail.admin.utils.page.PageBeanAssembler;
import com.morning.star.retail.admin.utils.page.RowBoundsBuilder;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.base.sms.SmsRemoteService;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.shiro.util.CryptoUtil;
import com.morning.star.retail.utils.page.PageBean;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2018/8/17 11:07
 */
@Service
public class AccountFacadeImpl implements AccountFacade {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private AccountApplication accountApplication;

	@Autowired
	private GroupService groupService;

	@Override
	public void addGroupAccount(AccountGroupAddDTO dto) {
		accountApplication.addGroupAccount(dto);
	}

	@Override
	public void addStoreAccount(AccountStoreAddDTO dto) {
		accountApplication.addStoreAccount(dto);
	}

	@Override
	public AccountDTO getAccount(String account) {
		AccountEntity accountEntity = accountRepository.getByAccount(account);
		if (accountEntity == null) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntity, accountDTO);
		return accountDTO;
	}

	@Override
	public AccountDTO getAccountById(Long uin) {
		AccountEntity accountEntity = accountRepository.findOne(uin);
		if (accountEntity == null) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntity, accountDTO);
		return accountDTO;
	}

	@Override
	public AccountDTO getStoreAccount(String account) {
		List<String> levels = new ArrayList<>();
		levels.add(AccountLevelEnum.STORE_ADMIN.getCode());
		levels.add(AccountLevelEnum.STORE_CLERK.getCode());
		levels.add(AccountLevelEnum.STORE_SELLER.getCode());
		return getAccount(account, levels);
	}

	@Override
	public AccountDTO getGroupAccount(String account) {
		List<String> levels = new ArrayList<>();
		levels.add(AccountLevelEnum.GOD.getCode());
		levels.add(AccountLevelEnum.GROUP_NORMAL.getCode());
		levels.add(AccountLevelEnum.GROUP_ADMIN.getCode());
		return getAccount(account, levels);
	}

	@Override
	public AccountDTO getAccount(String account, List<String> accountLevels) {
		AccountEntity accountEntity = accountRepository.getByAccountAndAccountLevelIn(account, accountLevels);
		if (accountEntity == null) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntity, accountDTO);
		return accountDTO;
	}

	@Override
	public AccountDTO getAccount(String account, List<String> accountLevels, String levelCode) {
		AccountDTO accountDTO = getAccount(account, accountLevels);
		if (account == null) {
			return null;
		}
		for (String accountLevel : accountLevels) {
			if ((accountLevel.equals(AccountLevelEnum.GOD.getCode()) ||
				accountLevel.equals(AccountLevelEnum.GROUP_ADMIN.getCode()) ||
				accountLevel.equals(AccountLevelEnum.GROUP_NORMAL.getCode())) &&
				levelCode.equals(accountDTO.getGroupCode()))
				return accountDTO;

			if ((accountLevel.equals(AccountLevelEnum.STORE_ADMIN.getCode()) ||
				accountLevel.equals(AccountLevelEnum.STORE_SELLER.getCode()) ||
				accountLevel.equals(AccountLevelEnum.STORE_CLERK.getCode())) &&
				levelCode.equals(accountDTO.getStoreCode()))
				return accountDTO;
		}
		return null;
	}

	@Override
	public List<AccountDTO> getAccountByGroup(String groupCode) {
		List<AccountEntity> accountEntityList = accountRepository.getByGroupCode(groupCode);

		return accountEntityList.stream().map(e -> {
			AccountDTO accountDTO = new AccountDTO();
			BeanUtils.copy(e, accountDTO);
			return accountDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public List<AccountDTO> getAccountByStore(String storeCode) {
		List<AccountEntity> accountEntityList = accountRepository.getByStoreCode(storeCode);

		return accountEntityList.stream().map(e -> {
			AccountDTO accountDTO = new AccountDTO();
			BeanUtils.copy(e, accountDTO);
			return accountDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public Boolean existGroupAccount(String groupCode) {
		return accountRepository.existsByGroupCode(groupCode);
	}

	@Override
	public void modifyAccount(ModifyAccountDTO dto) {
		accountApplication.modifyAccount(dto);
	}

	@Override
	public void changePassword(ChangePasswordDTO dto) {
		accountApplication.changePassword(dto);
	}

	@Override
	public void changeSelfPassword(ChangeSelfPasswordDTO dto) {
		accountApplication.changeSelfPassword(dto);
	}

	@Override
	public void changeGroupAdminAccessIds(String groupCode, String accessIds) {
		accountApplication.changeGroupAdminAccessIds(groupCode, accessIds);
	}

	@Override
	public void changeStoreAdminAccessIds(String storeCode, String accessIds) {
		accountApplication.changeStoreAdminAccessIds(storeCode, accessIds);
	}

	@Override
	public void delete(String account) {
		accountApplication.delete(account);
	}

	@Override
	public Boolean existsByAccessIds(String accessIds) {
		AccountDTO accountDTO = accountDAO.getOneByAccessIds(accessIds);
		return accountDTO != null;
	}

	@Override
	public PageBean<AccountSimpleDTO> query(QueryAccountDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<AccountDTO> page = accountDAO.selectAll(dto, rowBounds);
		return new PageBeanAssembler().toBean(page).to(AccountSimpleDTO.class);
	}

	@Override
	public void loginCheck(String account, String pwd) {
		AccountEntity entity = accountRepository.getByAccount(account);
		Validate.notNull(entity, "登录账号不存在");
		// 检查登录账户状态
		// 校验登录账户状态是否冻结
		if (LoginAccountStatusEnum.FREEZE.getCode().equals(entity.getStatus())) {
			throw new IllegalArgumentException("登录账号已冻结");
		}
		// 校验登录账户状态是否作废
		if (LoginAccountStatusEnum.DELETE.getCode().equals(entity.getStatus())) {
			throw new IllegalArgumentException("登录账号已作废");
		}
		// 检查集团信息
		GroupInfoDTO group = groupService.get(entity.getGroupCode());
		Validate.notNull(group, "未找到该集团信息");
		// 校验登录密码
		Validate.isTrue(CryptoUtil.verifyPassword(pwd, entity.getSalt(), entity.getPassword()),
			"用户密码错误");
	}
}
