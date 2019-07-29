package com.morning.star.retail.admin.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.UnitsFacade;
import com.morning.star.retail.facade.dto.UnitsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = { "门店单位" })
@Controller
@RequestMapping("/api/units/")
public class UnitsController extends AdminController {

	@Autowired
	private UnitsFacade unitsFacade;

/*	@ApiOperation(value = "分页查询单位")
	@RequestMapping(value="page",method = RequestMethod.GET)
	@ResponseBody
	public WebBean<PageBean<UnitsDTO>> pagePage(UnitsQueryDTO dto) {
		
		return WebBean.ok(unitsFacade.queryPage(dto));
	}*/
	
	@ApiOperation(value = "列表查询单位")
	@RequestMapping(value="listAll",method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<UnitsDTO>> pageList() {
		
		return WebBean.ok(unitsFacade.queryList());
	}
}
