package com.morning.star.retail.admin.god.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.facade.AddressFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 地址管理
 * 
 */
@Api(tags = "省市区接口")
@RestController
@RequestMapping("/api/v1")
public class AddressController extends AdminController {
	@Autowired private AddressFacade addressFacade;

	@ApiOperation(value = "省份列表")
	@RequestMapping(value = "/address/province/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listProvince() {
		return WebBean.ok(addressFacade.getAllProvence());
	}

	@ApiOperation(value = "城市列表")
	@RequestMapping(value = "/address/city/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listCity(@RequestParam(required = true) Long provinceId) {
		return WebBean.ok(addressFacade.getCityByProvenceId(provinceId));
	}

	@ApiOperation(value = "区域列表")
	@RequestMapping(value = "/address/district/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listDistrict(@RequestParam(required = true) Long cityId) {
		return WebBean.ok(addressFacade.getDistrictByCityId(cityId));
	}
}
