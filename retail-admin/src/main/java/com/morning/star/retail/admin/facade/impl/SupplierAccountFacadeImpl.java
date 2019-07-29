package com.morning.star.retail.admin.facade.impl;

import com.morning.star.retail.admin.application.SupplierAccountApplication;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.entity.SupplierAccountEntity;
import com.morning.star.retail.admin.entity.repository.SupplierAccountRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.SupplierAccountFacade;
import com.morning.star.retail.admin.helper.GroupService;
import com.morning.star.retail.admin.utils.entity.BeanUtils;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.base.sms.SmsRemoteService;
import com.morning.star.retail.shiro.util.CryptoUtil;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/8/17 11:07
 */
@Service
public class SupplierAccountFacadeImpl implements SupplierAccountFacade {

	private String CAPTCHA_LOGIN = "LOGIN_USER_";

	@Autowired
	private SupplierAccountRepository accountRepository;

	@Autowired
	private SupplierAccountApplication accountApplication;

	@Autowired
	private SmsRemoteService smsRemoteService;

	@Override
	public void captcha(String mobile, AccountLevelEnum levelEnum) {
		Validate.isTrue(accountRepository.existsByAccount(mobile), "该手机号不存在账号信息");
		smsRemoteService.sendCaptcha(mobile, CAPTCHA_LOGIN + levelEnum.getCode());
	}

	@Override
	public AccountDTO checkCaptcha(CaptchaDTO dto, AccountLevelEnum levelEnum) {
		smsRemoteService.checkCaptcha(dto.getMobile(), dto.getCaptcha(), CAPTCHA_LOGIN + levelEnum.getCode());
		AccountDTO accountDTO = getAccount(dto.getMobile());
		// 短信获取把密码修改为短信
		if (accountDTO != null) {
			accountDTO.setPassword(CryptoUtil.encryptPassword(dto.getCaptcha(), accountDTO.getSalt()));
		}
		return accountDTO;
	}

	@Override
	public void addAccount(AccountSupplierAddDTO dto) {
		accountApplication.addAccount(dto);
	}

	@Override
	public AccountDTO getAccount(String account) {
		SupplierAccountEntity accountEntity = accountRepository.getByAccount(account);
		if (accountEntity == null) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntity, accountDTO);
		return accountDTO;
	}

	@Override
	public AccountDTO getAccountByName(String name) {
		SupplierAccountEntity accountEntity = accountRepository.getByName(name);
		if (accountEntity == null) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntity, accountDTO);
		return accountDTO;
	}

	@Override
	public void modifyAccount(FirstModifyAccountDTO dto) {
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
	public void addLoginCount(String account, AccountLevelEnum levelEnum) {
		accountApplication.addLoginCount(account, levelEnum);
	}
}
