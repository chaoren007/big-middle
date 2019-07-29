package com.morning.star.retail.facade.impl;

import java.util.Arrays;

import com.morning.star.retail.helper.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.facade.ProductFacade;

/**
 * @author ethan
 * @create_time 2018/7/16 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= GoodServer.class)
public class GroupGoodsFacadeImplTest {

	@Autowired
	private ProductFacade groupGoodsFacade;
	@Autowired
	private StoreService storeService;
	@Test
	public void onMarket() {
		groupGoodsFacade.onMarket(Arrays.asList("string_string"));
	}

	@Test
	public void offMarket() {
	}

	@Test
	public void getStoreInfo() {
		storeService.queryByGroupCode("JT00000005");
	}
}