package com.morning.star.retail.admin.group.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.SubmitSystem;
import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goods-supply/")
@Api(tags = "商品供应操作")
public class GoodsSupplyController extends AdminController {
	@Autowired
	private GoodsSupplyFacade goodsSupplyFacade;

	@ApiOperation(value = "供应商品查询，多规格")
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@Validate
	public WebBean<PageBean<GoodsSupplySimpleDTO>> page(GoodsSupplyQueryDTO dto) {
		return WebBean.ok(goodsSupplyFacade.pageBySpu(dto));
	}

	@ApiOperation(value = "供应商品详情(多规格数据)")
	@RequestMapping(value = "detail/supply-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailSpu(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getDetailBySupplyCode(dto.getGoodsSupplyCode()));
	}

	@ApiOperation(value = "供应商品详情（单品数据）")
	@RequestMapping(value = "detail/product-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailProduct(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getDetailByProductCode(dto.getProductCode()));
	}

	@ApiOperation(value = "审核成功(上架)")
	@RequestMapping(value = "audit-success", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> auditSuccess(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setAuditPermission(1);
		dto.setSubmitSystem(SubmitSystem.GROUP);
		goodsSupplyFacade.auditSuccess(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "审核失败（驳回）")
	@RequestMapping(value = "audit-fail", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> auditFail(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setAuditPermission(1);
		dto.setSubmitSystem(SubmitSystem.GROUP);
		goodsSupplyFacade.auditFail(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "上架")
	@RequestMapping(value = "on-sale", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> onSale(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setAuditPermission(1);
		dto.setSubmitSystem(SubmitSystem.GROUP);
		goodsSupplyFacade.onSale(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "下架")
	@RequestMapping(value = "off-sale", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> offSale(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setAuditPermission(1);
		dto.setSubmitSystem(SubmitSystem.GROUP);
		goodsSupplyFacade.offSale(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "获取操作日志")
	@RequestMapping(value = "log-list", method = RequestMethod.GET)
	@Validate
	public WebBean<List<GoodsSupplyLogDTO>> logList(GoodsSupplyQueryDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getOperateLog(dto));
	}
}
