package com.morning.star.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.facade.BrandFacade;
import com.morning.star.retail.facade.dto.BrandAddDTO;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.facade.dto.BrandQueryDTO;
import com.morning.star.retail.facade.dto.BrandUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.ApiOperation;

/**
 * @author ethan
 * @createTime 2018/7/12 15:01
 */
@RestController
@RequestMapping("/brand-api/v1")
public class BrandController {
	@Autowired
	private BrandFacade brandFacade;

	@ApiOperation(value = "获取品牌信息")
	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public PageBean<BrandDTO> queryByPage(BrandQueryDTO brandQueryDTO) {
		return brandFacade.queryPage(brandQueryDTO);
	}

	@ApiOperation(value = "修改品牌信息")
	@RequestMapping(value = "/brand", method = RequestMethod.PUT)
	public void updateBrandInfo(BrandUpdateDTO brandDTO) {
		brandFacade.edit(brandDTO);
	}

	@ApiOperation(value = "删除品牌信息")
	@RequestMapping(value = "/brand/{brandCode}", method = RequestMethod.DELETE)
	public void deleteBrandInfo(@PathVariable Long brandCode) {
		brandFacade.delete(brandCode);
	}

	@ApiOperation(value = "新增品牌信息")
	@RequestMapping(value = "/brand", method = RequestMethod.POST)
	public Long addBrandInfo(BrandAddDTO brandDTO) {
		return brandFacade.create(brandDTO);
	}
}
