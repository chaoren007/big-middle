package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ProductDAO {

	Page<ProductDTO> query(ProductQueryDTO bo, RowBounds rowBounds);

	List<ProductDTO> queryList(ProductQueryDTO bo);

	Page<ProductPullInfoDTO> queryForPull(ProductQueryDTO bo, RowBounds rowBounds);

	Page<CategoryCountReDTO> countCategory1(CategoryCountDTO dto, RowBounds bounds);

	Page<CategoryCountReDTO> countCategory2(CategoryCountDTO dto, RowBounds bounds);

	Page<CategoryCountReDTO> countCategory3(CategoryCountDTO dto, RowBounds bounds);


	Page<BrandCountReDTO> countBrand(BrandCountDTO dto, RowBounds bounds);

}
