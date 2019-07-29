package com.morning.star.retail.facade.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.dao.GoodsDAO;
import com.morning.star.retail.entity.repository.BrandRepository;
import com.morning.star.retail.entity.repository.CategoryRepository;
import com.morning.star.retail.facade.BrandFacade;
import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.dto.BrandAddDTO;
import com.morning.star.retail.facade.dto.BrandCountDTO;
import com.morning.star.retail.facade.dto.BrandCountReDTO;
import com.morning.star.retail.facade.dto.CategoryCountDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * @author ethan
 * @create_time 2018/7/24 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodServer.class)
public class BrandFacadeTest {

	@Autowired
	private BrandFacade brandFacade;
	@Autowired
	private CategoryFacade categoryFacade;

	@org.junit.Test
	public void add() {
		BrandAddDTO brandAddDTO = new BrandAddDTO();
		brandAddDTO.setBrandName("test");
		brandFacade.create(brandAddDTO);
	}

	//同步品牌数据
	@Test
	public void add1() {
		BrandCountDTO brandCountDTO = new BrandCountDTO();
		brandCountDTO.setPageNo(1);
		brandCountDTO.setPageSize(10);
		PageBean<BrandCountReDTO> queryCountPage = brandFacade.queryCountPage(brandCountDTO);
		for (BrandCountReDTO dto : queryCountPage.getRecord()) {
			BrandAddDTO brandAddDTO = new BrandAddDTO();
			if(dto.getBrandName()!=null){				
				brandAddDTO.setBrandName(dto.getBrandName());		
				brandFacade.create(brandAddDTO);
			}
		}

	}
	
	//同步分类数据
	@Test
	public void add2() {
		CategoryCountDTO categoryCountDTO = new CategoryCountDTO();
		categoryCountDTO.setPageNo(1);
		categoryCountDTO.setPageSize(11);
		categoryCountDTO.setClevel(1);
		categoryCountDTO.setCategoryName("hh");
		categoryFacade.queryCountPage(categoryCountDTO);
	}
}