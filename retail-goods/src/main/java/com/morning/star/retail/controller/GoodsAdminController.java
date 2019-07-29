package com.morning.star.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.controller.command.PriceGoodsCommand;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.GoodsQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class GoodsAdminController {
	@Autowired
	private GoodsAdminFacade goodsFacade;

	@ApiOperation(value = "查询门店商品")
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public PageBean<GoodsDTO> queryStoreGoods(GoodsQueryDTO dto) {
		return goodsFacade.queryGoods(dto);
	}

	@ApiOperation(value = "获取门店商品")
	@RequestMapping(value = "/goods/{code}", method = RequestMethod.GET)
	public ResponseEntity<GoodsDTO> getStoreGoods(@PathVariable String code) {
		GoodsDTO dto = goodsFacade.getGoods(code);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto);
	}

	@ApiOperation(value = "门店商品定价")
	@RequestMapping(value = "/goods/{code}/price", method = RequestMethod.POST)
	public void makePrice(@PathVariable String code, @RequestBody PriceGoodsCommand command) {
		goodsFacade.makePrice(code, command.getPrice());
	}

	@ApiOperation(value = "上架门店商品")
	@RequestMapping(value = "/goods/{code}/on-sale", method = RequestMethod.POST)
	public void onSale(@PathVariable String code) {
		goodsFacade.onSale(code);
	}

	@ApiOperation(value = "下架门店商品")
	@RequestMapping(value = "/goods/{code}/off-sale", method = RequestMethod.POST)
	public void offSale(@PathVariable String code) {
		goodsFacade.offSale(code);
	}

}
