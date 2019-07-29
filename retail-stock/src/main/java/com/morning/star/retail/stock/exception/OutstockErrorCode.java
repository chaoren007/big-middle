package com.morning.star.retail.stock.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.ObjectUtils;

import com.morning.star.retail.enums.RetailBaseErrorCode;
import com.morning.star.retail.exception.BizException;

/**
 * 出库 7200-7299
 *
 * @author jiangyf
 */
public enum OutstockErrorCode implements RetailBaseErrorCode {

    OUTSTOCK_ORDER_CANNOT_AUDIT(7202, "该出库单处于非待审核状态，不能执行审核操作"),
    REAL_NUM_ERROR(7262, "该出库商品【商品编码：{0}】实际出库数量须大于0"),
    REALNUM_LARGE_THAN_REFUNDNUM(7264, "出库商品【商品编码：{0}】实际出库数量不能大于退货数量"),
    REALNUM_LARGE_THAN_RETURNABLENUM(7265, "出库商品【商品编码：{0}】实际出库数量不能大于对应入库单的可退数量"),
    REAL_NUM_NOT_ZERO(7266, "你的实际出库数量为0，请填写实际出库数量后再出库"),
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
	OutstockErrorCode(int code, String msg) {
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
