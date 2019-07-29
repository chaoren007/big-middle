package com.morning.star.retail.admin.group.goods.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.group.helper.GoodsPriceService;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.GoodsPriceDO;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.bo.GoodsPriceBO;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.util.MultipartFileWrapper;

/**
 * 货品定价
 *
 * @author jiangyf
 * @date 2017年6月1日 上午9:45:06
 */
@Controller
@RequestMapping("/api/group/goodsprice/")
public class GroupGoodsPriceController extends AdminController {

	@Autowired
	private GoodsPriceService goodsPriceRemoteService;

	@RequestMapping(value = "getGoodsInfo")
	@ResponseBody
	
	public WebJsonBean getGoodsInfo(String goodsCode) {
		if (StringUtils.isBlank(goodsCode)) {
			paramsError("商品编码");
		}
		return success(goodsPriceRemoteService.getGoodsInfo(GoodsPriceBO.from(goodsCode, getLoginAdmin())));
	}

	@RequestMapping(value = "getPriceInfo")
	@ResponseBody
	
	public WebJsonBean getPriceInfo(String goodsCode) {
		if (StringUtils.isBlank(goodsCode)) {
			paramsError("商品编码");
		}
		return success(goodsPriceRemoteService.getGoodsPriceInfo(GoodsPriceBO.from(goodsCode, getLoginAdmin())));
	}

	@RequestMapping(value = "modifyGoodsPrice")
	@ResponseBody
	
	public WebJsonBean modifyGoodsPrice(String goodsCode, BigDecimal salePrice) {
		if (StringUtils.isBlank(goodsCode) || salePrice == null) {
			paramsError();
		}
		GoodsPriceDO goodsPriceDO = GoodsPriceDO.from(goodsCode, salePrice, getLoginAdmin());
		return success(goodsPriceRemoteService.modifyGoodsPrice(goodsPriceDO));
	}

	@RequestMapping(value = "pageListGoodsPrice")
	@ResponseBody
	
	public WebJsonBean pageListGoodsPrice(String goodsCode, String goodsName, String upcCode, Integer status,
										  Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize;
		GoodsPriceBO goodsPriceBO = GoodsPriceBO.from(goodsCode, goodsName, upcCode, status, pageNo, pageSize, getLoginAdmin());
		return success(goodsPriceRemoteService.pageListGoodsPrice(goodsPriceBO));
	}

	/**
	 * 导入库存
	 *
	 * @param importFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "importGoodsPrice")
	@ResponseBody
	
	public WebJsonBean importGoodsPrice(@RequestParam MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		try {
			goodsPriceRemoteService.importGoodsPrice(MultipartFileWrapper.of(importFile), login);
		} catch (IOException e) {
			paramsError();
		}
		return success();
	}

}
