package com.morning.star.retail.stock.facade;
import com.morning.star.retail.StockServer;
import com.morning.star.retail.facade.ReceiptFacade;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author kimhuhg
 * @create_time 2018/7/30 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class ReceiptFacadeTest {
	@Autowired
	private ReceiptFacade receiptFacade;

	@Test
	public void test() {
		ReceiptDTO receiptInfoDTO = new ReceiptDTO();
		receiptInfoDTO.setReceiptCode("");
//		receiptInfoDTO.setReceiptTypeCode("");
		receiptInfoDTO.setGroupCode("");
//		receiptInfoDTO.setCompanyCode("");
		receiptInfoDTO.setStoreCode("");
		receiptInfoDTO.setStoreName("");
		receiptInfoDTO.setSupplierCode("");
		receiptInfoDTO.setSupplierName("");
//		receiptInfoDTO.setTransStatus(0);
//		receiptInfoDTO.setAmount(new BigDecimal("0"));
		receiptInfoDTO.setRemark("");
		//receiptInfoDTO.setDeleteFlag(0);
//		receiptInfoDTO.setCreateTime(new Date());
		//receiptInfoDTO.setOperatorId("");
		//receiptInfoDTO.setOperatorName("");
		receiptInfoDTO.setReceiptTime(new Date());
//		receiptInfoDTO.setStatusName("");
//		receiptInfoDTO.setReceiptType(0);
//		receiptInfoDTO.setReceiptName("");
		ArrayList<ReceiptItemDTO> list = new ArrayList<>();

		ReceiptItemDTO receiptItemInfoDTO = new ReceiptItemDTO();
		receiptItemInfoDTO.setReceiptCode("");
		receiptItemInfoDTO.setGoodsCode("");
		receiptItemInfoDTO.setUnitsName("");
		receiptItemInfoDTO.setUpcCode("");

		receiptItemInfoDTO.setPackSpecNum(0);
		receiptItemInfoDTO.setPackSpecUnits("");
		receiptItemInfoDTO.setProductCode("");
		receiptItemInfoDTO.setProductName("");
		receiptItemInfoDTO.setProductType("");

//		receiptItemInfoDTO.setOriginalPrice(new BigDecimal("0"));
//		receiptItemInfoDTO.setQty(BigDecimal.ZERO);
//		receiptItemInfoDTO.setPrice(new BigDecimal("0"));
//		receiptItemInfoDTO.setAmount(new BigDecimal("0"));
//		receiptItemInfoDTO.setRealQty(BigDecimal.ZERO);
//		receiptItemInfoDTO.setRemark("");
//		receiptItemInfoDTO.setShelfLife(0);
//		receiptItemInfoDTO.setProductionDate(new Date());
//		receiptItemInfoDTO.setExpirationDate(new Date());
//		receiptItemInfoDTO.setReturnableQty(BigDecimal.ZERO);
//
//		receiptItemInfoDTO.setCreateTime(new Date());

		list.add(receiptItemInfoDTO);
//		receiptFacade.saveReceipt(receiptInfoDTO);
	}

	@Test
	public void query() {
		ReceiptQueryDTO receiptQueryDTO = new ReceiptQueryDTO();
		receiptQueryDTO.setPageNo(1);
		receiptQueryDTO.setPageSize(10);
		PageBean<ReceiptDTO> receiptInfoDTOPageBean = receiptFacade.list(receiptQueryDTO);
		System.out.println("测试结果:"+Json.toJson(receiptInfoDTOPageBean));
	}

	@Test
	public void queryExport() {
		ExpiredGoodsQueryDTO queryReceiptDTO = new ExpiredGoodsQueryDTO();
		queryReceiptDTO.setPageNo(1);
		queryReceiptDTO.setPageSize(10);
		PageBean<ExpiredGoodsDTO> receiptInfoDTOPageBean = receiptFacade.queryExpiredGoods(queryReceiptDTO);
		System.out.println("测试结果:"+Json.toJson(receiptInfoDTOPageBean));
	}

//	@Test
//	public void saveDifferenceReceipt() {
//		ReceiptDifferenceDTO receiptDifferenceDTO = new ReceiptDifferenceDTO();
//		receiptDifferenceDTO.setReceiptCode("1");
//		receiptDifferenceDTO.setReceiptDifferenceCode("1");
//		receiptDifferenceDTO.setOutstockCode("1");
//		receiptDifferenceDTO.setGroupCode("1");
//		receiptDifferenceDTO.setStoreCode("1");
//		receiptDifferenceDTO.setStoreName("1");
//		receiptDifferenceDTO.setSupplierCode("1");
//		receiptDifferenceDTO.setSupplierName("1");
//		receiptDifferenceDTO.setAmount(new BigDecimal("0"));
//		receiptDifferenceDTO.setContract("1");
//		receiptDifferenceDTO.setRemark("1");
//		receiptDifferenceDTO.setCreateTime(new Date());
//		receiptDifferenceDTO.setModifyTime(new Date());
//		receiptDifferenceDTO.setReceiptTime(new Date());
//		receiptDifferenceDTO.setContainerCode("1");
//		receiptDifferenceDTO.setContainerName("1");
//		receiptDifferenceDTO.setOrderDetail(Lists.newArrayList());
//
//		ArrayList<ReceiptDiffItemInfoDTO> receiptDiffItemInfoDTOS = new ArrayList<>();
//		ReceiptDiffItemInfoDTO receiptDiffItemInfoDTO = new ReceiptDiffItemInfoDTO();
////		receiptDiffItemInfoDTO.setId(0L);
//		receiptDiffItemInfoDTO.setReceiptDifferenceCode("1");
//		receiptDiffItemInfoDTO.setGoodsCode("1");
//		receiptDiffItemInfoDTO.setUnitsId("1");
//		receiptDiffItemInfoDTO.setUnitsName("1");
//		receiptDiffItemInfoDTO.setUpcCode("1");
//		receiptDiffItemInfoDTO.setGroupCode("1");
//		receiptDiffItemInfoDTO.setGroupName("1");
//		receiptDiffItemInfoDTO.setPackSpecNum(0);
//		receiptDiffItemInfoDTO.setPackSpecUnits("1");
//		receiptDiffItemInfoDTO.setProductCode("1");
//		receiptDiffItemInfoDTO.setProductName("1");
//		receiptDiffItemInfoDTO.setProductType("1");
//		receiptDiffItemInfoDTO.setStoreCode("1");
//		receiptDiffItemInfoDTO.setStoreName("1");
//		receiptDiffItemInfoDTO.setOriginalPrice(new BigDecimal("0"));
//		receiptDiffItemInfoDTO.setQty(BigDecimal.ZERO);
//		receiptDiffItemInfoDTO.setPrice(new BigDecimal("0"));
//
//		receiptDiffItemInfoDTO.setRemark("1");
//		receiptDiffItemInfoDTO.setShelfLife(0);
//		receiptDiffItemInfoDTO.setProductionDate(new Date());
//		receiptDiffItemInfoDTO.setExpirationDate(new Date());
//
//		receiptDiffItemInfoDTO.setOperatorId("1");
//		receiptDiffItemInfoDTO.setOperatorName("1");
//		receiptDiffItemInfoDTO.setCreateTime(new Date());
//		receiptDiffItemInfoDTO.setModifyTime(new Date());
//		receiptDiffItemInfoDTO.setDifferenceQty(new BigDecimal(100));
//		receiptDiffItemInfoDTOS.add(receiptDiffItemInfoDTO);
//		receiptDifferenceDTO.setOrderDetail(receiptDiffItemInfoDTOS);
//		receiptFacade.saveReceiptDifference(receiptDifferenceDTO);
//	}

	@Test
	public void sureReceipt() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());

		SureReceiptDTO sureReceiptDTO = new SureReceiptDTO();
//		sureReceiptDTO.setReceiptCode("RS180820191244001002");
//		SureReceiptDTO sureReceiptDTO = new SureReceiptDTO();
//		sureReceiptDTO.setProductCode("PC180807143652001001");

		sureReceiptDTO.setQty(BigDecimal.ZERO);
		sureReceiptDTO.setGoodsCode("PC180820171846001007_GS00000001");
		sureReceiptDTO.setProductionDate(new Date());
		sureReceiptDTO.setShelfLife(7);
		ArrayList<SureReceiptDTO> sureReceiptDTOS = new ArrayList<>();
		sureReceiptDTOS.add(sureReceiptDTO);

//		sureReceiptDTO.setItem(sureReceiptDTOS);
		receiptFacade.sureReceipt(sureReceiptDTO,null);
	}
}
