package com.morning.star.retail.application;

import com.morning.star.retail.GoodServer;
import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyAuditGroupDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ethan
 * @create_time 2019/5/20 16:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodServer.class)
public class GoodsSupplyApplicationImplTest {
	@Autowired
	private GoodsSupplyApplication goodsSupplyApplication;

	@Test
	public void auditGroup() {
		GoodsSupplyAuditGroupDTO dto = new GoodsSupplyAuditGroupDTO();
		dto.setProductCode("100101010008");
		dto.setCityId("440100");
		goodsSupplyApplication.auditGroup(dto, GoodsSupplyStatus.ON_SALE);
	}
}