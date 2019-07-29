package com.morning.star.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.dto.CategoryAddDTO;
import com.morning.star.retail.facade.dto.CategoryDTO;

import io.swagger.annotations.ApiOperation;

/**
 * 分类
 * @author Dell
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoryFacade categoryFacade;


	@ApiOperation(value = "添加分类")
	@RequestMapping(value = "catagories", method = RequestMethod.POST)
	public Long CreateCategory(@RequestBody CategoryAddDTO command) {
		return categoryFacade.create(command);
	}

	@ApiOperation(value = "删除分类")
	@RequestMapping(value = "catagories/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Long id) {
		categoryFacade.delete(id);
	}

	@ApiOperation(value = "获取分类")
	@RequestMapping(value = "catagories/{id}", method = RequestMethod.GET)
	public List<CategoryDTO> queryCategory(@PathVariable Long id ,@RequestParam String categoryName){
		return categoryFacade.queryList(id,categoryName);
	}
	

}
