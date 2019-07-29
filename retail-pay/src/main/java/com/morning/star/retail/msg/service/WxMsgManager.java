package com.morning.star.retail.msg.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.morning.star.retail.msg.dto.WxOrderPayMsg;
import com.morning.star.retail.msg.dto.WxRefundMsg;
import com.morning.star.retail.pay.utils.HttpClientUtil;

import net.sf.json.JSONObject;

public class WxMsgManager {
	
	private static Logger logger = LoggerFactory.getLogger(WxMsgManager.class);

	public static String b2cWxParamUrl = "http://m.freshlife51.com/newhope-user/api/users/getAccessToken";
	public static String wxTemplateMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	public static String wxMsgEncoding = "ISO-8859-1";
	
	private static Map<Class<?>, String> wxTemplateMsgIdMap = new HashMap<>();
	static {
		wxTemplateMsgIdMap.put(WxOrderPayMsg.class, "hLL4C0qb9JAR-rmPdjMm6576oaipVaM4jEOM8xbzsuQ");	// 订单支付成功通知
		wxTemplateMsgIdMap.put(WxRefundMsg.class, "EoYe8N7GxEsrheJrDaiVJgZKE_8xPSrzNTmxVlxmg1Q");	// 退款结果通知
	}
	
	public static String getTemplateId(Class<?> wxMsgClazz) {
		return wxTemplateMsgIdMap.get(wxMsgClazz);
	}
	
	public static Map<String, String> getReqParam(long userId) {
		String fullurl;
		if (b2cWxParamUrl.indexOf('?') >= 0) {
			fullurl = b2cWxParamUrl + "&userId=" + userId;
		}
		else {
			fullurl = b2cWxParamUrl + "?userId=" + userId;
		}
		
		String respStr = null;
		Exception exception = null;
		try {
			logger.debug("请求openId/accessToken：requestUrl: [{}]", fullurl);
			respStr = HttpClientUtil.get(fullurl);
			logger.debug("请求openId/accessToken：response: [{}]", respStr);

			JSONObject respJson = JSONObject.fromObject(respStr);
			if (respJson.containsKey("data")) {
				JSONObject dataJson = respJson.getJSONObject("data");
				String openId = dataJson.getString("openid");
				String accessToken = dataJson.getString("accessToken");
				
				if (!StringUtils.isEmpty(openId) && !"null".equalsIgnoreCase(openId) && 
						!StringUtils.isEmpty(accessToken) && !"null".equalsIgnoreCase(accessToken)) {
					Map<String, String> reqParams = new HashMap<>();
					reqParams.put("openId", openId);
					reqParams.put("accessToken", accessToken);
					return reqParams;
				}
			}
		}
		catch (Exception ex) {
			exception = ex;
		}

		logger.error("通过B2C获取openId/accessToken失败，响应：{}，异常：{}", respStr, exception);
		return null;
	}

}
