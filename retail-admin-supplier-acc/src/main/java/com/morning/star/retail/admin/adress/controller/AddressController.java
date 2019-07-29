package com.morning.star.retail.admin.adress.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.CityDTO;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.GroupFacade;
import com.morning.star.retail.facade.StoreFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * 地址管理
 */
@Api(tags = {"获取地址"})
@Controller
@RequestMapping("/api/address/")
public class AddressController extends AdminController {
	@Autowired
	private AddressFacade addressFacade;
	@Autowired
	private StoreFacade storeFacade;
	@Autowired
	private GroupFacade groupFacade;

	@ApiOperation(value = "ALL")
	@RequestMapping(value = "/all/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listAll() {
		return WebBean.ok(addressFacade.getAll());
	}

	@ApiOperation(value = "获取省份地址列表")
	@RequestMapping(value = "listProvince", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listProvince() {
		return WebBean.ok(addressFacade.getAllProvence());
	}

	@ApiOperation(value = "获取城市地址列表")
	@RequestMapping(value = "listCity", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listCity(@RequestParam(required = true) Long provinceId) {
		return WebBean.ok(addressFacade.getCityByProvenceId(provinceId));
	}

	@ApiOperation(value = "获取全部城市地址列表")
	@RequestMapping(value = "listAllCity", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listAllCity() {
		return WebBean.ok(addressFacade.getAllDetail());
	}


	@ApiOperation(value = "城市地址列表-已设置编码")
	@RequestMapping(value = "listCityWithCode", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listCityWithCode(@RequestParam(required = true) Long provinceId) {
		return WebBean.ok(addressFacade.getCityByProvenceIdWithCode(provinceId));
	}

	@ApiOperation(value = "获取地区地址列表")
	@RequestMapping(value = "listDistrict", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listDistrict(@RequestParam(required = true, value = "城市id") Long cityId) {
		return WebBean.ok(addressFacade.getDistrictByCityId(cityId));
	}

	@ApiOperation(value = "常驻城市列表")
	@RequestMapping(value = "cities", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CityDTO>> cities() {
		GroupInfoDTO groupInfoDTO = groupFacade.getDefault();
		if (groupInfoDTO != null) {
			return WebBean.ok(storeFacade.queryCity(groupInfoDTO.getGroupCode()));
		} else {
			return WebBean.ok(Collections.emptyList());
		}
	}

	@ApiOperation(value = "获取大区地址列表")
	@RequestMapping(value = "listCityWithRegion", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listDistrict(String regionCode) {
		return WebBean.ok(addressFacade.getCityByRegion(regionCode));
	}
}
