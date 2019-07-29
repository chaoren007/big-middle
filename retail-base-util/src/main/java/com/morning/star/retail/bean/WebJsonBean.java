package com.morning.star.retail.bean;

import com.morning.star.retail.exception.CODE;

/**
 * 吐出到前端并序列化为json的bean
 * @author nick
 */
public class WebJsonBean {

	/**返回码*/
	private int code;
	/**说明*/
	private String desc;
	/**获取上下文requestId*/
	private String tid = null;
	/**返回数据*/
	private Object data;
	
	public WebJsonBean() {}
	
	public WebJsonBean(CODE code) {
		this(code.getIndex(), code.getMsg());
	}
	
	public WebJsonBean(int code, String desc) {
		this(code, desc, null);
	}
	
	public WebJsonBean(CODE code, Object data) {
        this(code.getIndex(), code.getMsg(), data);
    }
	
	public WebJsonBean(int code, String desc, Object data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public static WebJsonBean success(Object data) {
		WebJsonBean result = new WebJsonBean();
		result.setCode(200);
		result.setDesc("SUCCESS");
		result.setData(data);
		return result;
	}

	public static WebJsonBean success() {
		WebJsonBean result = new WebJsonBean();
		result.setCode(200);
		result.setDesc("SUCCESS");
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}