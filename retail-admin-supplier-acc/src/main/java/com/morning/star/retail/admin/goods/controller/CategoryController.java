package com.morning.star.retail.admin.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.constant.GoodsCategoryConst;
import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.dto.CategoryDTO;
import com.morning.star.retail.facade.dto.CategoryHotListDTO;
import com.morning.star.retail.facade.dto.CategoryQueryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"分类"})
@RestController
@RequestMapping("/api/category")
public class CategoryController extends AdminController {

	@Autowired
	private CategoryFacade categoryFacade;

	@ApiOperation(value = "分类列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> queryList(CategoryQueryDTO dto) {
		return WebBean.ok(categoryFacade.queryList(dto.getCategoryId(), dto.getCategoryName()));
	}

	@ApiOperation(value = "获取分类属性")
	@RequestMapping(value = "/property", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<CategoryDTO> getProperty(CategoryQueryDTO dto) {
		org.apache.commons.lang.Validate.isTrue(dto.getCategoryId().toString().length() == GoodsCategoryConst.LOWEST_SIZE, "分类编码格式错误！");

		return WebBean.ok(categoryFacade.getProperty(dto.getCategoryId()));
	}

	@ApiOperation(value = "模糊查询三级分类")
	@RequestMapping(value = "/list_category3", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> listCategory3(CategoryQueryDTO dto) {
		return WebBean.ok(categoryFacade.queryCategory3List(dto.getCategoryName()));
	}

	@ApiOperation(value = "添加categoryLog")
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<Void> statisticCategory(CategoryQueryDTO dto) {
		org.apache.commons.lang.Validate.isTrue(dto.getCategoryId().toString().length() == GoodsCategoryConst.LOWEST_SIZE, "分类编码格式错误！");
		categoryFacade.statisticCategory(dto.getCategoryId());
		return WebBean.ok();
	}

	@ApiOperation(value = "获取热榜")
	@RequestMapping(value = "/hot-list", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryHotListDTO>> hotList() {

		return WebBean.ok(categoryFacade.getUseAlways());
	}

}
