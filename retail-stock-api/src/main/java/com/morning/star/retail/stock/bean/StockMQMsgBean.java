package com.morning.star.retail.stock.bean;

import java.io.Serializable;

/**
 * 库存消息队列服务消息
 * 
 * @author jiangyf
 * @date 2017年9月12日 下午4:09:16
 */
public class StockMQMsgBean<T> implements Serializable {
	private static final long serialVersionUID = 8510211560560726202L;

	/**
	 * 调用服务名称
	 */
	private String action;

	/**
	 * 调用服务入参
	 */
	private T body;

	public StockMQMsgBean() {
	}

	public StockMQMsgBean(String action, T body) {
		this.action = action;
		this.body = body;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
