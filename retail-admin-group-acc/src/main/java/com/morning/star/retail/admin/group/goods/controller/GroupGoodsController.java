package com.morning.star.retail.admin.group.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.GoodsQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "商品")
public class GroupGoodsController extends AdminController {
	@Autowired
	private GoodsAdminFacade storeGoodsFacade;

	@ApiOperation(value = "查询商品")
	@RequestMapping(value = "/goods/query", method = RequestMethod.GET)
	public WebBean<PageBean<GoodsDTO>> page(GoodsQueryDTO goodsQueryDTO) {
		goodsQueryDTO.setGroupCode(getLoginAdmin().getGroupCode());

		return WebBean.ok(storeGoodsFacade.queryGoods(goodsQueryDTO));
	}

	@ApiOperation(value = "获取商品详情")
	@RequestMapping(value = "/goods/get-detail-code", method = RequestMethod.GET)
	public WebBean<GoodsDTO> detail(@RequestParam @ApiParam(value = "商品编码") String goodsCode) {
		GoodsDTO dto = storeGoodsFacade.getGoods(goodsCode);
		return WebBean.ok(dto);
	}

}
