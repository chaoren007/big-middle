package com.morning.star.retail.admin.application;


import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import net.sf.jsqlparser.statement.select.First;

/**
 * 账号
 *
 * @author wumengzhen
 */
public interface SupplierAccountApplication {

	void addAccount(AccountSupplierAddDTO dto);

	void modifyAccount(FirstModifyAccountDTO dto);

	void changePassword(ChangePasswordDTO modifyGodAccountDTO);

	void changeSelfPassword(ChangeSelfPasswordDTO dto);

	void addLoginCount(String account, AccountLevelEnum levelEnum);

}
