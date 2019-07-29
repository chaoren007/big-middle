package com.morning.star.retail.validate;

import java.util.Map;

/**
 * 校验结果,包含错误编码，错误信息，以及错误描述
 * @author zhouwen
 *
 */
public class ValidationResult {
	public static final int SUCCESS = 0;
	public static final int FAIL = 400;

	/**
	 * 错误编码
	 */
	private int errorCode=SUCCESS;
	
	/**
	 * 错误信息
	 */
	private Map<String,String> errorMsg;

	/**
	 * 错误描述
	 * @return
	 */
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * 获取错误编码
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置错误代码
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ValidationResult [errorCode=" + errorCode + ", errorMsg="
				+ errorMsg + "]";
	}

}
