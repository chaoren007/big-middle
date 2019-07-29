package com.morning.star.retail.admin.group.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.constant.GoodsCategoryConst;
import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(tags = {"集团分类"})
@RestController
@RequestMapping("/api/category")
public class GroupCategoryController extends AdminController {
	@Autowired
	private CategoryFacade categoryFacade;


	@ApiOperation(value = "添加分类")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Long> addCategory(@RequestBody CategoryAddDTO dto) {
		Validate.notNull(dto.getCategoryName(), "分类名称不能为空!");
		Validate.notNull(dto.getParentId(), "父分类不能为空!");
		Long id = categoryFacade.create(dto);
		//检查是否符合类目规则
		return WebBean.ok(id);
	}

	@ApiOperation(value = "修改分类")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> updateCategory(@RequestBody CategoryUpdateDTO dto) {
		dto.setMaxCommission(new BigDecimal(999999));
		Validate.notNull(dto.getCategoryId(), "分类ID不能为空!");
		Validate.notNull(dto.getCategoryName(), "分类名称不能为空!");
		Validate.notNull(dto.getMaxCommission(), "最大分佣比例不能为空!");
		Validate.notNull(dto.getMinCommission(), "最小分佣比例不能为空!");
		categoryFacade.edit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "删除分类")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Object> deleteCategory(@RequestBody CategoryDeleteDTO dto) {
		Validate.notNull(dto.getId(), "要删除的id不能为空!");
		categoryFacade.delete(dto.getId());
		return WebBean.ok();
	}

	@ApiOperation(value = "分类列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> list(CategoryQueryDTO dto) {
		return WebBean.ok(categoryFacade.queryList(dto.getCategoryId(), dto.getCategoryName()));
	}


	@ApiOperation(value = "获取分类属性")
	@RequestMapping(value = "/property", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<CategoryDTO> getProperty(CategoryQueryDTO dto) {
		Validate.isTrue(dto.getCategoryId().toString().length() == GoodsCategoryConst.LOWEST_SIZE, "分类编码格式错误！");

		return WebBean.ok(categoryFacade.getProperty(dto.getCategoryId()));
	}

	@ApiOperation(value = "添加categoryLog")
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<Void> statisticCategory(CategoryQueryDTO dto) {
		Validate.isTrue(dto.getCategoryId().toString().length() == GoodsCategoryConst.LOWEST_SIZE, "分类编码格式错误！");
		categoryFacade.statisticCategory(dto.getCategoryId());
		return WebBean.ok();
	}

	@ApiOperation(value = "获取分类统计")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<PageBean<CategoryCountReDTO>> getCategoryConut(CategoryCountDTO dto) {
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(categoryFacade.queryCountGroupPage(dto));
	}


	@ApiOperation(value = "获取部门列表")
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> getDepartment() {
		return WebBean.ok(categoryFacade.getDepartment());
	}


	@ApiOperation(value = "获取热榜")
	@RequestMapping(value = "/hot-list", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryHotListDTO>> hotList() {

		return WebBean.ok(categoryFacade.getUseAlways());
	}

	@ApiOperation(value = "模糊查询三级分类")
	@RequestMapping(value = "/list_category3", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> listCategory3(CategoryQueryDTO dto) {
		return WebBean.ok(categoryFacade.queryCategory3List(dto.getCategoryName()));
	}
}
