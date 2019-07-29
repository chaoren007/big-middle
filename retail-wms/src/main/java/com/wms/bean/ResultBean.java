package com.wms.bean;

/**
 * @Author: kimhuhg
 * @Date: 18-11-22 上午10:24
 * @desc:
 */
public class ResultBean {
    private String msg;
    private Integer status;
    private String result;

    public ResultBean(String msg, Integer status, String result) {
        this.msg = msg;
        this.status = status;
        this.result = result;
    }

    public static ResultBean failBuilder(String msg) {
        return new ResultBean(msg, 0, msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
