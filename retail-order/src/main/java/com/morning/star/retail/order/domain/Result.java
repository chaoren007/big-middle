package com.morning.star.retail.order.domain;

import com.morning.star.log.LogContext;

/**
 * 吐出到前端并序列化为json的bean
 * @author nick
 */
public class Result<T> {

	/**返回码*/
	private int code;
	/**说明*/
	private String desc;
	/**获取上下文requestId*/
	private String tid = LogContext.getRequestId();
	/**返回数据*/
	private T data;
	
	public Result() {}

	public Result(int code, String desc, T data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public static Result success(Object data) {
		Result result = new Result();
		result.setCode(200);
		result.setDesc("SUCCESS");
		result.setData(data);
		return result;
	}

	public static Result success() {
		return success(null);
	}

	public static Result fail(int code, String desc) {
		Result result = new Result();
		result.setDesc(desc);
		result.setCode(code);
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