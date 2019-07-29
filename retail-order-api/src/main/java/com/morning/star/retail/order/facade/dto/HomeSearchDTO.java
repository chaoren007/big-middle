package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/1/26.
 */
public class HomeSearchDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "畅销商品的数量")
    private Integer topNum;

    @ApiModelProperty(value = "排序字段")
    private String orderFiled;

    @ApiModelProperty(value = "畅销商品排序")
    private Boolean orderBySaleNumAsc;

    @ApiModelProperty(value = "是否二级分类")
    private Boolean isSecondCategory;

    @ApiModelProperty(value = "年份")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    private Integer pageNo;

    private Integer pageSize;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public Integer getTopNum() {
        return topNum;
    }

    public void setTopNum(Integer topNum) {
        this.topNum = topNum;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getOrderFiled() {
        return orderFiled;
    }

    public void setOrderFiled(String orderFiled) {
        this.orderFiled = orderFiled;
    }

    public Boolean getOrderBySaleNumAsc() {
        return orderBySaleNumAsc;
    }

    public void setOrderBySaleNumAsc(Boolean orderBySaleNumAsc) {
        this.orderBySaleNumAsc = orderBySaleNumAsc;
    }

    public Boolean getSecondCategory() {
        return isSecondCategory;
    }

    public void setSecondCategory(Boolean secondCategory) {
        isSecondCategory = secondCategory;
    }
}
