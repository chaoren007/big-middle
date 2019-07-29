package com.morning.star.retail.msg.dto;

import com.morning.star.retail.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单支付成功通知
 * 
 * 为了方便将对象直接转换为微信所需的json，对象属性名与json字段名一致，
 * 可直接使用第一个构造函数
 */
public class WxOrderPayMsg implements WxMsg, Serializable {
	private static final long serialVersionUID = -3414583435472735926L;

	private WxMsgParamVo first = new WxMsgParamVo();	// 第一行
	private WxMsgParamVo keyword1 = new WxMsgParamVo();	// 订单编号
	private WxMsgParamVo keyword2 = new WxMsgParamVo();	// 订单商品
	private WxMsgParamVo keyword3 = new WxMsgParamVo();	// 支付金额
	private WxMsgParamVo keyword4 = new WxMsgParamVo();	// 支付时间	
	private WxMsgParamVo remark = new WxMsgParamVo();	// 备注
	
	public WxOrderPayMsg(String first, String orderNo, String itemName, 
			String orderFee, Date payTime, String remark) {
		this.first.setValue(first);
		this.keyword1.setValue(orderNo);
		this.keyword2.setValue(itemName);
		this.keyword3.setValue(orderFee);
		this.keyword4.setValue(DateUtil.toString(payTime));
		this.remark.setValue(remark);
	}

	public WxOrderPayMsg(String first, String orderNo, String itemName, 
			String orderFee, Date payTime, String remark, String colorCode) {
		this.first.setValue(first);
		this.first.setColor(colorCode);

		this.keyword1.setValue(orderNo);
		this.keyword1.setColor(colorCode);

		this.keyword2.setValue(itemName);
		this.keyword2.setColor(colorCode);

		this.keyword3.setValue(orderFee);
		this.keyword3.setColor(colorCode);

		this.keyword4.setValue(DateUtil.toString(payTime));
		this.keyword4.setColor(colorCode);

		this.remark.setValue(remark);
		this.remark.setColor(colorCode);
	}

	public WxOrderPayMsg(WxMsgParamVo first, WxMsgParamVo orderNo, WxMsgParamVo itemName, 
			WxMsgParamVo orderFee, WxMsgParamVo payTime, WxMsgParamVo remark) {
		this.first = first;
		this.keyword1 = orderNo;
		this.keyword2 = itemName;
		this.keyword3 = orderFee;
		this.keyword4 = payTime;
		this.remark = remark;
	}
	
	public WxOrderPayMsg() {
	}

	public WxMsgParamVo getFirst() {
		return first;
	}

	public void setFirst(WxMsgParamVo first) {
		this.first = first;
	}

	public WxMsgParamVo getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(WxMsgParamVo keyword1) {
		this.keyword1 = keyword1;
	}

	public WxMsgParamVo getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(WxMsgParamVo keyword2) {
		this.keyword2 = keyword2;
	}

	public WxMsgParamVo getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(WxMsgParamVo keyword3) {
		this.keyword3 = keyword3;
	}

	public WxMsgParamVo getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(WxMsgParamVo keyword4) {
		this.keyword4 = keyword4;
	}

	public WxMsgParamVo getRemark() {
		return remark;
	}

	public void setRemark(WxMsgParamVo remark) {
		this.remark = remark;
	}

}

//////////////////////////////////////////////////
// 订单支付成功通知

// {{first.DATA}}
// 订单编号：{{keyword1.DATA}}
// 订单商品：{{keyword2.DATA}}
// 支付金额：{{keyword3.DATA}}
// 支付时间：{{keyword4.DATA}}
// {{remark.DATA}}

// 您的订单支付成功。
// 订单编号：123456789012
// 订单商品：宫保鸡丁，酸汤肥牛
// 支付金额：48元
// 支付时间：2015年1月27日 11:28
// 菜品预计半小时内送达，请注意查收。谢谢。
//////////////////////////////////////////////////
