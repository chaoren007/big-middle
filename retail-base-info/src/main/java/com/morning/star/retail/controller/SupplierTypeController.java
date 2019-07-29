package com.morning.star.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.SupplierTypeDTO;
import com.morning.star.retail.dto.SupplierTypeQueryDTO;
import com.morning.star.retail.facade.SupplierTypeFacade;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/suppliertype/")
public class SupplierTypeController {

    @Autowired
    private SupplierTypeFacade facade;

    @ApiOperation(value = "供应商类别-新增")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public void create(@RequestBody SupplierTypeDTO dto) {
        facade.create(dto);
    }

    @ApiOperation(value = "供应商类别-修改")
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public void modify(@RequestBody SupplierTypeDTO dto) {
        facade.modify(dto);
    }

    @ApiOperation(value = "供应商类别-删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void modify(String code) {
        facade.delete(code);
    }

    @ApiOperation(value = "供应商类别-列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageBeans<SupplierTypeDTO> list(SupplierTypeQueryDTO queryDTO) {
        return facade.list(queryDTO);
    }
}
