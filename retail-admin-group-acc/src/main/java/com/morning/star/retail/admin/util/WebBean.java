package com.morning.star.retail.admin.util;

import com.morning.star.log.LogContext;
import com.morning.star.retail.exception.CODE;

/**
 * 吐出到前端并序列化为json的bean
 *
 * @author nick
 */
public class WebBean<T> {

	/**
	 * 返回码
	 */
	private int code;
	/**
	 * 说明
	 */
	private String desc;
	/**
	 * 获取上下文requestId
	 */
	private String tid = LogContext.getRequestId();
	/**
	 * 返回数据
	 */
	private T data;

	public WebBean() {
	}

	public WebBean(CODE code) {
		this(code.getIndex(), code.getMsg());
	}

	public WebBean(int code, String desc) {
		this(code, desc, null);
	}

	public WebBean(CODE code, T data) {
		this(code.getIndex(), code.getMsg(), data);
	}

	public WebBean(int code, String desc, T data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public static <T> WebBean<T> ok(T data) {
		WebBean<T> result = new WebBean<T>();
		result.setCode(CODE.SUCCESS.getIndex());
		result.setDesc("SUCCESS");
		result.setData(data);
		return result;
	}

	public static <T> WebBean<T> ok() {
		WebBean<T> result = new WebBean<T>();
		result.setCode(CODE.SUCCESS.getIndex());
		result.setDesc("SUCCESS");
		return result;
	}

	public static <T> WebBean<T> fail(T data) {
		WebBean<T> result = new WebBean<T>();
		result.setCode(CODE.FAIL.getIndex());
		result.setDesc("FAIL");
		result.setData(data);
		return result;
	}

	public static <T> WebBean<T> fail() {
		WebBean<T> result = new WebBean<T>();
		result.setCode(CODE.FAIL.getIndex());
		result.setDesc("FAIL");
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}