package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.consts.RetailDefaultConst;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/2/2.
 */
public class FinanceSearchDTO implements Serializable {

    private static final long serialVersionUID = 7788952627776823649L;
    //单号
    private String orderCode;
    //订单类型 0：线上 1：线下 2 扫码购
    private Integer orderType;
    private String storeCode;
    private String storeName;
    private String groupCode;
    private String companyCode;
    //业务类型： 欧亚到家、全球购、扫码购
    private String businessType;
    //支付渠道： 微商城、app、扫码购
    private String tradeChannel;

    //支付方式
    private Integer payType;
    //账期类型：“入账” “出账”
    private String type;

    private Date beginTime;
    // 结束时间
    private Date endTime;
    /**
     * 页码
     */
    private Integer pageNo = 1;
    /**
     * 记录数
     */
    private Integer pageSize = RetailDefaultConst.ADMIN_PAGE_SIZE;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTradeChannel() {
        return tradeChannel;
    }

    public void setTradeChannel(String tradeChannel) {
        this.tradeChannel = tradeChannel;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

