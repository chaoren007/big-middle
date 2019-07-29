package com.morning.star.retail.admin.application;


import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.enums.AccountLevelEnum;

/**
 * 账号
 *
 * @author wumengzhen
 */
public interface AccountApplication {

	/**
	 * 新增账号
	 */
	void addGroupAccount(AccountGroupAddDTO dto);

	void addStoreAccount(AccountStoreAddDTO dto);

	void modifyAccount(ModifyAccountDTO dto);

	void changePassword(ChangePasswordDTO modifyGodAccountDTO);


	void delete(String account);


	void changeSelfPassword(ChangeSelfPasswordDTO dto);


	void deleteByGroupCode(String groupCode);


	void changeGroupAdminAccessIds(String groupCode, String accessIds);

	void changeStoreAdminAccessIds(String storeCode, String accessIds);

	void updateLoginCount(String account);

}
