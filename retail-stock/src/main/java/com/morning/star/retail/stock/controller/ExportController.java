package com.morning.star.retail.stock.controller;

import com.google.gson.Gson;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.UserInfoDTO;
import com.morning.star.retail.export.facade.ExportCommonFacade;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.stock.enums.PurchaseStatusEnum;
import com.morning.star.retail.stock.helper.SupplierService;
import com.morning.star.retail.stock.helper.vo.SupplierInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2017/10/25.
 */
@Controller
@RequestMapping("/api/v1/")
public class ExportController extends BaseController {
	private static final Logger LOGGER = LoggerFactory
		.getLogger(ExportController.class);


	@Autowired
	ExportCommonFacade exportCommonFacade;

	public AdminLoginContent getLoginAdmin() {
		AdminLoginContent login = new AdminLoginContent();
		login.setId(0L);
		login.setName("watermelon");
		login.setGroupCode("JT00000005");
		login.setStoreCode("GS00000016");
		return login;
	}

	@ApiOperation(value = "获取采购单详情")
	@RequestMapping(value = "export/test", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean getPurchaseByCode() {
		AdminLoginContent login = getLoginAdmin();

		ExportMqDTO exportMqDTO = new ExportMqDTO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setGroupCode("haha");
		userInfoDTO.setStoreCode("test");
		userInfoDTO.setUserId(Long.valueOf(1));
		userInfoDTO.setUserName("测试");
		exportMqDTO.setUserCommand(userInfoDTO);
		exportMqDTO.setType("ReceiptExportBean");
		exportCommonFacade.export(exportMqDTO);
		return success();

	}
}
