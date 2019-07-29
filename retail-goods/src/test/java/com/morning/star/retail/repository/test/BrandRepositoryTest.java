package com.morning.star.retail.repository.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.entity.BrandEntity;
import com.morning.star.retail.entity.repository.BrandRepository;
import com.morning.star.retail.util.Json;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodServer.class)
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;

	

	@Test
	public void getByCode() {
		BrandEntity findByBrandCode = brandRepository.findOne(77L);
		findByBrandCode.setBrandName("名字");
		BrandEntity save = brandRepository.save(findByBrandCode);
	}

	@Test
	public void add() {
		BrandEntity entity = new BrandEntity();
		entity.setBrandName("名字");
		BrandEntity save = brandRepository.save(entity);
	}

	@Test
	public void getByName() {
		List<BrandEntity> byBrandName = brandRepository.getByBrandName(null);
		for (BrandEntity brandEntity : byBrandName) {
			System.out.println(brandEntity.getBrandName());
		}

	}
	@Test
	public void Test1(){
		List<BrandEntity> list = brandRepository.getByBrandName(null);
		System.out.println(Json.toJson(list));
	}
}
