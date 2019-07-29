package com.morning.star.retail.dao;

import java.util.List;

import com.morning.star.retail.facade.dto.CategoryUpdateDTO;
import org.apache.ibatis.annotations.Param;

import com.morning.star.retail.facade.dto.CategoryDTO;
import com.morning.star.retail.facade.dto.CategoryQueryDTO;

public interface CategoryDAO {
	Integer getMaxSort(@Param("parentId") Long parentId);

	List<CategoryDTO> queryList(CategoryQueryDTO queryDTO);


	List<CategoryDTO> getByCategoryName(CategoryQueryDTO queryDTO);

	CategoryDTO getByCategoryId(Long categoryId);

	/**
	 * 跟新所有子类的分佣比例
	 * @param
	 */
	void updateCommission(CategoryUpdateDTO dto);

	/**
	 *
	 * @return
	 */
     List<CategoryDTO> getUseAlways();
}
