package com.morning.star.retail.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;

import com.morning.star.retail.enums.RetailBaseErrorCode;

/**
 * 新零售 登录账户错误代码2500~2599
 * 
 * @author jianyf
 */
public enum LoginAccountErrorCode implements RetailBaseErrorCode {

	/** 登录账号不存在 **/
	LOGIN_ACCOUNT_NOT_EXIST(2501, "登录账号不存在"),
	/** 登录账号或密码错误 **/
	LOGIN_ACCOUNT_ERROR(2502, "登录账号或密码错误"),
	/** 登录账号已冻结 **/
	LOGIN_ACCOUNT_FREEZE(2503, "登录账号已冻结"),
	/** 登录账号已作废 **/
	LOGIN_ACCOUNT_DELETE(2504, "登录账号已作废"),
	/** 登录账号已失效 **/
	LOGIN_ACCOUNT_INVALID(2505, "用户登录信息失效，请重新登录"),
	/** 该平台仅限超级管理员登录 **/
	ONLY_ROOT_ADMIN_LOGIN(2508, "该平台仅限超级管理员登录"),
	/** 密码输入错误次数超限，请稍后登录 **/
	INPUT_PWD_OUT_LIMIT(2598, "密码输入错误次数超限，请稍后登录"),
	/** 退出登录失败 **/
	LOGOUT_FAILED(2599, "退出登录失败"),
	;

	/**
	 * 错误编码
	 */
	private int code;
	/**
	 * 错误描述
	 */
	private String msg;

	/**
	 * 错误代码基类
	 * 
	 * @param code
	 *            错误编码
	 * @param msg
	 *            错误描述
	 */
	LoginAccountErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 错误编码
	 * 
	 * @return
	 */
	public int getErrorCode() {
		return code;
	}

	/**
	 * 错误描述
	 * 
	 * @return
	 */
	public String getErrorMsg() {
		return msg;
	}
	
	public BizException build(Throwable e) {
        throw new BizException(getErrorCode(), getErrorMsg(), e);
    }
	
	/**
     * ( {code:1000, msg:"a{0}c{1}e{2}"}, "b", "d", "f" ) => {code:1000, msg:"abcdef"}
     * @param errorCode
     * @param paramObj
     * @return
     */
    public BizException build(Object... paramObj) {
    	throw new BizException(getErrorCode(), format(getErrorMsg(), paramObj));
    }
    
    /**
	 * 格式化错误信息
	 * @param formatStr
	 * @param paramObj
	 * @return
	 */
	private String format(String formatStr, Object... paramObj) {
        String msg = ObjectUtils.defaultIfNull(formatStr, "");
        try {
            if(paramObj != null && paramObj.length > 0) {
                msg = MessageFormat.format(msg, paramObj);
            }
        } catch (Exception e) {
        }
        return msg;
    }
}
