package com.morning.star.retail.application;

import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface CategoryApplication {

	Long create(CategoryAddDTO dto);

	void delete(Long id);

	void edit(CategoryUpdateDTO dto);

	List<CategoryDTO> queryList(Long categoryId,String categoryName);

	List<CategoryDTO> queryCategory3List(String categoryName);

	PageBean<CategoryCountReDTO> queryCountPage(CategoryCountDTO dto);
	PageBean<CategoryCountReDTO> queryCountGroupPage(CategoryCountDTO dto);


	CategoryDTO getByCode(Long categoryId);

	CategoryDTO getParent(Long categoryId);

	/**
	 * 根据分类ID获取属性值和属性名称
	 * @param categoryId
	 * @return
	 */
	List<CategoryPropertyDTO> getProperty(Long categoryId);

	/**
	 * 记录日志
	 * @param categoryId
	 */
	void statisticCategory(Long categoryId);

	/**
	 *
	 * @param categoryId
	 * @return
	 */
	CategoryEntity getByCategoryId(Long categoryId);

}
