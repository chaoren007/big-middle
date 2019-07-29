package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface CategoryFacade {
	/**
	 * 添加分类
	 * @param dto
	 * @return
	 */
	Long create(CategoryAddDTO dto);

	/**
	 * 删除分类
	 * @param categoryId
	 */
	void delete(Long categoryId);

	/**
	 * 编辑分类
	 * @param dto
	 */
	void edit(CategoryUpdateDTO dto);

	/**
	 * 查询该分类下的所有子分类
	 * @param categoryId
	 * @param categoryName
	 * @return
	 */
	List<CategoryDTO> queryList(Long categoryId,String categoryName);

	/**
	 * 模糊查询三级分类
	 * @param
	 * @param categoryName
	 * @return
	 */
	List<CategoryDTO> queryCategory3List(String categoryName);
	PageBean<CategoryCountReDTO> queryCountPage(CategoryCountDTO dto);
	PageBean<CategoryCountReDTO> queryCountGroupPage(CategoryCountDTO dto);

	/**
	 * 根据分类ID获取分类信息
	 * @param categoryId
	 * @return
	 */
	public CategoryDTO getByCode(Long categoryId);

	/**
	 * 获取分类属性
	 * @param categoryId
	 * @return
	 */
	CategoryDTO getProperty(Long categoryId);

	/**
	 * 记录分类Log
	 * @param categoryId
	 * @return
	 */
	 void statisticCategory(Long categoryId);

	/**
	 * 获取常用 最近一个月使用最多的
	 * @param
	 * @return
	 */
	List<CategoryHotListDTO> getUseAlways();
	/**
	 * 获取一级分类列表
	 * @return
	 */
	List<CategoryDTO>  getDepartment();

}
