package com.morning.star.retail.facade.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.application.BrandApplication;
import com.morning.star.retail.facade.BrandFacade;
import com.morning.star.retail.facade.dto.BrandAddDTO;
import com.morning.star.retail.facade.dto.BrandCountDTO;
import com.morning.star.retail.facade.dto.BrandCountReDTO;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.facade.dto.BrandQueryDTO;
import com.morning.star.retail.facade.dto.BrandUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class BrandFacadeImpl implements BrandFacade {
	@Autowired
	private BrandApplication brandApplication;

	@Override
	public PageBean<BrandDTO> queryPage(BrandQueryDTO brandQueryDTO) {
		Validate.notNull(brandQueryDTO.getPageNo(),"分页参数不能为空");
		Validate.notNull(brandQueryDTO.getPageSize(),"分页参数不能为空");
		PageBean<BrandDTO> brandByPage = brandApplication.queryPage(brandQueryDTO,
				RowBoundsBuilder.build(brandQueryDTO.getPageNo(), brandQueryDTO.getPageSize()));
		return brandByPage;
	}

	@Override
	public List<BrandDTO> queryList(BrandQueryDTO brandQueryDTO) {

		List<BrandDTO> brandToList = brandApplication.queryList(brandQueryDTO);

		return brandToList;
	}

	@Override
	public Long create(BrandAddDTO dto) {

		return brandApplication.create(dto);
	}

	@Override
	public void delete(Long id) {
		brandApplication.delete(id);
	}

	@Override
	public void edit(BrandUpdateDTO dto) {
		brandApplication.edit(dto);
	}



	@Override
	public PageBean<BrandCountReDTO> queryCountPage(BrandCountDTO dto) {
		return brandApplication.queryCountPage(dto);
	}

	@Override
	public PageBean<BrandCountReDTO> queryCountGroupPage(BrandCountDTO dto) {
		return brandApplication.queryCountGroupPage(dto);
	}

	@Override
	public BrandDTO getByCode(Long id) {
		
		return brandApplication.getByCode(id);
	}

}
