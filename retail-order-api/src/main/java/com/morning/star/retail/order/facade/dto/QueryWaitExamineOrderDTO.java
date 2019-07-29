package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.consts.RetailDefaultConst;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by liangguobin on 2017/5/26.
 */
public class QueryWaitExamineOrderDTO implements Serializable {

    private static final long serialVersionUID = -5577574053609931436L;

    /**
     * 查询页码
     */
    private Integer pageNo;

    /**
     * 查询每页数量
     */
    private Integer pageSize;

    /**
     * 查询关键
     */
    @ApiModelProperty(value = "查询关键字")
    private String keyWord;

    /**
     * 查询状态
     */
    @ApiModelProperty(value = "查询状态")
    private Integer status;

    @ApiModelProperty(hidden = true)
    private String storeCode;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
