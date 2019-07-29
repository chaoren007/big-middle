package com.morning.star.retail.stock.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.facade.ReplenishFacade;
import com.morning.star.retail.stock.entity.ReplenishItemEntity;
import com.morning.star.retail.stock.entity.repository.ReplenishItemRepository;

/**
 * @author ethan
 * @create_time 2018/7/25 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class ReplenishFacadeTest {
	@Autowired
	private ReplenishFacade replenishFacade;

	@Autowired
	private ReplenishItemRepository replenishItemRepository;

	@Test
	public void test() {
		ReplenishItemEntity entity = new ReplenishItemEntity();
		entity.setDeleteFlag(0);
		replenishItemRepository.save(entity);
	}
}
