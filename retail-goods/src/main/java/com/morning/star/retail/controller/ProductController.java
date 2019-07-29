package com.morning.star.retail.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.morning.star.retail.facade.dto.ProductGetUpcDTO;
import com.morning.star.retail.listener.event.ProductAddEvent;
import com.morning.star.retail.listener.mq.ImportProductQueue;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Context;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.ProductGetDTO;
import com.morning.star.retail.facade.dto.ProductQueryDTO;
import com.morning.star.retail.facade.dto.ProductSubmitDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Dell
 * @createTime 2018/7/12 15:01
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductFacade productFacade;

	@Autowired
	private ImportProductQueue importProductQueue;

	@ApiOperation(value = "添加集团商品")
	@RequestMapping(value = "/test/event", method = RequestMethod.GET)
	@ResponseBody
	public void testEvent() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("test");
		UserUtils.setCurrentUser(userInfo);
		Context.publish(new ProductAddEvent(new ArrayList<>()));
		importProductQueue.send(new ArrayList<>());
	}

	@ApiOperation(value = "添加集团商品")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ResponseBody
	public Object addProduct(@RequestBody List<ProductSubmitDTO> dtos) {
		Validate.isTrue(dtos != null && dtos.size() > 0, "无商品数据");
		productFacade.addProduct(dtos);
		return null;
	}

	@ApiOperation(value = "通过商品code获取详情")
	@RequestMapping(value = "/products/{productCode}", method = RequestMethod.GET)
	@ResponseBody
	public Object getDetail(@PathVariable @ApiParam(value = "货品编码") String productCode) {
		ProductGetDTO dto = new ProductGetDTO();
		dto.setProductCode(productCode);
		return productFacade.getDetail(dto);
	}

	@ApiOperation(value = "通过商品upc获取详情")
	@RequestMapping(value = "/products/{groupCode}/{upcCode}", method = RequestMethod.GET)
	@ResponseBody
	public Object getProductByUpc(@PathVariable String groupCode,
	                            @PathVariable String upcCode) {
		ProductGetUpcDTO productGetDTO = new ProductGetUpcDTO();
		productGetDTO.setGroupCode(groupCode);
		productGetDTO.setProductUpc(upcCode);
		return productFacade.getByUpc(productGetDTO);
	}

	@ApiOperation(value = "查询集团商品信息")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public Object pageList(@ApiParam(required = true, value = "查询条件") ProductQueryDTO dto) {
		return productFacade.queryProduct(dto);
	}

	@ApiOperation(value = "商品上市")
	@RequestMapping(value = "/products/{productCode}/on-market", method = RequestMethod.POST)
	@ResponseBody
	public void onMarket(@PathVariable String productCode) {
		productFacade.onMarket(Collections.singletonList(productCode));
	}

	@ApiOperation(value = "商品下市")
	@RequestMapping(value = "/products/{productCode}/off-market", method = RequestMethod.POST)
	@ResponseBody
	public void offMarket(@PathVariable String productCode) {
		productFacade.offMarket(Arrays.asList(productCode));
	}
}
