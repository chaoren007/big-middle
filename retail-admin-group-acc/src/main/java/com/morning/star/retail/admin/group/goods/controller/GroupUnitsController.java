package com.morning.star.retail.admin.group.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.UnitsFacade;
import com.morning.star.retail.facade.dto.UnitsAddDTO;
import com.morning.star.retail.facade.dto.UnitsDTO;
import com.morning.star.retail.facade.dto.UnitsDeleteDTO;
import com.morning.star.retail.facade.dto.UnitsQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = {"集团单位"})
@Controller
@RequestMapping("/api/units")
public class GroupUnitsController extends AdminController {

	@Autowired
	private UnitsFacade unitsFacade;

	@ApiOperation(value = "添加单位")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	@Validate
	public WebBean<Void> addUnits(@RequestBody UnitsAddDTO dto) {
		unitsFacade.create(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "分页查询单位")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public WebBean<PageBean<UnitsDTO>> pageList(UnitsQueryDTO dto) {

		return WebBean.ok(unitsFacade.queryPage(dto));
	}

	@ApiOperation(value = "删除单位")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	@Validate
	public WebBean<Void> deleteUnits(@RequestBody UnitsDeleteDTO dto) {
		unitsFacade.delete(dto.getId());
		return WebBean.ok();
	}

	@ApiOperation(value = "列表查询单位")
	@RequestMapping(value="listAll",method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<UnitsDTO>> pageList() {

		return WebBean.ok(unitsFacade.queryList());
	}
}
