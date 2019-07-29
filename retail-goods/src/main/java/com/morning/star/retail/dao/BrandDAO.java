package com.morning.star.retail.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.facade.dto.BrandQueryDTO;

@Repository
public interface BrandDAO {
	List<BrandDTO> queryList(BrandQueryDTO dto);

	Page<BrandDTO> queryPage(BrandQueryDTO dto, RowBounds bounds);

}
