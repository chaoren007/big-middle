package com.morning.star.retail.pay.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.Main;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.client.OfflinePayClient;
import com.morning.star.retail.pay.dao.ScanPayDAO;
import com.morning.star.retail.pay.entity.ScanPayPO;
import com.morning.star.retail.pay.entity.ScanRefund;
import com.morning.star.retail.pay.enums.PayChannel;
import com.morning.star.retail.util.Json;

/**
 * Created by lenovo on 2017/6/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
@EnableAutoConfiguration
public class ScanPayServiceTest {

    @Autowired private ScanPayService scanPayService;
    @Autowired private ScanPayRemoteService scanPayRemoteService;
    @Autowired private ScanPayDAO scanPayDAO;

    private PayChannel channel = PayChannel.WX_SCAN;
    private String out_trade_no = "LOT10316C100215171018190953001";
    private int ownerId = 15;
    
    
    @Test
    public void payTest1(){
    	
    	ScanPay s = new ScanPay();
    	s.setMerchantCode("XJKJO");
    	s.setTerminal_id("TER121212121");
    	s.setAuth_code("280000649952841881");
    	s.setOrderCode("ORDER1234578656");
    	s.setSubject("desc");
    	s.setTotal_amount(new BigDecimal(1));
    	s.setDeviceIp("127.0.0.1");
    	s.setOut_trade_no("PAY00000000000002");
System.out.println("ScanPay = " + Json.toJson(s));    	
    	ScanPayTradeResult offlineScanPay = scanPayRemoteService.offlineScanPay(s);
System.out.println("offlineScanPay = " + Json.toJson(offlineScanPay));    	
    }
    
    
    @Test
    public void payTest2() throws Exception{
//    	ScanPayTradeResult result = OfflinePayClient
//				.createPayClient()
//				.queryPayBill("http://111.230.109.49/payplatform-web/api/scanCode/queryServer",
//						"XJKJO", "PAY171213141425121087");
    	ScanPayTradeResult offlineScanPay = scanPayRemoteService.getOfflineScanPayResult("XJKJO", "PAY1224554183");
System.out.println("offlineScanPay = " + Json.toJson(offlineScanPay));    	
    }
    
    
    
    @Test
    public void payTest3() throws Exception{
    	
    	ScanPayRefundResult revokePayBill = OfflinePayClient.createPayClient()
    	.revokePayBill(
    			"http://111.230.109.49/payplatform-web/api/scanCode/revokeServer", "XJKJO", "PAY00000000000002");
    	System.out.println(Json.toJson(revokePayBill));
    }
    
    @Test
    public void payTest4() throws Exception{
    	ScanPayRefundResult RES = scanPayRemoteService.offlineRefundScanPayBill("PAY00000000000002", "R000000000000002", new BigDecimal(0.01));
    	System.out.println("JSON = " + Json.toJson(RES));
    }
    
    
    
    @Test
    public void refundTest() throws Exception{
    	
    	String payBillCode = "PAY00000000008";
    	String refundCode = "00000000000001";
    	
    	ScanPayPO scanPayPO = scanPayDAO.get(payBillCode);
    	ScanRefund refund = new ScanRefund();
    	refund.setCode(refundCode);
    	refund.setRefundAmount(new BigDecimal(0.01));
    	ScanPayRefundResult revokePayBill = OfflinePayClient.createPayClient()
    			.refund("http://111.230.109.49/payplatform-web/api/scanCode/refundServer", 
    					scanPayPO, refund);
    	System.out.println("data = " + Json.toJson(revokePayBill));
    }
    
}
