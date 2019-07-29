package com.morning.star.retail.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;

import com.morning.star.retail.enums.RetailBaseErrorCode;

/**
 * 新零售 后台管理错误代码8000~8999
 * Created by liangguobin on 2017/5/16.
 */
public enum AdminErrorCode implements RetailBaseErrorCode {

    /**
     * 管理员登录密码错误
     **/
    ADMIN_INFO_ERROR(8000, "无效的用户名或密码");

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
	AdminErrorCode(int code, String msg) {
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
