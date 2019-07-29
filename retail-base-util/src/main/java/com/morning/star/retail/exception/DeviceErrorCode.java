/**
 * 描述
 *
 * @name OpBizErrorCode.java
 * @copyright Copyright by fenqile.com
 * @author Paul
 * @version 2016年8月23日
 **/
package com.morning.star.retail.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;

import com.morning.star.retail.enums.RetailBaseErrorCode;

/**
 * 新零售设备错误代码2200~2299
 *
 * @author zhouwen
 */
public enum DeviceErrorCode implements RetailBaseErrorCode {

    /** 通用系统级 **/
    DEVICE_IS_NULL(2202, "未找到设备信息"),
    DEVICE_CANNOT_UNBIND(2207, "该设备处于非绑定状态，不能进行解绑设备操作"),
    DEVICE_IS_UNACTIVATE(2208, "该设备未激活"),
    DEVICE_IS_LOCKED(2210, "该设备已锁定"),
    DEVICE_IS_BINDED(2213, "该设备已绑定其他秘钥"),
    DEVICE_STORE_ERROR(2216, "该秘钥不属于当前门店"),
    KEY_IS_BINDED(2217, "该秘钥已绑定其他设备"),
    KEY_DEVICE_BINDED(2219, "该秘钥已绑定当前设备"),
    KEY_EXPIRED(2226, "秘钥已过期")
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
	DeviceErrorCode(int code, String msg) {
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
