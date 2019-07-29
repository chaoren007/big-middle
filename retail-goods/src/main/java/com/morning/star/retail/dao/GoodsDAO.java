package com.morning.star.retail.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.BrandCountDTO;
import com.morning.star.retail.facade.dto.BrandCountReDTO;
import com.morning.star.retail.facade.dto.CategoryCountDTO;
import com.morning.star.retail.facade.dto.CategoryCountReDTO;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.GoodsPosSyncQueryDTO;
import com.morning.star.retail.facade.dto.GoodsQueryDTO;

public interface GoodsDAO {

	Page<GoodsDTO> query(GoodsQueryDTO dto, RowBounds rowBounds);

	List<GoodsDTO> queryList(GoodsQueryDTO dto);

	Page<GoodsDTO> queryForCity(GoodsQueryDTO dto, RowBounds rowBounds);

	Page<GoodsDTO> queryPosSyncGoods(GoodsPosSyncQueryDTO dto, RowBounds rowBounds);

	List<GoodsDTO> queryPosGoodsByUpc(@Param("storeCode") String storeCode, @Param("sapCodeList") List<String> sapCodeList);

	Page<CategoryCountReDTO> countCategory1(CategoryCountDTO dto, RowBounds bounds);

	Page<CategoryCountReDTO> countCategory2(CategoryCountDTO dto, RowBounds bounds);

	Page<CategoryCountReDTO> countCategory3(CategoryCountDTO dto, RowBounds bounds);

	Page<BrandCountReDTO> countBrand(BrandCountDTO dto, RowBounds bounds);

}
