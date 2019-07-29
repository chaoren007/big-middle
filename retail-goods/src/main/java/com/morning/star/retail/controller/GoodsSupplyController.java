package com.morning.star.retail.controller;

import com.morning.star.retail.application.GoodsSupplyApplication;
import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyAuditDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyGetDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyQueryDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySubmitDTO;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods-supply/")
@Api(tags = "商品供应操作")
public class GoodsSupplyController {
	@Autowired
	private GoodsSupplyFacade goodsSupplyFacade;
	@Autowired
	private GoodsSupplyApplication goodsSupplyApplication;

	@ApiOperation(value = "供应商品提交")
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	@Validate
	public Object submit(@RequestBody GoodsSupplySubmitDTO dto) {
		goodsSupplyFacade.submit(dto);
		return null;
	}

	@ApiOperation(value = "供应商品查询")
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@Validate
	public Object page(GoodsSupplyQueryDTO dto) {
		return goodsSupplyFacade.pageBySpu(dto);
	}

	@ApiOperation(value = "供应商品详情(多规格数据)")
	@RequestMapping(value = "detail/supply-code", method = RequestMethod.GET)
	@Validate
	public Object detailSpu(GoodsSupplyGetDTO dto) {
		return goodsSupplyFacade.getDetailBySupplyCode(dto.getGoodsSupplyCode());
	}

	@ApiOperation(value = "供应商品详情（单品数据）")
	@RequestMapping(value = "detail/product-code", method = RequestMethod.GET)
	@Validate
	public Object detailProduct(GoodsSupplyGetDTO dto) {
		return goodsSupplyFacade.getDetailByProductCode(dto.getProductCode());
	}

	@ApiOperation(value = "审核成功")
	@RequestMapping(value = "audit-success", method = RequestMethod.POST)
	@Validate
	public Object auditSuccess(@RequestBody GoodsSupplyAuditDTO dto) {
		goodsSupplyFacade.auditSuccess(dto);
		return null;
	}

	@ApiOperation(value = "审核失败")
	@RequestMapping(value = "audit-fail", method = RequestMethod.POST)
	@Validate
	public Object auditFail(@RequestBody GoodsSupplyAuditDTO dto) {
		goodsSupplyFacade.auditSuccess(dto);
		return null;
	}
}
