package com.morning.star.retail.stock.controller;

import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;

/**
 * controller基类
 *
 * @author jiangyf
 */
public class BaseController {

    /**
     * 入参异常
     */
    protected void paramsError() {
    	throw new IllegalArgumentException("入参异常");
    }

    /**
     * 入参异常
     */
    protected void paramsError(String errorMsg) {
    	throw new IllegalArgumentException(errorMsg + "入参异常");
    }

    /**
     * 返回成功结果
     *
     * @return
     */
    protected WebJsonBean success() {
        return new WebJsonBean(CODE.SUCCESS);
    }

    /**
     * 返回成功结果
     *
     * @param data 响应数据
     * @return
     */
    protected WebJsonBean success(Object data) {
        return new WebJsonBean(CODE.SUCCESS, data);
    }

    /**
     * 返回失败结果
     *
     * @return
     */
    protected WebJsonBean fail() {
        return new WebJsonBean(CODE.FAIL);
    }

    /**
     * 返回失败结果
     *
     * @param data 响应数据
     * @return
     */
    protected WebJsonBean fail(Object data) {
        return new WebJsonBean(CODE.FAIL, data);
    }

    /**
     * 失败结果
     *
     * @param data
     * @return
     */
    protected WebJsonBean fail(CODE data) {
        return new WebJsonBean(data);
    }

}
