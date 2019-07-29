package com.morning.star.retail.controller;

import com.morning.star.retail.facade.ConsumableFacade;
import com.morning.star.retail.facade.dto.ConsumableAddDTO;
import com.morning.star.retail.facade.dto.ConsumableImportDTO;
import com.morning.star.retail.facade.dto.ConsumableQueryDTO;
import com.morning.star.retail.facade.dto.ConsumableUseReturnDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ethan
 * @createTime 2018/7/12 15:01
 */
@RestController
@RequestMapping("/consumable-api/v1")
public class ConsumableController {

	@Autowired
	private ConsumableFacade facade;

	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public Object query(ConsumableQueryDTO dto) {
		return facade.query(dto);
	}

	@ApiOperation(value = "添加")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void add(@RequestBody List<ConsumableAddDTO> dtos) {
		facade.addConsumable(dtos);
	}

	@ApiOperation(value = "导入")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	@ResponseBody
	public void importConsumable(@RequestBody List<ConsumableImportDTO> dtos) {
		facade.importConsumable(dtos);
	}

	@ApiOperation(value = "使用")
	@RequestMapping(value = "/use", method = RequestMethod.POST)
	@ResponseBody
	public void use(@RequestBody ConsumableUseReturnDTO dto) {
		facade.useConsumable(dto);
	}

	@ApiOperation(value = "归还")
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	@ResponseBody
	public void back(@RequestBody ConsumableUseReturnDTO dto) {
		facade.backConsumable(dto);
	}

}
