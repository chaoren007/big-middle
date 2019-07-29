package com.morning.star.retail.admin.group.address.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.AddressCodeDTO;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.dto.store.CityDTO;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.StoreFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址管理
 */
@Api(tags = "省市区接口")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController extends AdminController {

	@Autowired
	private AddressFacade addressFacade;
	@Autowired
	private StoreFacade storeFacade;

	@ApiOperation(value = "ALL")
	@RequestMapping(value = "/all/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listAll() {
		return WebBean.ok(addressFacade.getAll());
	}

	@ApiOperation(value = "省份列表")
	@RequestMapping(value = "/province/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listProvince() {
		return WebBean.ok(addressFacade.getAllProvence());
	}

	@ApiOperation(value = "城市列表")
	@RequestMapping(value = "/city/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listCity(@RequestParam(required = true) Long provinceId) {
		return WebBean.ok(addressFacade.getCityByProvenceId(provinceId));
	}

	@ApiOperation(value = "城市地址列表-已设置编码")
	@RequestMapping(value = "listCityWithCode", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listCityWithCode(@RequestParam(required = true) Long provinceId) {
		return WebBean.ok(addressFacade.getCityByProvenceIdWithCode(provinceId));
	}

	@ApiOperation(value = "常驻城市列表-总部")
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CityDTO>> cities() {
		List<CityDTO> list = new ArrayList<>();
		CityDTO cityDTO = new CityDTO();
		cityDTO.setCityId(RetailDefaultConst.DEFAULT_CITY_ID);
		cityDTO.setCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
		list.add(cityDTO);
		return WebBean.ok(list);
	}

	@ApiOperation(value = "常驻城市列表-所有")
	@RequestMapping(value = "/cities/all", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CityDTO>> citiesAll() {
		AdminLoginContent login = getLoginAdmin();
		return WebBean.ok(storeFacade.queryCity(login.getGroupCode()));
	}

	@ApiOperation(value = "区域列表")
	@RequestMapping(value = "/district/list", method = RequestMethod.GET)
	public WebBean<List<AddressDTO>> listDistrict(@RequestParam(required = true) Long cityId) {
		return WebBean.ok(addressFacade.getDistrictByCityId(cityId));
	}

	@ApiOperation(value = "更新地址编码")
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public WebBean code(@RequestBody AddressCodeDTO dto) {
		addressFacade.code(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "获取大区地址列表")
	@RequestMapping(value = "listCityWithRegion", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<AddressDTO>> listDistrict(String regionCode) {
		return WebBean.ok(addressFacade.getCityByRegion(regionCode));
	}
}
