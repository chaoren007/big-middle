package com.morning.star.retail.repository.test;


import java.util.Arrays;

import com.morning.star.retail.entity.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.application.ProductApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodServer.class)
public class GroupGoodsRepositoryTest {
	@Autowired
	private ProductApplication groupGoodsApplication;
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void findOneTest(){
	    groupGoodsApplication.onMarket(Arrays.asList("string_string"));
	}

	@Test
	public void test(){
		productRepository.findOne("GC180402152847001056");
	}

}
