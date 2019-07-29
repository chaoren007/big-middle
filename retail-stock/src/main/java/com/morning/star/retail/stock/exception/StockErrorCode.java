/**
 * 描述
 *
 * @name OpBizErrorCode.java
 * @copyright Copyright by fenqile.com
 * @author Paul
 * @version 2016年8月23日
 **/
package com.morning.star.retail.stock.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;

import com.morning.star.retail.enums.RetailBaseErrorCode;
import com.morning.star.retail.exception.BizException;

/**
 * 新零库存错误代码 7000~7199
 *
 * @author zhouwen
 */
public enum StockErrorCode implements RetailBaseErrorCode {

    ONLINE_PRE_STOCK_DONE(70030, "该线上订单已完成预占库存，不能重复操作"),

    /**
     * 库存预占操作
     **/
    ONLINE_CHECK_PRE_STOCK_DONE(70051, "该线上订单已完成确认预占库存，不能重复操作"),
    ONLINE_CANCEL_PRE_STOCK_DONE(70052, "该线上订单已完成取消预占库存，不能重复操作"),
    ONLINE_FINISH_PRE_STOCK_DONE(70053, "该线上订单已完成结束预占库存，不能重复操作")
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
	StockErrorCode(int code, String msg) {
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
