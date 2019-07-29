package com.morning.star.retail.admin.warehouse.controller;


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
@Api(tags = "分部你我您仓库管理")
@RestController
@RequestMapping("/api")
public class WarehouseController extends AdminController {
	@Autowired
	private WarehouseFacade warehouseFacade;

	@ApiOperation(value = "新增仓库")
	@RequestMapping(value = "/warehouse/create", method = RequestMethod.POST)
	public WebBean<Void> create(@RequestBody WarehouseDTO dto) {
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		Validate.notNull(dto.getWarehouseName(),"仓库名称不能为空");
		Validate.notNull(dto.getWarehouseAddress(),"仓库地址不能为空");
		warehouseFacade.create(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/warehouse/page", method = RequestMethod.GET)
	public WebBean<PageBeans<WarehouseDTO>> page(WarehouseQueryDTO dto) {
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		Validate.notNull(dto.getPageNo(),"分页参数不能为空");
		Validate.notNull(dto.getPageSize(),"分页参数不能为空");
		PageBeans<WarehouseDTO> result = warehouseFacade.queryPage(dto);
		return  WebBean.ok(result);
	}

	@ApiOperation(value = "列表查询")
	@RequestMapping(value = "/warehouse/list", method = RequestMethod.GET)
	public WebBean<List<WarehouseDTO>> list(WarehouseQueryDTO dto) {
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(warehouseFacade.queryList(dto));
	}

	@ApiOperation(value = "编辑-仓库ID必传")
	@RequestMapping(value = "/warehouse/edit", method = RequestMethod.POST)
	public WebBean<Void> edit(@RequestBody  WarehouseDTO dto) {
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		Validate.notNull(dto.getWarehouseName(),"仓库名称不能为空");
		Validate.notNull(dto.getWarehouseAddress(),"仓库地址不能为空");
		Validate.notNull(dto.getCityId(),"城市ID不能为空");
		Validate.notNull(dto.getWarehouseCode(),"仓库ID不能为空");
		warehouseFacade.edit(dto);
		return  WebBean.ok();
	}

	@ApiOperation(value = "删除-仓库ID必传")
	@RequestMapping(value = "/warehouse/delete", method = RequestMethod.POST)
	public WebBean<Void> delete(@RequestBody WarehouseQueryDTO dto) {
		Validate.notNull(dto.getWarehouseCode(),"仓库编码不能为空");
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		warehouseFacade.delete(dto);
		return  WebBean.ok();
	}

	@ApiOperation(value = "获取城市的仓库列表")
	@RequestMapping(value = "/warehouse/list-warehouse", method = RequestMethod.GET)
	public WebBean<List<WarehouseDTO>> listWarehouse() {
		WarehouseQueryDTO dto = new WarehouseQueryDTO();
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(warehouseFacade.listWarehouse(dto));
	}
}
