package com.morning.star.retail.enums;

/**
 * 新零售基础错误代码
 *
 * @author zhouwen
 */
public interface RetailBaseErrorCode {

    /**
     * 错误编码
     *
     * @return
     */
    int getErrorCode();

    /**
     * 错误描述
     *
     * @return
     */
    String getErrorMsg();

}
