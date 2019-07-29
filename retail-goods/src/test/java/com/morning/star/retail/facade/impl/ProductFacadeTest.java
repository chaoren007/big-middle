package com.morning.star.retail.facade.impl;

import java.util.Arrays;

import com.morning.star.retail.util.Json;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.ProductPullDTO;

/**
 * @author ethan
 * @create_time 2018/7/24 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= GoodServer.class)
public class ProductFacadeTest {

	@Autowired
	private ProductFacade productFacade;

	@org.junit.Test
	public void addProduct() {
	}

	@org.junit.Test
	public void pullProduct() {
		ProductPullDTO productPullDTO = new ProductPullDTO();
		productPullDTO.setSapProductCodes(Arrays.asList("1111111111"));
		productPullDTO.setFreshType(0);
		productPullDTO.setGroupCode("JT00000001");
		productFacade.pullProduct(productPullDTO);
	}

	@org.junit.Test
	public void updateProduct() {
	}

	@org.junit.Test
	public void queryProduct() {
		System.out.println("测试结果:"+ Json.toJson(productFacade.getByProductCode("GC1712221624520010")));
	}

	@org.junit.Test
	public void getDetail() {
	}

	@org.junit.Test
	public void onMarket() {
	}

	@org.junit.Test
	public void offMarket() {
	}

	@org.junit.Test
	public void onSale() {
	}

	@org.junit.Test
	public void offSale() {
	}
}