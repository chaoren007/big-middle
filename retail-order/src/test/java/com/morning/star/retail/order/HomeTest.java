package com.morning.star.retail.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.order.facade.ClerkShiftServiceFacade;
import com.morning.star.retail.order.facade.OrderServiceFacadeForAdmin;
import com.morning.star.retail.order.facade.StatementOrderServiceFacade;
import com.morning.star.retail.order.facade.dto.ClerkShiftBO;
import com.morning.star.retail.order.facade.dto.ClerkShiftInfoVO;
import com.morning.star.retail.order.facade.dto.HomeSearchDTO;
import com.morning.star.retail.order.facade.dto.ItemStatisticsInfo;
import com.morning.star.retail.order.facade.dto.SalesDaySummaryDTO;
import com.morning.star.retail.order.facade.dto.SalesItemSummaryDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderVO;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HomeTest {
	@Autowired
	private StatementOrderServiceFacade statementServiceFacade;
	@Autowired
	private ClerkShiftServiceFacade clerkShiftServiceFacade;
	@Autowired
	private OrderServiceFacadeForAdmin orderServiceFacade;

	@Autowired
	private StockFacade stockFacade;

	@Test
	public void findOneTest() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		ClerkShiftBO clerkShiftBO=new ClerkShiftBO();
		//clerkShiftBO.setAccount(login.getAccount());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			clerkShiftBO.setLoginTime(simpleDateFormat.parse("2017-07-07"));
			clerkShiftBO.setHandoverTime(simpleDateFormat.parse("2018-10-07"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ClerkShiftInfoVO clerkShiftInfoVO = clerkShiftServiceFacade.generateShiftData(clerkShiftBO);
		System.out.println("测试结果:"+Json.toJson(clerkShiftInfoVO));
	}

	@Test
	public void topSaleItems() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		HomeSearchDTO searchDTO = new HomeSearchDTO();
		searchDTO.setPageNo(1);
		searchDTO.setPageSize(10);
		searchDTO.setBeginTime(searchDTO.getBeginTime());
		searchDTO.setEndTime(searchDTO.getEndTime());
		searchDTO.setOrderFiled(searchDTO.getOrderFiled()==null?"saleNum":searchDTO.getOrderFiled());

		PageBean<SalesItemSummaryDTO> list=orderServiceFacade.countSaleItems(searchDTO);
		System.out.println("测试结果:"+Json.toJson(list));
	}

	@Test
	public void salesDaySummary() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		HomeSearchDTO searchDTO = new HomeSearchDTO();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			searchDTO.setBeginTime(simpleDateFormat.parse("2017-07-07"));
			searchDTO.setEndTime(simpleDateFormat.parse("2018-10-07"));
			searchDTO.setYear(1);
			searchDTO.setMonth(2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SalesDaySummaryDTO salesDaySummaryDTO = orderServiceFacade.salesDaySummary(searchDTO);
		System.out.println("测试结果:"+Json.toJson(salesDaySummaryDTO));
	}

	@Test
	public void saleItemsSummary() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		HomeSearchDTO searchDTO = new HomeSearchDTO();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			searchDTO.setBeginTime(simpleDateFormat.parse("2017-07-07"));
			searchDTO.setEndTime(simpleDateFormat.parse("2018-10-07"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ItemStatisticsInfo itemStatisticsInfo = orderServiceFacade.saleItemsSummary(searchDTO);
		System.out.println("测试结果:"+Json.toJson(itemStatisticsInfo));
	}




	@Test
	public void topItemCategory() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		HomeSearchDTO searchDTO = new HomeSearchDTO();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			searchDTO.setBeginTime(simpleDateFormat.parse("2017-07-07"));
			searchDTO.setEndTime(simpleDateFormat.parse("2018-10-07"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PageBean<SalesItemSummaryDTO> salesItemSummaryDTOPageBean = orderServiceFacade.countItemCategory(searchDTO);
		System.out.println("测试结果:"+Json.toJson(salesItemSummaryDTOPageBean));
	}

	@Test
	public void exportOrderItemSummary() {
		UserUtils.setCurrentUser(UserUtils.defaultUser());
		StatementOrderSearchDTO search = new StatementOrderSearchDTO();
		Integer pageSize=Integer.MAX_VALUE;
		search.setGroupCode("1");
//        search.setCompanyCode(companyCode);
		search.setStoreCode(search.getStoreCode());
		search.setPageNo(1);
		search.setPageSize(pageSize);

		PageBean<StatementOrderVO> orders = statementServiceFacade.orderItemSummary(search);
		System.out.println("测试结果:"+Json.toJson(orders));
	}
}