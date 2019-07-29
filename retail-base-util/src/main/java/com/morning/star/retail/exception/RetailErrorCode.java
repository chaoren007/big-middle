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
 * 新零售公用错误代码 90603-91999
 * 
 * @author zhouwen
 */
public enum RetailErrorCode implements RetailBaseErrorCode {
	/**
	 * 对象转换异常
	 */
	OBJECT_CONVERT_ERROR(90604, "对象转换异常"),
	/**
	 * 上传文件失败
	 */
	UPLOAD_FILE_FAIL(90605, "上传文件失败"),
	/**
	 * 上传文件格式错误
	 */
	UPLOAD_FILE_FORMAT_ERROR(90606, "上传文件格式错误"),
	/**
	 * 上传文件内容错误
	 */
	UPLOAD_FILE_CONTENT_ERROR(90607, "上传文件内容错误"),
	/**
	 * 上传文件内容为空
	 */
	UPLOAD_FILE_CONTENT_EMPTY(90608, "上传文件内容为空"),

	/**
	 * 文件格式配置为空
	 */
	UPLOAD_FILE_VALUEMAP_EMPTY(90609, "文件格式配置为空"),

	/**
	 * 文件格式头部长度异常
	 */
	UPLOAD_FILE_HEADSIZE_ERROR(90610, "文件格式头部长度异常{0}"),

	/**
	 * 批量导入masterId配置异常
	 */
	UPLOAD_FILE_MASTERID_ERROR(90611, "批量导入masterId配置异常"),

	/**
	 * 文件格式头部异常
	 */
	UPLOAD_FILE_HEAD_ERROR(90612, "文件格式头部异常 {0} - {1}"),

	/**
	 * 导出Excel文件失败
	 */
	EXPORT_EXCEL_ERROR(90620, "导出Excel数据失败"),

	/**
	 * 其他shiro异常:{0}
	 */
	OTHER_SHIRO_ERROR(90999, "其他shiro异常:{0}");

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
	RetailErrorCode(int code, String msg) {
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
