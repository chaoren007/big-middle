package com.morning.star.retail.admin.facade;

import com.morning.star.retail.admin.bo.LoginBO;
import com.morning.star.retail.admin.dto.*;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 登录账户
 *
 * @author jiangyf
 */
public interface StoreAccountFacade {

	/**
	 * pos登录
	 */
	AdminLoginContent loginPos(LoginBO loginBO);

    AccountDTO getAdmin(String storeCode);

}
