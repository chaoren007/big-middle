package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.ProductPackApplication;
import com.morning.star.retail.dao.ProductPackDAO;
import com.morning.star.retail.facade.ProductPackFacade;
import com.morning.star.retail.facade.dto.ProductPackAddDTO;
import com.morning.star.retail.facade.dto.ProductPackDTO;
import com.morning.star.retail.facade.dto.ProductPackQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/4 10:58
 */
@Service
public class ProductPackFacadeImpl implements ProductPackFacade {

	@Autowired
	private ProductPackApplication productPackApplication;

	@Autowired
	private ProductPackDAO productPackDAO;

	@Override
	public void add(ProductPackAddDTO dto) {
		productPackApplication.add(dto);
	}

	@Override
	public PageBean<ProductPackDTO> query(ProductPackQueryDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<ProductPackDTO> pageDTO = productPackDAO.query(dto, rowBounds);
		return new PageBeanAssembler().toBean(pageDTO);
	}

	@Override
	public void batchImport(List<ProductPackAddDTO> dtos) {
		productPackApplication.batchImport(dtos);
	}
}
