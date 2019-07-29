package com.morning.star.retail.controller;

import com.morning.star.retail.facade.KingdeeAddGoodsFacade;
import com.morning.star.retail.utils.WebBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * wms服务接口
 *
 * @author kimhuhg
 */
@Api(tags = "运营端接口")
@RestController
@RequestMapping("/Kingdee-api/v1")
public class KingdeeController {
	private static Logger log = LoggerFactory.getLogger(KingdeeController.class);

	@Autowired
	private KingdeeAddGoodsFacade kingdeeAddGoodsFacade;

	@ApiOperation(value = "推送物料信息到kingdee")
	@RequestMapping(value = "/pull", method = RequestMethod.POST)
	public WebBean getOrder(@RequestBody String code) {
		log.info("推送金蝶云物料信息:" + code);
		kingdeeAddGoodsFacade.add(code);
		return WebBean.ok();
	}
}
