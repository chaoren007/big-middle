package com.morning.star.retail.stock.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.facade.ReceiptDiffFacade;
import com.morning.star.retail.stock.dto.QueryReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;

/**
 * @author kimhuhg
 * @create_time 2018/8/17 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class ReceiptDiffFacadeTest {
	@Autowired
	private ReceiptDiffFacade receiptDiffFacade;

	@Test
	public void query() {
		QueryReceiptDiffDTO queryReceiptDiffDTO = new QueryReceiptDiffDTO();
		queryReceiptDiffDTO.setGroupCode("");
		queryReceiptDiffDTO.setReceiptCode("");
		queryReceiptDiffDTO.setReceiptTypeCode("");
		queryReceiptDiffDTO.setPageNo(1);
		queryReceiptDiffDTO.setPageSize(10);
		queryReceiptDiffDTO.setStoreCode("");
		queryReceiptDiffDTO.setStoreName("");
		queryReceiptDiffDTO.setSupplierCode("");
		queryReceiptDiffDTO.setSupplierName("");

		PageBean<ReceiptDiffInfoDTO> result = receiptDiffFacade.query(queryReceiptDiffDTO);
		String a = null;
		System.out.println("结果:"+Json.toJson(result));
	}

	@Test
	public void test() {
		System.out.println("结果:"+Json.toJson(receiptDiffFacade.list("RDS180817150847218000")));
	}
}
