package com.morning.star.retail.admin.group.order.controller.command;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by liangguobin on 2017/5/18.
 */
public class QueryAfterSalesCommand implements Serializable{

	private static final long serialVersionUID = -5859775385672290615L;

    @ApiModelProperty(value = "售后单编码")
    private String afterSalesOrderCode;

    @ApiModelProperty(value = "状态")
	private Integer status;

    @ApiModelProperty(value = "门店名称")
	private String storeName;

    @ApiModelProperty(value = "门店编码")
	private String storeCode;

    @ApiModelProperty(value = "订单编码")
    private String orderCode;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    @ApiModelProperty(value = "申请结束时间")
    private Date endApplyTime;
    @ApiModelProperty(value = "集团编码")
    private String groupCode;
//    private String companyCode;
    private Integer pageNo = 1;
    private Integer pageSize = 20;

    @ApiModelProperty(value = "下单人名称")
    private String buyerName;
    @ApiModelProperty(value = "下单人联系方式")
    private String buyerPhone;

    public String getAfterSalesOrderCode() {
        return afterSalesOrderCode;
    }

    public void setAfterSalesOrderCode(String afterSalesOrderCode) {
        this.afterSalesOrderCode = afterSalesOrderCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(Date endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }
}
