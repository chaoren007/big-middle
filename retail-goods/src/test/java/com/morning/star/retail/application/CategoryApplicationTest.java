package com.morning.star.retail.application;

import com.morning.star.redis.Redis;
import com.morning.star.retail.GoodServer;
import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.facade.dto.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ethan
 * @create_time 2018/8/15 16:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodServer.class)
public class CategoryApplicationTest {

	@Autowired
	private CategoryApplication categoryApplication;

	@Autowired
	private Redis redis;

	@Test
	public void testRedis() {
		redis.delete("all_categorys");
	}

	@Test
	public void getParentList() {
		CategoryDTO parentList = categoryApplication.getParent(3594L);
		System.out.print(parentList);
	}

	@Test
	public void test() {
		String s = null;
		System.out.print(new BigDecimal(s));
	}
	@Test
	public void test1(){
		CategoryEntity byCategoryId = categoryApplication.getByCategoryId(10L);
		System.out.println("++++++++++++++++++++===================++++++++++++++++++++++++++"+byCategoryId.getCategoryName());

	}
}