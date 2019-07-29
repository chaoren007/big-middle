package com.morning.star.retail.admin.group.consumable.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.group.consumable.controller.vo.ConsumableImportVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.facade.ConsumableFacade;
import com.morning.star.retail.facade.dto.ConsumableAddDTO;
import com.morning.star.retail.facade.dto.ConsumableDTO;
import com.morning.star.retail.facade.dto.ConsumableQueryDTO;
import com.morning.star.retail.facade.dto.ConsumableUseReturnDTO;
import com.morning.star.retail.facade.dto.ConsumableWaterDTO;
import com.morning.star.retail.facade.dto.ConsumableWaterQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author ethan
 */
@Api(tags = {"耗材管理"})
@RestController
@RequestMapping("/api/group/consumable")
public class ConsumableController extends AdminController {

	@Autowired
	private ConsumableFacade consumableFacade;

	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@RequiresPermissions(value = {"consumable:list"})
	public WebBean<PageBean<ConsumableDTO>> query(ConsumableQueryDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());

		return WebBean.ok(consumableFacade.query(dto));
	}

	@ApiOperation(value = "添加")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = {"consumable:add"})
	public WebBean<Void> add(@RequestBody ConsumableAddDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());

		consumableFacade.addConsumable(Collections.singletonList(dto));
		return WebBean.ok();
	}

	@ApiOperation(value = "导入耗材数量")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	@RequiresPermissions(value = {"consumable:import"})
	public WebBean<Void> importConsumable(MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		List<ConsumableImportVO> importVOS = new ExcelUtil<>(ConsumableImportVO.class).readXLSData(importFile, OriginalType.XLSX);

		List<ConsumableAddDTO> consumableAddDTOS = importVOS.stream().map(e -> {
			ConsumableAddDTO consumableAddDTO = new ConsumableAddDTO();
			BeanUtils.copyProperties(e, consumableAddDTO);
			consumableAddDTO.setGroupCode(login.getGroupCode());
			consumableAddDTO.setStoreCode(login.getStoreCode());
			return consumableAddDTO;
		}).collect(Collectors.toList());

		consumableFacade.addConsumable(consumableAddDTOS);
		return WebBean.ok();
	}

	@ApiOperation(value = "使用")
	@RequiresPermissions(value = {"consumable:use"})
	@RequestMapping(value = "/use", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> use(@RequestBody ConsumableUseReturnDTO dto) {
		consumableFacade.useConsumable(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "归还")
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = {"consumable:back"})
	public WebBean<Void> back(@RequestBody ConsumableUseReturnDTO dto) {
		consumableFacade.backConsumable(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "分页查询耗材记录")
	@RequestMapping(value = "/query/log", method = RequestMethod.GET)
	@RequiresPermissions(value = {"consumable:list"})
	public WebBean<PageBean<ConsumableWaterDTO>> queryLog(ConsumableWaterQueryDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());

		return WebBean.ok(consumableFacade.getLog(dto));
	}

}
