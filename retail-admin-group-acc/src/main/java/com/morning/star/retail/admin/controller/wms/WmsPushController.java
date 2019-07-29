package com.morning.star.retail.admin.controller.wms;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.BaseModelWmsFacade;
import com.morning.star.retail.facade.GoodsModelWmsFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "wms推送基础信息")
@RestController
@RequestMapping("/api/wms/push")
public class WmsPushController extends AdminController {

	@Autowired
	private GoodsModelWmsFacade goodsModelWmsFacade;
	@Autowired
	private BaseModelWmsFacade baseModelWmsFacade;

	@ApiOperation(value = "商品数据")
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public WebBean goods(@RequestParam("storeCode") String storeCode, @RequestParam("productCode") String productCode) {
		goodsModelWmsFacade.pushGoodsByProduct(storeCode, productCode);
		return WebBean.ok();
	}

	@ApiOperation(value = "分类")
	@RequestMapping(value = "/category/{code}", method = RequestMethod.POST)
	public WebBean category(@PathVariable("code") String code) {
		goodsModelWmsFacade.pushCategory(Long.parseLong(code));
		return WebBean.ok();
	}

	@ApiOperation(value = "门店")
	@RequestMapping(value = "/store/{code}", method = RequestMethod.POST)
	public WebBean store(@PathVariable("code") String code) {
		baseModelWmsFacade.pushStore(code);
		return WebBean.ok();
	}

	@ApiOperation(value = "供应商")
	@RequestMapping(value = "/supplier/{code}", method = RequestMethod.POST)
	public WebBean supplier(@PathVariable("code") String code) {
		baseModelWmsFacade.pushSupplier(code);
		return WebBean.ok();
	}

	@ApiOperation(value = "仓库")
	@RequestMapping(value = "/warehouse/{code}", method = RequestMethod.POST)
	public WebBean warehouse(@PathVariable("code") String code) {
		baseModelWmsFacade.pushWarehouse(code);
		return WebBean.ok();
	}
}
