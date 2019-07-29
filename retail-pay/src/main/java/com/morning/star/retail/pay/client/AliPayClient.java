package com.morning.star.retail.pay.client;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.util.Json;

public class AliPayClient implements PayClient {
	private Logger log = LoggerFactory.getLogger(AliPayClient.class);
	
	private AlipayClient alipayClient;

//	private StatusTree statusTree = AliStatusTree.load();
	
	
	public AliPayClient(AlipayClient alipayClient) {
	    this.alipayClient = alipayClient;
	}
	

    @Override
    public ScanPayTradeResult scanPay(ScanPay payOrder) {
        AlipayTradePayRequest request = new AlipayTradePayRequest(); //创建API对应的request类
        String json = "{" +
                "\"out_trade_no\":\""+payOrder.getOut_trade_no()+"\"," +
                "\"scene\":\"bar_code\"," +
                "\"auth_code\":\""+payOrder.getAuth_code()+"\"," +
                "\"subject\":\""+payOrder.getSubject()+"\"," +
                "\"terminal_id\":\""+payOrder.getTerminal_id()+"\"," +
                "\"timeout_express\":\"" + payOrder.getPay_timeout() + "\"," +
                "\"total_amount\":\""+changeTotalFee(payOrder.getTotal_amount())+"\"" +
                "}";
        request.setBizContent(json); //设置业务参数
        
        try {
            log.info("========== 请求支付宝扫码支付前的参数 ： " + json);
            AlipayTradePayResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
//            System.out.println(response.getBody());
            log.info("========== 支付宝扫码支付的返回的参数 ： " + response.isSuccess() + "," + response.getBody());// 根据response中的结果继续业务逻辑处理
            return getScanPayResultFrom(response);
        } catch (AlipayApiException e) {
            log.error("请求支付宝扫码支付异常：{}",e.getMessage());
            return ScanPayTradeResult.error();
        } 
       
    }
	
    private ScanPayTradeResult getScanPayResultFrom(AlipayTradePayResponse response) {
        JsonNode json = Json.toJsonNode(response.getBody());
        JsonNode payResp = json.get("alipay_trade_pay_response");
        int code = payResp.get("code").asInt();
        if(code == 10000) {
            ScanPayTradeResult result = ScanPayTradeResult.succ();
            result.setTrade_no(payResp.get("trade_no").asText());
            result.setOut_trade_no(payResp.get("out_trade_no").asText());
            result.setTotal_amount(new BigDecimal(payResp.get("total_amount").asText()).multiply(BigDecimal.valueOf(100)));
            return result;
        } else if(code == 40004 || code == 20001 || code == 40001 || code == 40002 || code ==  40006) {
            return payResp.get("sub_msg") == null ? ScanPayTradeResult.fail() : ScanPayTradeResult.fail(payResp.get("sub_msg").asText());
        } else if(code == 10003) {
            return ScanPayTradeResult.waiting();
        }
        return payResp.get("sub_msg") == null ? ScanPayTradeResult.error() : ScanPayTradeResult.error(payResp.get("sub_msg").asText());
    }

    @Override
    public ScanPayTradeResult queryPayResult(String out_trade_no) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        String json = "{" +
                "    \"out_trade_no\":\""+out_trade_no+"\"" +
                "  }";
        request.setBizContent(json);
        try {
            log.info("========== 查询支付宝支付结果的请求参数 ： " + json);
            AlipayTradeQueryResponse response = alipayClient.execute(request);
//            System.out.println("====" + response.getBody());
            log.info("========== 查询支付宝支付结果的返回参数 ： " + response.isSuccess() + "," + response.getBody());
            return getScanPayResultFrom(response);
        } catch (AlipayApiException e) {
            log.error("查询支付宝支付结果异常：{}",e.getMessage());
            return ScanPayTradeResult.error();
        }
    }

    private ScanPayTradeResult getScanPayResultFrom(AlipayTradeQueryResponse response) {
        JsonNode json = Json.toJsonNode(response.getBody());
        JsonNode payResp = json.get("alipay_trade_query_response");
        int code = payResp.get("code").asInt();
        if(code == 10000) {
            String trade_status = payResp.get("trade_status").asText();
            if("WAIT_BUYER_PAY".equals(trade_status)) {
                return ScanPayTradeResult.waiting();
            } else if("TRADE_CLOSED".equals(trade_status)) {
                return ScanPayTradeResult.fail();
            }
            ScanPayTradeResult result = ScanPayTradeResult.succ();
            result.setTrade_no(payResp.get("trade_no").asText());
            result.setOut_trade_no(payResp.get("out_trade_no").asText());
            result.setTotal_amount(new BigDecimal(payResp.get("total_amount").asText()).multiply(BigDecimal.valueOf(100)));
            return result;
        } else if(code == 40004 || code == 20000 || code == 40001 || code == 40002 || code ==  40006) {
            return payResp.get("sub_msg") == null ? ScanPayTradeResult.fail() : ScanPayTradeResult.fail(payResp.get("sub_msg").asText());
        } else if(code == 10003) {
            return ScanPayTradeResult.waiting();
        }
        return payResp.get("sub_msg") == null ? ScanPayTradeResult.error() : ScanPayTradeResult.error(payResp.get("sub_msg").asText());
    }

    @Override
    public ScanPayRefundResult cancelPay(String out_trade_no) {
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\""+out_trade_no+"\"" +
                "  }");
        try {
            AlipayTradeCancelResponse response = alipayClient.execute(request);
            log.info("撤销支付宝支付的返回的参数 ： " + response.getBody());// 根据response中的结果继续业务逻辑处理
            return getCancelScanPayResultFrom(response);
        } catch (AlipayApiException e) {
            log.error("撤销支付宝支付结果异常：{}",e.getMessage());
            return ScanPayRefundResult.error();
        }
    }


    private ScanPayRefundResult getCancelScanPayResultFrom(AlipayTradeCancelResponse response) {
        JsonNode json = Json.toJsonNode(response.getBody());
        JsonNode payResp = json.get("alipay_trade_cancel_response");
        int code = payResp.get("code").asInt();
        if(code == 10000) {
            return ScanPayRefundResult.succ();
        } else if(code == 40004 || code == 20000 || code == 40001 || code == 40002 || code ==  40006) {
            return ScanPayRefundResult.fail();
        }
        return ScanPayRefundResult.error();
    }


	/**
	 * 转化订单金额为标准格式
	 * 
	 * @param realvalue
	 * @return
	 */
	public String changeTotalFee(BigDecimal fee) {
	    String total_fee = String.valueOf(fee.intValue());
		if (total_fee.length() < 3) {
			if (total_fee.length() == 1) {
				total_fee = "0.0" + total_fee;
			} else {
				total_fee = "0." + total_fee;
			}
		} else {
			int idx = total_fee.length() - 2;
			String s = total_fee.substring(0, idx);
			String e = total_fee.substring(idx);
			total_fee = s + "." + e;
		}
		return total_fee;
	}
	
}
