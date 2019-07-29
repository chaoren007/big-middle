package com.morning.star.retail.order;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.OrderServiceFacadeForPos;
import com.morning.star.retail.order.facade.dto.AfterSalesOrderDTO;
import com.morning.star.retail.order.facade.dto.QueryWaitExamineOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.qo.ExamineGoodsQO;
import com.morning.star.retail.util.Json;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SalesOrderRepositoryTest {
	@Autowired
	private AfterSalesServiceFacade afterSalesServiceFacade;
	@Autowired
	//private AfterSalesOrderRepository afterSalesOrderRepository;

	@Test
	public void findOneTest() {
		AfterSalesOrderDTO detail = afterSalesServiceFacade.getDetail("1");
		System.out.println("测试结果:"+Json.toJson(detail));
	}

	@Test
	public void auditOrder() {
		afterSalesServiceFacade.auditOrder("1",1,"测试");
	}

	@Test
	public void examineGoods() {
		ExamineGoodsQO examineGoodsQO = new ExamineGoodsQO();
		examineGoodsQO.setAfterSalesCode("1");
		examineGoodsQO.setPass(0);
		examineGoodsQO.setRemark("");
		examineGoodsQO.setRealTotalRefundAmount(new BigDecimal("0"));
		examineGoodsQO.setHasReturnedItem(0);
		examineGoodsQO.setAgree(0);
		afterSalesServiceFacade.examineGoods(examineGoodsQO);
	}

	@Test
	public void listAfterSalesOrders() {
		AfterSalesOrderDTO afterSalesOrderDTO = new AfterSalesOrderDTO();
		System.out.println("测试结果:"+Json.toJson(afterSalesServiceFacade.listAfterSalesOrders(afterSalesOrderDTO)));
	}

	@Test
	public void listWaitExamineOrder() {
		QueryWaitExamineOrderDTO afterSalesOrderDTO = new QueryWaitExamineOrderDTO();
		System.out.println("测试结果:"+Json.toJson(afterSalesServiceFacade.listWaitExamineOrder(afterSalesOrderDTO)));
	}

	@Test
	public void detail() {
//		QueryWaitExamineOrderDTO afterSalesOrderDTO = new QueryWaitExamineOrderDTO();
		System.out.println("测试结果:"+Json.toJson(afterSalesServiceFacade.getDetail("1")));
	}

	@Autowired
	private OrderServiceFacadeForPos orderRepository;

	@Test
	public void order() {
		String order = "{\n" +
				"  \"buyRemark\": \"购买备注\",\n" +
				"  \"createTime\": \"2018-08-06T07:33:07.253Z\",\n" +
				"  \"discountAmount\": 0,\n" +
				"  \"discountSpecial\": 0,\n" +
				"  \"goodsItems\": [\n" +
				"    {\n" +
				"      \"buyNum\": 2,\n" +
				"      \"discountAmount\": 0,\n" +
				"      \"goodsCode\": \"GC180322195125001007_GS00000016\",\n" +
				"      \"goodsImage\": \"\",\n" +
				"      \"goodsName\": \"Meizu\",\n" +
				"      \"halfPriceNum\": 0,\n" +
				"      \"originalPrice\": 4.00,\n" +
				"      \"realPrice\": 4.00,\n" +
				"      \"specInfo\": \"100*100\",\n" +
				"      \"unit\": \"个\",\n" +
				"      \"unitPrice\": 2.00,\n" +
				"      \"upcCode\": \"条形码\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"buyNum\": 3,\n" +
				"      \"discountAmount\": 0,\n" +
				"      \"goodsCode\": \"GC180322200906001027_GS00000016\",\n" +
				"      \"goodsImage\": \"\",\n" +
				"      \"goodsName\": \"尔IPI面膜1\",\n" +
				"      \"halfPriceNum\": 0,\n" +
				"      \"originalPrice\": 120.00,\n" +
				"      \"realPrice\": 120.00,\n" +
				"      \"specInfo\": \"100*100\",\n" +
				"      \"unit\": \"个\",\n" +
				"      \"unitPrice\": 40.00,\n" +
				"      \"upcCode\": \"条形码\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"groupCode\": \"JT00000005\",\n" +
				"  \"orderCode\": \"0011\",\n" +
				"  \"payAmount\": 4,\n" +
				"  \"payChannel\": \"CASH\",\n" +
				"  \"payTradeNo\": \"00011\",\n" +
				"  \"salesOrderOperation\": {\n" +
				"    \"operationContent\": \"订单创建\",\n" +
				"    \"operationId\": \"操作人id1\",\n" +
				"    \"operationName\": \"操作人姓名\"\n" +
				"  },\n" +
				"  \"storeCode\": \"GS00000016\",\n" +
				"  \"totalAmount\": 124.00\n" +
				"}\t\t";

		OrderReqParams orderReqParams = JSONObject.parseObject(order, OrderReqParams.class);

		//orderRepository.submitPosOrder(orderReqParams);



		/*// 创建两个Session,模拟多个Session操作student数据表
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		// 查询Student
		SalesOrderEntity stu1 = (SalesOrderEntity) session1.createQuery("from Student s where s.name='tom11'")
				.uniqueResult();
		SalesOrderEntity stu2 = (SalesOrderEntity) session2.createQuery("from Student s where s.name='tom11'")
				.uniqueResult();
		// 这时候，两个版本号是相同的
		System.out.println("v1=" + stu1.getVersion() + "--v2=" + stu2.getVersion());

		Transaction tx1 = session1.beginTransaction();
		//stu1.setName("session1");
		tx1.commit();
		// 这时候，两个版本号是不同的，其中一个的版本号递增了
		System.out.println("v1=" + stu1.getVersion() + "--v2=" + stu2.getVersion());

		Transaction tx2 = session2.beginTransaction();
		//stu2.setName("session2");
		tx2.commit();*/
	}


}