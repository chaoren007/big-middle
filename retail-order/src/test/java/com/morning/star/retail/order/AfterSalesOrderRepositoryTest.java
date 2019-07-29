package com.morning.star.retail.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.util.Json;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AfterSalesOrderRepositoryTest {
	@Autowired
	private AfterSalesServiceFacade facade;

	@Test
	public void findOneTest() {
		System.out.println("测试结果:"+Json.toJson(facade.getDetail("ASC180810184418001000")));
	}

}