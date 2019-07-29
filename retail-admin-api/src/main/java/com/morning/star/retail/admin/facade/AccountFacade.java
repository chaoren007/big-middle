package com.morning.star.retail.admin.facade;

import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;


public interface AccountFacade {

	void addGroupAccount(AccountGroupAddDTO dto);

	void addStoreAccount(AccountStoreAddDTO dto);

	AccountDTO getAccount(String account);

	AccountDTO getAccountById(Long uin);

	AccountDTO getStoreAccount(String account);

	AccountDTO getGroupAccount(String account);


	/**
	 * 获取指定等级的账号
	 *
	 * @param account       账号
	 * @param accountLevels 账号等级列表
	 */
	AccountDTO getAccount(String account, List<String> accountLevels);

	/**
	 * 获取指定等级所属和当前级别的账号
	 *
	 * @param account       账号
	 * @param accountLevels 账号等级列表
	 * @param levelCode     等级编码
	 * @return
	 */
	AccountDTO getAccount(String account, List<String> accountLevels, String levelCode);

	List<AccountDTO> getAccountByGroup(String groupCode);

	List<AccountDTO> getAccountByStore(String storeCode);

	Boolean existGroupAccount(String groupCode);


	void modifyAccount(ModifyAccountDTO dto);


	void changePassword(ChangePasswordDTO dto);

	/**
	 * god集团账户列表修改密码
	 */
	void changeSelfPassword(ChangeSelfPasswordDTO dto);

	void changeGroupAdminAccessIds(String groupCode, String accessIds);

	void changeStoreAdminAccessIds(String storeCode, String accessIds);

	void delete(String account);

	Boolean existsByAccessIds(String accessIds);

	PageBean<AccountSimpleDTO> query(QueryAccountDTO dto);

	void loginCheck(String account, String pwd);

}
