package com.morning.star.retail.msg.service;

import com.morning.star.retail.msg.dto.WxMsg;
import com.morning.star.retail.msg.dto.WxMsgResponse;

public interface WxMsgService {

	/**
	 * 通过微信公众号发送模板消息
	 * 
	 * @param userId	消息接收者userId
	 * @param msg		消息内容，需要传WxMsg子类的对象，如WxMsgOrderPayMsg、WxRefundMsg
	 * @param jumpUrl	点击消息之后的跳转链接
	 * @return
	 */
	public WxMsgResponse sendTemplateMsg(long userId, WxMsg msg, String jumpUrl);
}
