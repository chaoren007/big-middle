package com.morning.star.retail.stock.facade;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.stock.application.StockApplication;
import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Json;

/**
 * @author ethan
 * @create_time 2018/8/9 16:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class StockFacadeTest {
	@Autowired
	private StockApplication stockApplication;

	@Autowired
	private StockFacade stockFacade;

	@Test
	public void getInStockNum() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		StockQueryDTO searchDTO = new StockQueryDTO();
		searchDTO.setGroupCode("1");
		searchDTO.setStoreCode("1");
		List<StockDTO> query = stockFacade.query(searchDTO);
		System.out.println("测试结果:"+ Json.toJson(query));
	}
}
