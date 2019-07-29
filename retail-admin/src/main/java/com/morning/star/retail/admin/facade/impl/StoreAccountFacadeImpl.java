package com.morning.star.retail.admin.facade.impl;

import com.morning.star.retail.UserUtils;
import com.morning.star.retail.admin.application.AccountApplication;
import com.morning.star.retail.admin.bo.LoginBO;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.entity.AccountEntity;
import com.morning.star.retail.admin.entity.repository.AccountRepository;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.facade.StoreAccountFacade;
import com.morning.star.retail.admin.helper.DeviceService;
import com.morning.star.retail.admin.helper.StoreService;
import com.morning.star.retail.admin.utils.BeanUtils;
import com.morning.star.retail.base.enums.DeviceStatusEnum;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.exception.DeviceErrorCode;
import com.morning.star.retail.shiro.util.CryptoUtil;
import com.morning.star.retail.util.RandomUtil;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreAccountFacadeImpl implements StoreAccountFacade {

	@Autowired
	private AccountApplication accountApplication;
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StoreService storeService;
	@Autowired
	private DeviceService deviceService;

//	@Autowired
//	private BindingEquipmentFacade bindingEquipmentFacade;


	@Override
	public AdminLoginContent loginPos(LoginBO loginBO) {
		// 校验登录账户
		AccountEntity loginAccount = checkGetLoginAccount(loginBO);
		// 校验门店
		StoreDTO store = checkGetStore(loginAccount);
		// 校验设备
		checkDevice(loginBO);
		// 登录凭证
		String token = RandomUtil.generateString(RetailDefaultConst.TOKEN_LENGTH);
		// 账户信息
		AdminLoginContent loginContent = getAdminLoginContent(loginAccount, token, store);
		// 缓存
		UserUtils.setUserInfo(token, loginContent, 0);
		// 修改登录次数
		accountApplication.updateLoginCount(loginBO.getAccount());
		return loginContent;
	}

	private AccountEntity checkGetLoginAccount(LoginBO loginBO) {
		AccountEntity loginAccount = accountRepository.getByAccount(loginBO.getAccount());
		Validate.notNull(loginAccount, "登录账号不存在");

		// 检查登录账户状态
		Validate.isTrue(!LoginAccountStatusEnum.FREEZE.getCode().equals(loginAccount.getStatus()),
			"登录账号已冻结");
		Validate.isTrue(!LoginAccountStatusEnum.DELETE.getCode().equals(loginAccount.getStatus()),
			"登录账号已作废");

		// 校验密码
		Validate.isTrue(CryptoUtil.verifyPassword(loginBO.getPassword(), loginAccount.getSalt(), loginAccount.getPassword()),
			"登录账号或密码错误");
		return loginAccount;
	}

	/**
	 * 校验门店
	 */
	private StoreDTO checkGetStore(AccountEntity loginAccount) {
		StoreDTO storeDTO = storeService.get(loginAccount.getStoreCode());
		Validate.isTrue(storeDTO.getIsFree() == null || storeDTO.getIsFree() != 1,
			"门店已冻结");
		return storeDTO;
	}

	/**
	 * 校验设备
	 */
	private void checkDevice(LoginBO loginBO) {
		String deviceId = loginBO.getDeviceId();
		DeviceInfoDTO device = deviceService.checkGetDevice(deviceId);
		if (device == null || !device.getStatus().equals(DeviceStatusEnum.ACTIVATED.getCode())) {
			throw DeviceErrorCode.DEVICE_IS_UNACTIVATE.build();
		}
		if (device.getExpireDate() != null && device.getExpireDate().before(new Date())) {
			throw DeviceErrorCode.KEY_EXPIRED.build();
		}
		UserUtils.setDeviceInfo(deviceId, device, 0);
	}

	/**
	 * 登录信息
	 */
	private AdminLoginContent getAdminLoginContent(AccountEntity entity, String token, StoreDTO store) {
		AdminLoginContent loginContent = new AdminLoginContent();
		loginContent.setAccount(entity.getAccount());
		loginContent.setId(entity.getId());
		loginContent.setName(entity.getName());
		loginContent.setEmail(entity.getEmail());
		loginContent.setAccountLevel(entity.getAccountLevel());
		loginContent.setGroupCode(entity.getGroupCode());
		loginContent.setGroupName(entity.getGroupName());
		loginContent.setStoreCode(entity.getStoreCode());
		loginContent.setStoreName(store.getStoreName());
		loginContent.setAccountLevel(entity.getAccountLevel());
		loginContent.setToken(token);
		return loginContent;
	}

	@Override
	public AccountDTO getAdmin(String storeCode) {
		String level = AccountLevelEnum.STORE_ADMIN.getCode();
		List<AccountEntity> accountEntityList = accountRepository.getByStoreCodeAndAccountLevel(storeCode, level);
		if (accountEntityList == null || accountEntityList.isEmpty()) {
			return null;
		}
		AccountDTO accountDTO = new AccountDTO();
		BeanUtils.copy(accountEntityList.get(0), accountDTO);
		return accountDTO;
	}
}
