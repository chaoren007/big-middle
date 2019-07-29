package com.morning.star.retail.export.controller;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.UserInfoDTO;
import com.morning.star.retail.export.facade.ExportCommonFacade;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/10/25.
 */
@Controller
@RequestMapping("/api/v2/")
public class ExportController {
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
	public void getPurchaseByCode() {
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
//		return success();

	}
}
