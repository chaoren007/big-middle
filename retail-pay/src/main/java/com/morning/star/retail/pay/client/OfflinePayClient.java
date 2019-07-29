package com.morning.star.retail.pay.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.msg.dto.OffineRefundReturn;
import com.morning.star.retail.msg.dto.OffineRevokeReturn;
import com.morning.star.retail.msg.dto.OfflinePayQueryReturn;
import com.morning.star.retail.msg.dto.OfflinePayRerturn;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.entity.ScanPayPO;
import com.morning.star.retail.pay.entity.ScanRefund;
import com.morning.star.retail.pay.enums.PayChannel;
import com.morning.star.retail.pay.enums.ScanPayStatus;
import com.morning.star.retail.pay.utils.OfflinePaySign;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.util.UniqueNoUtils;

/**
 * 聚合支付的客户端
 * @author Administrator
 *
 */
public class OfflinePayClient {

	private static final Logger logger = LoggerFactory.getLogger(OfflinePayClient.class);
	
	private static OfflinePayClient payClient;
	
	private HttpClient httpClient;

	public static CODE SUCCESS = new CODE(1000, "成功");


	/**
	 * 创建支付客户端
	 * @param offline_pay_url
	 * @return
	 */
	public static OfflinePayClient createPayClient() {
		if(payClient == null){
			synchronized (OfflinePayClient.class) {
				if(payClient == null){
					payClient = new OfflinePayClient(HttpClients.createDefault());
				}
			}
		}
		return payClient;
	}

	
	public ScanPayTradeResult payBill(String url, ScanPay scanPay) throws Exception{
		ScanPayTradeResult result = new ScanPayTradeResult();
		HttpPost httpPost = new HttpPost(url + formPayData(scanPay));
		HttpResponse response = httpClient.execute(httpPost);
		if(response.getStatusLine().getStatusCode() != 200){
			result.setCode(ScanPayStatus.WAITING);
			result.setMsg("需要轮询");
			result.setTotal_amount(scanPay.getTotal_amount());
			result.setOut_trade_no(scanPay.getOut_trade_no());
			return result;
		}
		String json = EntityUtils.toString(response.getEntity(),"UTF-8");
		WebJsonBean retData = Json.fromJson(json, WebJsonBean.class);
		if(retData.getCode() != CODE.SUCCESS.getIndex()){
			result.setCode(ScanPayStatus.FAIL);
			result.setMsg("支付失败(" + retData.getDesc() + ")");
			result.setOut_trade_no(scanPay.getOut_trade_no());
			result.setTotal_amount(scanPay.getTotal_amount());
			return result;
		}
		OfflinePayRerturn data = Json.fromJson(Json.toJson(retData.getData()), OfflinePayRerturn.class);
		logger.info("========OfflinePayRerturn========" + Json.toJson(data));
		if( !data.getStatus().equals("0")){  //status   0表示成功，非0表示失败此字段是通信标识，非交易标识  需要查询
			result.setCode(ScanPayStatus.WAITING);
			result.setMsg("通讯异常，需要轮询");
			result.setTotal_amount(scanPay.getTotal_amount());
			result.setOut_trade_no(scanPay.getOut_trade_no());
		} else{
			if(data.checkSucc()){
				result.setCode(ScanPayStatus.SUCC);
				result.setMsg("支付成功");
				result.setTrade_no(data.getTransaction_id());	//第三方的交易号
				result.setOut_trade_no(scanPay.getOut_trade_no());   //支付单号
				result.setTotal_amount(scanPay.getTotal_amount());	//支付金额
				result.setPayChannel(matchPayChannel(data.getTrade_type()));
			}else if(data.checkPaying()){		//系统直接返回支付中，需要查询
				result.setCode(ScanPayStatus.WAITING);
				result.setMsg(data.getErr_msg() + "(支付结果未知，需要轮询结果)");
				result.setTotal_amount(scanPay.getTotal_amount());
				result.setOut_trade_no(scanPay.getOut_trade_no());
			}else {
				result.setCode(ScanPayStatus.FAIL);
				result.setMsg("支付失败");
				result.setOut_trade_no(scanPay.getOut_trade_no());
				result.setTotal_amount(scanPay.getTotal_amount());
			}
			

			
		}
		
		return result;
	}
	
	
	
	/**
	 * 查询支付结果
	 * @param offline_pay_query_url
	 * @param merchantCode
	 * @param payBillCode
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public ScanPayTradeResult queryPayBill(String offline_pay_query_url, String merchantCode, String payBillCode) throws Exception {
		
		String url = offline_pay_query_url + "?merchantCode=" + merchantCode +"&tradeNo=" + payBillCode;
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = httpClient.execute(httpPost);
		ScanPayTradeResult result = new ScanPayTradeResult();
		if(response.getStatusLine().getStatusCode() != 200){
			result.setCode(ScanPayStatus.WAITING);
			result.setMsg("通讯异常，需要轮训");
			return result;
		}
		String json = EntityUtils.toString(response.getEntity(),"UTF-8");
		WebJsonBean retData = Json.fromJson(json, WebJsonBean.class);
		if(retData.getCode() != CODE.SUCCESS.getIndex()){
			throw new IllegalArgumentException("服务器异常");
		}
		OfflinePayQueryReturn data = Json.fromJson(Json.toJson(retData.getData()), OfflinePayQueryReturn.class);
		if(data.getStatus().equals("0") && data.getResult_code().equals("0") && data.getTrade_state().equals("SUCCESS")){
			result.setCode(ScanPayStatus.SUCC);
			result.setMsg("支付成功");
			result.setOut_trade_no(payBillCode);
			result.setPayChannel(matchPayChannel(data.getTrade_type()));
			result.setTotal_amount(new BigDecimal(data.getTotal_fee()));
			result.setTrade_no(data.getTransaction_id());
		} else if(data.getResult_code().equals("0") && data.getStatus().equals("0") && data.getTrade_state().equals("USERPAYING")){
			result.setCode(ScanPayStatus.WAITING);
			result.setMsg("等待用户支付");
			result.setOut_trade_no(payBillCode);
		} else{
			result.setCode(ScanPayStatus.FAIL);
			result.setMsg("支付失败，原因很多");
			result.setOut_trade_no(payBillCode);
		}
		
		return result;
	}
	
	
	/**
	 * 撤销聚合支付订单
	 * @param offline_pay_revoke_url
	 * @param merchantCode
	 * @param payBillCode
	 * @param uuid
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public ScanPayRefundResult revokePayBill(String offline_pay_revoke_url, String merchantCode, String payBillCode) throws Exception {
		
		String sign = OfflinePaySign.sign(merchantCode.substring(0,3), "&key=" + merchantCode+merchantCode.length(), "utf-8");
		
		String url = offline_pay_revoke_url + "?merchantCode=" + merchantCode + "&tradeNo=" 
												+ payBillCode + "&nonceStr=" + UniqueNoUtils.next() + "&sign=" + sign;
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = httpClient.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode != 200){
		    throw new IllegalArgumentException("服务器异常");
		}
		String json = EntityUtils.toString(response.getEntity(),"UTF-8");
		WebJsonBean retData = Json.fromJson(json, WebJsonBean.class);
		if(retData.getCode() != CODE.SUCCESS.getIndex()){
		    throw new IllegalArgumentException("服务器异常");
		}
		OffineRevokeReturn revokeRes = Json.fromJson(Json.toJson(retData.getData()),OffineRevokeReturn.class);
		if(revokeRes.getStatus() != null && revokeRes.getStatus().equals("0") && 
				revokeRes.getResult_code() != null && revokeRes.getResult_code().equals("0")){
			ScanPayRefundResult succ = ScanPayRefundResult.succ();
			succ.setTransactionId(revokeRes.getTransaction_id());
			return succ;
		}
		return ScanPayRefundResult.fail();
	}
	
	
	/**
	 * 退款
	 * @param offline_pay_refund_url
	 * @param po
	 * @param refund
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public ScanPayRefundResult refund(String offline_pay_refund_url, ScanPayPO pay, ScanRefund refund) throws Exception{
		String sign = OfflinePaySign.sign(
				pay.getMerchantCode().substring(0,3), 
				"&key=" + pay.getMerchantCode() +pay.getMerchantCode().length(), "utf-8");
		String url = 
					offline_pay_refund_url + 
					"?merchantCode=" + pay.getMerchantCode() + 
					"&tradeNo=" + pay.getOutTradeNo() + 
					"&outRefundNo=" + refund.getCode() + 
					"&totalFee=" + pay.getTotalAmount().intValue() + 
					"&refundFee=" + refund.getRefundAmount().multiply(new BigDecimal("100")).intValue() +
					"&nonceStr=" + refund.getCode() + 
					"&sign=" + sign;
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = httpClient.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode != 200){
		    throw new IllegalArgumentException("服务器异常");
		}
		String json = EntityUtils.toString(response.getEntity(),"UTF-8");
		WebJsonBean retData = Json.fromJson(json, WebJsonBean.class);
		if(retData.getCode() != CODE.SUCCESS.getIndex()){
		    throw new IllegalArgumentException("服务器异常");
		}
		OffineRefundReturn res = Json.fromJson(Json.toJson(retData.getData()), OffineRefundReturn.class);		
		if(res.getStatus() != null && res.getStatus().equals("0") && 
				res.getResult_code() != null && res.getResult_code().equals("0")){
			ScanPayRefundResult succ = ScanPayRefundResult.succ();
			succ.setTransactionId(res.getRefund_id());
			return succ;
		}
		return ScanPayRefundResult.fail();
	}
	
	
	
	
	/**
	 * 查询是否需要轮训结果
	 * @param data
	 * @return
	 */
	public boolean isNeedToQuery(OfflinePayRerturn data){
		String need_query = data.getNeed_query();
		String err_code = data.getErr_code();
		if(need_query.equals("Y") 
				|| err_code.equals("SYSTEMERROR")
				|| err_code.equals("Internal error")
				|| err_code.equals("BANKERROR")
				|| err_code.equals("10003")
				|| err_code.equals("USERPAYING")
				|| err_code.equals("System error")
				|| err_code.equals("aop.ACQ.SYSTEM_ERROR")
				|| err_code.equals("ACQ.SYSTEM_ERROR")){
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 匹配支付类型
	 * @param type
	 * @return
	 */
	private PayChannel matchPayChannel(String type){
		PayChannel payChannel = null;
		if(type.equals("ALIPAY")){
			payChannel = PayChannel.ALI_SCAN;
		}else if(type.equals("WX")){
			payChannel = PayChannel.WX_SCAN;
		}else if(type.equals("JDPAY")){
			payChannel = PayChannel.JDPAY;
		}else if(type.equals("QQPAY")){
			payChannel = PayChannel.QQPAY;
		}else if(type.equals("UNION")){
			payChannel = PayChannel.UNION;
		}else if(type.equals("YZF")){
			payChannel = PayChannel.YZF;
		}else{
			payChannel = PayChannel.UNKNOWN;
		}
		return payChannel;
	}
	
	
	/**封装请求的支付数据
	 *
	 * @param scanPay
	 * @return
	 * @throws Exception 
	 * @throws Exception 
	 */
	private String formPayData(ScanPay scanPay) throws Exception {
		String describe = URLEncoder.encode(scanPay.getSubject(), "UTF-8");
		String params = "?authCode="	 + scanPay.getAuth_code()    +
						"&tradeNo=" 	 + scanPay.getOut_trade_no()    +
						"&totalFee="     + scanPay.getTotal_amount().longValue() + 
						"&mchCreateIp="  + scanPay.getDeviceIp()     + 
						"&merchantCode=" + scanPay.getMerchantCode() + 
						"&deviceInfo="   + scanPay.getTerminal_id()  + 
						"&describe="     + describe      			 + 
						"&nonceStr=" 	 + scanPay.getOut_trade_no() +
						"&timeStart="	 + (scanPay.getPay_start_time() == null?"":scanPay.getPay_start_time())+
						"&timeExpire="	 + (scanPay.getPay_timeout() == null?"":scanPay.getPay_timeout());
		return params;
	}
	
	public OfflinePayClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}



	public HttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}










	
	
	
}
