package com.morning.star.retail.controller;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.controller.command.GoodsSupplyBusAuditCommand;
import com.morning.star.retail.controller.command.GoodsSupplyQueryCommand;
import com.morning.star.retail.facade.SubmitSystem;
import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.helper.BusOrderHelper;
import com.morning.star.retail.helper.GoodsSupplyHelper;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.utils.WebBean;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * wms服务接口
 *
 * @author kimhuhg
 */
@Api(tags = "运营端接口")
@RestController
@RequestMapping("/bus-api/v1")
public class BusController {
	private static Logger log = LoggerFactory.getLogger(BusController.class);

	@Autowired
	private BusOrderHelper busOrderHelper;
	@Autowired
	private GoodsSupplyHelper goodsSupplyHelper;

	@ApiOperation(value = "接收运营端的订单信息")
	@RequestMapping(value = "/pull", method = RequestMethod.POST)
	public WebBean getOrder(@RequestBody BusOrderDTO dto) {
		log.info("运营端推送的订单数据:" + JSON.toJSONString(dto));
		busOrderHelper.add(dto);
		return WebBean.ok();
	}


	@ApiOperation(value = "查询商品")
	@RequestMapping(value = "/goods/page", method = RequestMethod.POST)
	public WebBean<PageBean<GoodsSupplyBusDTO>> goodsPage(@RequestBody GoodsSupplyQueryCommand command) {
		log.info("运营端查询商品:" + JSON.toJSONString(command));
		GoodsSupplyQueryDTO dto = new GoodsSupplyQueryDTO();
		BeanUtils.copy(command, dto);

		Set<Integer> status = new HashSet<>();
		status.add(20);//上架状态商品

		dto.setSupplyStatus(status);
		return WebBean.ok(goodsSupplyHelper.page(dto));
	}

	@ApiOperation(value = "供应商品详情(多规格数据)")
	@RequestMapping(value = "/goods/detail/supply-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailSpu(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyHelper.getDetailBySupplyCode(dto.getGoodsSupplyCode()));
	}

	@ApiOperation(value = "供应商品详情（单品数据）")
	@RequestMapping(value = "/goods/detail/product-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailProduct(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyHelper.getDetailByProductCode(dto.getProductCode()));
	}

	@ApiOperation(value = "供应商品详情")
	@RequestMapping(value = "/goods/detail", method = RequestMethod.GET)
	public WebBean<GoodsSupplyDTO> detail(String code) {
		GoodsSupplyDTO detail = goodsSupplyHelper.getDetailByProductCode(code);
		return WebBean.ok(goodsSupplyHelper.getDetailBySupplyCode(detail.getGoodsSupplyCode()));
	}

	@ApiOperation(value = "商品开团")
	@RequestMapping(value = "/goods/open-group", method = RequestMethod.POST)
	public WebBean openGroup(@RequestBody GoodsSupplyAuditGroupDTO command) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(0L);
		userInfo.setName("运营端");
		UserUtils.setCurrentUser(userInfo);
		command.setSubmitSystem(SubmitSystem.BUS);
		goodsSupplyHelper.busAuditOpenGroup(command);
		return WebBean.ok();
	}

	@ApiOperation(value = "商品开团结束")
	@RequestMapping(value = "/goods/close-group", method = RequestMethod.POST)
	public WebBean openGroupEnd(@RequestBody GoodsSupplyAuditGroupDTO command) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(0L);
		userInfo.setName("运营端");
		UserUtils.setCurrentUser(userInfo);

		command.setSubmitSystem(SubmitSystem.BUS);

		goodsSupplyHelper.busAuditOpenGroupEnd(command);
		return WebBean.ok();
	}
}
