package com.morning.star.retail.msg.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.morning.star.retail.msg.dto.WxMsg;
import com.morning.star.retail.msg.dto.WxMsgRequest;
import com.morning.star.retail.msg.dto.WxMsgResponse;
import com.morning.star.retail.pay.utils.HttpClientUtil;

import net.sf.json.JSONObject;

@Service
public class WxMsgServiceImpl implements WxMsgService {
	
	private static Logger logger = LoggerFactory.getLogger(WxMsgService.class);

	@Override
	public WxMsgResponse sendTemplateMsg(long userId, WxMsg msg, String jumpUrl) {
		if (msg == null) {
			throw new IllegalArgumentException("微信公众号消息内容不能为空");
		}
		
		String templateId = WxMsgManager.getTemplateId(msg.getClass());
		if (templateId == null) {
			logger.warn("微信公众号发送模板消息失败，不支持的消息类型：{}", msg.getClass().getSimpleName());
			throw new IllegalArgumentException("不支持的模板消息类型");
		}
		
		Map<String, String> reqParam = WxMsgManager.getReqParam(userId);
		if (MapUtils.isEmpty(reqParam)) {
			logger.warn("微信公众号发送模板消息失败，无法从B2C获取accessToken和openId");
			return new WxMsgResponse(6017, "获取openId/accessToken失败");
		}
		
		String fullurl = WxMsgManager.wxTemplateMsgUrl + reqParam.get("accessToken");
		WxMsgRequest request = new WxMsgRequest();
		request.setTouser(reqParam.get("openId"));
		request.setTemplate_id(templateId);
		request.setData(msg);
		if (!StringUtils.isEmpty(jumpUrl)) {
			request.setUrl(jumpUrl);
		}
		
		String respStr = null;
		Exception exception = null;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("微信公众号发送模板消息：模板：{}，消息体：{}", 
						msg.getClass().getSimpleName(), JSONObject.fromObject(request));
			}

			respStr = HttpClientUtil.postJson(fullurl, 
					new String(JSONObject.fromObject(request).toString().getBytes("UTF-8"), WxMsgManager.wxMsgEncoding));
			if (!StringUtils.isEmpty(respStr)) {
				respStr = new String(respStr.getBytes(WxMsgManager.wxMsgEncoding), "UTF-8");
			}
			logger.debug("微信公众号发送模板消息：模板：{}，响应：{}", msg.getClass().getSimpleName(), respStr);

			WxMsgResponse response = (WxMsgResponse) JSONObject.toBean(JSONObject.fromObject(respStr), WxMsgResponse.class);
			logger.info("微信公众号发送模板消息，模板：{}，发送结果：{}/{}", 
					msg.getClass().getSimpleName(), response.getErrmsg(), response.getErrcode());
			return response;
		}
		catch (Exception ex) {
			exception = ex;
		}
		
		logger.error("微信公众号发送模板消息失败，模板：{}，响应：{}，异常：{}", 
				msg.getClass().getSimpleName(), respStr, exception);
		return null;
	}

}
