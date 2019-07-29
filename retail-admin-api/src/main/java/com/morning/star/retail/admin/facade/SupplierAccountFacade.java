package com.morning.star.retail.admin.facade;

import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.base.sms.CaptchaDTO;


public interface SupplierAccountFacade {
	void captcha(String mobile, AccountLevelEnum levelEnum);

	AccountDTO checkCaptcha(CaptchaDTO dto, AccountLevelEnum levelEnum);

	void addAccount(AccountSupplierAddDTO dto);

	AccountDTO getAccount(String account);

	AccountDTO getAccountByName(String name);

	void modifyAccount(FirstModifyAccountDTO dto);

	void changePassword(ChangePasswordDTO dto);

	void changeSelfPassword(ChangeSelfPasswordDTO dto);

	void addLoginCount(String account, AccountLevelEnum levelEnum);

}
