package com.morning.star.retail.stock.facade;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.dto.purchase.PurchaseAuditDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseSubmitDTO;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;

/**
 * @author ethan
 * @create_time 2018/8/8 20:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class PurchaseFacadeTest {
	@Autowired
	private PurchaseFacade purchaseFacade;

	@Test
	public void audit(){
		PurchaseAuditDTO dto = new PurchaseAuditDTO();
		dto.setPurchaseCode("PR180808202919001000");
		dto.setStatus(20);

		UserInfo userInfo = new UserInfo();
		userInfo.setId(0L);
		userInfo.setTag("accountLevel", "root");
		UserUtils.setCurrentUser(userInfo);
		purchaseFacade.auditPurchase(dto);
	}

	@Test
	public void test() {
		PurchaseSubmitDTO submitDTO = new PurchaseSubmitDTO();
		submitDTO.setPurchaseCode("PR180815100309001001");
		submitDTO.setIsDraft(1);
		submitDTO.setOrderDetail(new ArrayList<>());
		purchaseFacade.submitOrder(submitDTO);
	}
}
