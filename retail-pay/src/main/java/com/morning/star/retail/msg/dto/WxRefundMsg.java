package com.morning.star.retail.msg.dto;

import java.io.Serializable;

/**
 * 退款结果通知
 *
 * 为了方便将对象直接转换为微信所需的json，对象属性名与json字段名一致，
 * 可直接使用第一个构造函数
 */
public class WxRefundMsg implements WxMsg, Serializable {
	private static final long serialVersionUID = -4762752080121727266L;

	private WxMsgParamVo first = new WxMsgParamVo();		// 第一行
	private WxMsgParamVo storeName = new WxMsgParamVo();	// 店铺名称
	private WxMsgParamVo orderId = new WxMsgParamVo();	// 订单编号
	private WxMsgParamVo orderType = new WxMsgParamVo();	// 订单类型
	private WxMsgParamVo remark = new WxMsgParamVo();	// 备注
	
	public WxRefundMsg(String first, String storeName, String orderId, String orderType, String remark) {
		this.first.setValue(first);
		this.storeName.setValue(storeName);
		this.orderId.setValue(orderId);
		this.orderType.setValue(orderType);
		this.remark.setValue(remark);
	}

	public WxRefundMsg(String first, String storeName, String orderId, String orderType, 
			String remark, String colorCode) {
		this.first.setValue(first);
		this.first.setColor(colorCode);

		this.storeName.setValue(storeName);
		this.storeName.setColor(colorCode);

		this.orderId.setValue(orderId);
		this.orderId.setColor(colorCode);

		this.orderType.setValue(orderType);
		this.orderType.setColor(colorCode);

		this.remark.setValue(remark);
		this.remark.setColor(colorCode);
	}

	public WxRefundMsg(WxMsgParamVo first, WxMsgParamVo storeName, 
			WxMsgParamVo orderId, WxMsgParamVo orderType, WxMsgParamVo remark) {
		this.first = first;
		this.storeName = storeName;
		this.orderId = orderId;
		this.orderType = orderType;
		this.remark = remark;
	}
	
	public WxRefundMsg() {
	}

	public WxMsgParamVo getFirst() {
		return first;
	}

	public void setFirst(WxMsgParamVo first) {
		this.first = first;
	}

	public WxMsgParamVo getStoreName() {
		return storeName;
	}

	public void setStoreName(WxMsgParamVo storeName) {
		this.storeName = storeName;
	}

	public WxMsgParamVo getOrderId() {
		return orderId;
	}

	public void setOrderId(WxMsgParamVo orderId) {
		this.orderId = orderId;
	}

	public WxMsgParamVo getOrderType() {
		return orderType;
	}

	public void setOrderType(WxMsgParamVo orderType) {
		this.orderType = orderType;
	}

	public WxMsgParamVo getRemark() {
		return remark;
	}

	public void setRemark(WxMsgParamVo remark) {
		this.remark = remark;
	}

}

//////////////////////////////////////////////////
// 退款结果通知

//{{first.DATA}}
//
//店铺名称：{{storeName.DATA}} 
//订单编号：{{orderId.DATA}}
//订单类型：{{orderType.DATA}}
//{{remark.DATA}}

//您好，您的订单1002 已退款成功。再次欢迎您的光临。
//
//店铺名称：示例餐厅 
//订单编号：1002
//订单类型：外卖
//订单金额：100.00元
//////////////////////////////////////////////////
