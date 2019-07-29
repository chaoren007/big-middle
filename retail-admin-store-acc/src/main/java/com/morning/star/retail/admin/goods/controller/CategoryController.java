package com.morning.star.retail.admin.goods.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"门店分类"})
@RestController
@RequestMapping("/api/category")
public class CategoryController extends AdminController {
	@Autowired
	private CategoryFacade categoryFacade;

	@ApiOperation(value = "分类列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<List<CategoryDTO>> list(CategoryQueryDTO dto) {
		return WebBean.ok(categoryFacade.queryList(dto.getCategoryId(), dto.getCategoryName()));
	}

	@ApiOperation(value = "获取分类统计")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<PageBean<CategoryCountReDTO>> getCategoryConut(CategoryCountDTO dto) {
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		dto.setStoreCode(getLoginAdmin().getStoreCode());
		return WebBean.ok(categoryFacade.queryCountPage(dto));
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

	/*
	 * @RequestMapping(value = "addCategory")
	 *
	 * @ResponseBody public WebJsonBean addCategory(@RequestParam(required =
	 * true) Long parentId, @RequestParam(required = true) String categoryName)
	 * { long id = categoryFacade.createCategory(parentId, categoryName); return
	 * new WebJsonBean(CODE.SUCCESS, id); }
	 */
	/*
	 * @RequestMapping(value = "updateCategory")
	 *
	 * @ResponseBody public WebJsonBean updateCategory(@RequestParam(required =
	 * true) Long id, @RequestParam(required = true) String categoryName) {
	 * categoryFacade.updateCategory(id,categoryName); return new
	 * WebJsonBean(CODE.SUCCESS); }
	 */

	/*
	 * @RequestMapping(value = "deleteCategory")
	 *
	 * @ResponseBody public WebJsonBean deleteCategory(@RequestParam(required =
	 * true) Long id) { categoryFacade.deleteCategory(id); return new
	 * WebJsonBean(CODE.SUCCESS); }
	 */

	/*
	 * @RequestMapping(value = "toTop")
	 *
	 * @ResponseBody public WebJsonBean toTop(@RequestParam(required = true)
	 * Integer id, @RequestParam(required = true) Integer parentId) {
	 * categoryService.toTop(CategoryDTO.of(id, parentId, getLoginAdmin()));
	 * return new WebJsonBean(CODE.SUCCESS); }
	 */
}
