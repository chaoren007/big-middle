package com.morning.star.retail.application;

import java.util.List;

import com.morning.star.retail.facade.dto.*;
import org.apache.ibatis.session.RowBounds;

import com.morning.star.retail.utils.page.PageBean;

public interface BrandApplication {
	
    Long create(BrandAddDTO dto);
   
    void delete(Long id);

	void edit(BrandUpdateDTO dto);

	List<BrandDTO> queryList(BrandQueryDTO brandQueryDTO);

	PageBean<BrandDTO> queryPage(BrandQueryDTO brandQueryDTO, RowBounds bounds);



	PageBean<BrandCountReDTO> queryCountPage(BrandCountDTO dto);
	PageBean<BrandCountReDTO> queryCountGroupPage(BrandCountDTO dto);

	BrandDTO getByCode(Long id);

}
