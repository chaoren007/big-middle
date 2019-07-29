package com.morning.star.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.facade.UnitsFacade;
import com.morning.star.retail.facade.dto.UnitsDeleteDTO;
import com.morning.star.retail.facade.dto.UnitsQueryDTO;

import io.swagger.annotations.ApiOperation;

/**
 * @author ethan
 */
@RestController
@RequestMapping("/units-api/v1")
public class UnitsController {

	@Autowired
	private UnitsFacade unitsFacade;

	@ApiOperation(value = "分页查询单位")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object pageList(UnitsQueryDTO dto) {

		return unitsFacade.queryPage(dto);
	}
	@ApiOperation(value = "删除单位")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUnits(@RequestBody UnitsDeleteDTO dto) {
		unitsFacade.delete(dto.getId());
	}

}
