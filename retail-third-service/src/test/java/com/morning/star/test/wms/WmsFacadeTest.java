package com.morning.star.test.wms;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.Main;
import com.morning.star.retail.application.WmsServiceApplication;
import com.morning.star.retail.facade.*;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.wms.Remsg;
import com.wms.WMS;
import com.wms.WMSPortType;
import com.wms.bean.ResultFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author kimhuhg
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class WmsFacadeTest {

	@Autowired
	private ThirdServiceFailFacade thirdServiceFailFacade;

	@Autowired
	private CustomerWmsFacade customerWmsFacade;

	@Autowired
	private OutStockWmsFacade outStockWmsFacade;

	@Autowired
	private WmsServiceApplication wmsServiceApplication;

	@Test
	public void add() {
		GoodsWmsDTO goodsWmsDTO = new GoodsWmsDTO();
		goodsWmsDTO.setCategoryId3(100L);
//		goodsWmsDTO.setProductCode("测试");
//		goodsWmsDTO.setProductName("测试");
		goodsWmsDTO.setShelfLife(1);
		goodsWmsDTO.setSpuInfo("测试");
		goodsWmsDTO.setUnitsName("测试");
//		productWmsFacade.add(goodsWmsDTO);
	}

	@Test
	public void addCustomer() {
		SupplierWmsDTO supplierWmsDTO = new SupplierWmsDTO();
		supplierWmsDTO.setSupplierCode("1234");
		supplierWmsDTO.setSupplierName("测试");
		customerWmsFacade.add(supplierWmsDTO);

	}

	@Test
	public void addOutStock() {

		OutStockWmsDTO outStockWmsDTO = new OutStockWmsDTO();
		outStockWmsDTO.setAddress("深圳宝安");
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		outStockWmsDTO.setCreateTime(format);
		outStockWmsDTO.setOperatorName("nwn");
		outStockWmsDTO.setOutStockCode("1343214314");
		outStockWmsDTO.setPhone("13456787345");
		outStockWmsDTO.setStoreCode("GS00000039");
		outStockWmsDTO.setUserId("1234");
		outStockWmsDTO.setUsername("小爱");
		outStockWmsDTO.setWarehouseCode("1001");


		OutStockDetailWmsDTO outStockDetailWmsDTO = new OutStockDetailWmsDTO();
		outStockDetailWmsDTO.setProductCode("11010020004");
		outStockDetailWmsDTO.setStoreCode("GS00000038");
		outStockDetailWmsDTO.setQty(new BigDecimal(1));

		ArrayList<OutStockDetailWmsDTO> list = new ArrayList<>();
		list.add(outStockDetailWmsDTO);
		outStockWmsDTO.setDetail(list);
		outStockWmsFacade.add(outStockWmsDTO);
	}

	@Test
	public void addCategory() {
		wmsServiceApplication.addCategory(null);
	}

	@Test
	public void pageFail() {
		ThirdServiceQueryDTO dto = new ThirdServiceQueryDTO();
		PageBean<ThirdServiceFailDTO> page = thirdServiceFailFacade.page(dto);
		page.getPageSize();
	}

}