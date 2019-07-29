package com.morning.star.retail.admin.group.warehouse.controller;


import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;
import com.morning.star.retail.facade.WarehouseFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2017/11/3.
 */
@Api(tags = "总部你我您仓库管理")
@RestController
@RequestMapping("/api/group/warehouse")
public class WarehouseController extends AdminController {

	@Autowired
	private WarehouseFacade warehouseFacade;

	@ApiOperation(value = "新增仓库")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WebBean<Void> create(@RequestBody WarehouseDTO dto) {
		Validate.notNull(dto.getWarehouseName(),"仓库名称不能为空");
		Validate.notNull(dto.getWarehouseAddress(),"仓库地址不能为空");
		Validate.notNull(dto.getCityId(),"城市ID不能为空");
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		warehouseFacade.create(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public WebBean<PageBeans<WarehouseDTO>> page(WarehouseQueryDTO dto) {
		Validate.notNull(dto.getPageNo(),"分页参数不能为空");
		Validate.notNull(dto.getPageSize(),"分页参数不能为空");
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		PageBeans<WarehouseDTO> result = warehouseFacade.queryPage(dto);
		return  WebBean.ok(result);
	}

	@ApiOperation(value = "列表查询、详情查询")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public WebBean<List<WarehouseDTO>> list(WarehouseQueryDTO dto) {
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		return  WebBean.ok(warehouseFacade.queryList(dto));
	}

	@ApiOperation(value = "编辑-仓库ID必传")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> edit(@RequestBody WarehouseDTO dto) {
		Validate.notNull(dto.getWarehouseName(),"仓库名称不能为空");
		Validate.notNull(dto.getWarehouseAddress(),"仓库地址不能为空");
		Validate.notNull(dto.getCityId(),"城市ID不能为空");
		Validate.notNull(dto.getWarehouseCode(),"仓库ID不能为空");
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		warehouseFacade.edit(dto);
		return  WebBean.ok();
	}

	@ApiOperation(value = "删除-仓库ID必传")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebBean<Void> delete(@RequestBody WarehouseQueryDTO command) {

		command.setStoreCode(getLoginAdmin().getStoreCode());
		command.setGroupCode(getLoginAdmin().getGroupCode());
		Validate.notNull(command.getWarehouseCode(),"仓库编码不能为空");
		warehouseFacade.delete(command);
		return  WebBean.ok();
	}

	@ApiOperation(value = "获取有仓库的城市列表")
	@RequestMapping(value = "/list-city", method = RequestMethod.GET)
	public WebBean<List<WarehouseDTO>> listCity() {
		 return WebBean.ok(warehouseFacade.listcity(getLoginAdmin().getGroupCode()));
	}

	@ApiOperation(value = "获取城市的仓库列表 集团端传入参数:城市名称")
	@RequestMapping(value = "/list-warehouse", method = RequestMethod.GET)
	public WebBean<List<WarehouseDTO>> listWarehouse(WarehouseQueryDTO dto) {
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		Validate.notNull(dto.getCityId(),"城市ID不能为空!");
		return WebBean.ok(warehouseFacade.listWarehouse(dto));
	}



}
