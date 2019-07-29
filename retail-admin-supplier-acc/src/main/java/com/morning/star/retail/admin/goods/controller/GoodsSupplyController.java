package com.morning.star.retail.admin.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.SubmitSystem;
import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.facade.dto.supply.groups.SupplierAdminSubmit;
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

	@ApiOperation(value = "供应商品提交草稿")
	@RequestMapping(value = "draft", method = RequestMethod.POST)
	@Validate(groups = SupplierAdminSubmit.class)
	public WebBean<Void> draft(@RequestBody GoodsSupplySubmitDTO dto) {
		AdminLoginContent admin = getLoginAdmin();
		dto.setSupplierCode(admin.getSupplierCode());
		dto.setSubmitSystem(SubmitSystem.SUPPLIER);
		goodsSupplyFacade.draft(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "供应商品提交审核")
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	@Validate(groups = SupplierAdminSubmit.class)
	public WebBean<Void> submit(@RequestBody GoodsSupplySubmitDTO dto) {
		AdminLoginContent admin = getLoginAdmin();
		dto.setSupplierCode(admin.getSupplierCode());
		dto.setSubmitSystem(SubmitSystem.SUPPLIER);
		goodsSupplyFacade.submit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "供应商品查询")
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@Validate
	public WebBean<PageBean<GoodsSupplySimpleDTO>> page(GoodsSupplyQueryDTO dto) {
		AdminLoginContent admin = getLoginAdmin();
		dto.setSupplierCode(admin.getSupplierCode());
		return WebBean.ok(goodsSupplyFacade.pageBySpu(dto));
	}

	@ApiOperation(value = "供应商品详情(多规格数据)")
	@RequestMapping(value = "detail/supply-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailSpu(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getDetailBySupplyCodeV2(dto.getGoodsSupplyCode()));
	}

	@ApiOperation(value = "供应商品详情（单品数据）")
	@RequestMapping(value = "detail/product-code", method = RequestMethod.GET)
	@Validate
	public WebBean<GoodsSupplyDTO> detailProduct(GoodsSupplyGetDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getDetailByProductCode(dto.getProductCode()));
	}

	@ApiOperation(value = "上架")
	@RequestMapping(value = "on-sale", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> onSale(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setSubmitSystem(SubmitSystem.SUPPLIER);
		goodsSupplyFacade.onSale(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "下架")
	@RequestMapping(value = "off-sale", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> offSale(@RequestBody GoodsSupplyAuditDTO dto) {
		dto.setSubmitSystem(SubmitSystem.SUPPLIER);
		goodsSupplyFacade.offSale(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "删除")
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> remove(@RequestBody GoodsSupplyDelDTO dto) {
		goodsSupplyFacade.remove(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "扣减库存")
	@RequestMapping(value = "sale-out-stock", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> saleOutStock(@RequestBody List<GoodsSupplyStockReduceDTO> dtoList) {
		goodsSupplyFacade.saleOutStock(dtoList);
		return WebBean.ok();
	}

	@ApiOperation(value = "获取操作日志")
	@RequestMapping(value = "log-list", method = RequestMethod.GET)
	@Validate
	public WebBean<List<GoodsSupplyLogDTO>> logList(GoodsSupplyQueryDTO dto) {
		return WebBean.ok(goodsSupplyFacade.getOperateLog(dto));
	}


}
