package com.morning.star.retail.stock.enums;

/**
 * 枚举对象
 * 
 * @author jiangyf
 * @date 2017年9月22日 下午5:02:31
 */
public class EnumObject {
	private String code;
	private String desc;

	public EnumObject() {
	}

	public EnumObject(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static EnumObject of(String code, String desc) {
		return new EnumObject(code, desc);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
