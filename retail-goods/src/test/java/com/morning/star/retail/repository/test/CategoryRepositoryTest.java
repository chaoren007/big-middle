package com.morning.star.retail.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.entity.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= GoodServer.class)
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository categoryRepository ;
	
	@Test
	public void TestRun(){
		TestOne();
	}
	private void TestOne(){
		CategoryEntity byCategoryId = categoryRepository.getByCategoryId(100102L);
		System.out.println(byCategoryId==null);
	}

}
