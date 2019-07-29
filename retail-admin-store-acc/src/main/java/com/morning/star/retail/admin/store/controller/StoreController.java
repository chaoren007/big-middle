package com.morning.star.retail.admin.store.controller;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.helper.StoreService;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.store.StoreDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 门店
 *
 */
@Api(tags = "门店接口")
@RestController
@RequestMapping("/api/v1")
public class StoreController extends AdminController {

	@Autowired
	private StoreService storeService;

	/**
	 * 查询门店详情
	 * @return
	 */
    @ApiOperation(value = "查询当前门店信息")
	@RequestMapping(value = "/store/me", method = RequestMethod.GET)
	public WebBean<StoreDTO> getStoreInfo() {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Validate.notNull(storeCode, "账号未绑定门店");
		return WebBean.ok(storeService.getStore(storeCode));
	}

}
