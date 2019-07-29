package com.morning.star.retail.controller;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.facade.BusTransferFacade;
import com.morning.star.retail.facade.dto.BusGoodsDTO;
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
@Api(tags = "运营端接口Test")
@RestController
@RequestMapping("/bus-api/test/v1")
public class BusTestController {
	private static Logger log = LoggerFactory.getLogger(BusTestController.class);

	@Autowired
	private BusTransferFacade busTransferFacade;

	@ApiOperation(value = "推送商品")
	@RequestMapping(value = "/pull-goods", method = RequestMethod.POST)
	public WebBean getOrder(@RequestBody BusGoodsDTO dto) {
		log.info("推送商品数据:" + JSON.toJSONString(dto));
		busTransferFacade.addGoods(dto);
		return WebBean.ok();
	}
}
