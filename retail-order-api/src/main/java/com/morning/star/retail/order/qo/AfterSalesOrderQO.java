package com.morning.star.retail.order.qo;

import java.io.Serializable;
import java.util.Date;

public class AfterSalesOrderQO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1409298324179352753L;

	
	private long id;
	
	private Integer status;
	private String storeName;
	private String storeCode;
    private String afterSalesOrderCode;
    private String orderCode;
    private Date applyTime;   				// 申请时间
    private Date endApplyTime;				//申请结束时间
	private String groupCode;
//    private String companyCode;
    private Integer pageNo;
    private Integer pageSize;
    
    private String buyerName;
    private String buyerPhone;
    
    
    
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public String getAfterSalesOrderCode() {
		return afterSalesOrderCode;
	}

	public void setAfterSalesOrderCode(String afterSalesOrderCode) {
		this.afterSalesOrderCode = afterSalesOrderCode;
	}

	@Override
	public String toString() {
		return "AfterSalesOrderQO{" +
				"id=" + id +
				", status=" + status +
				", storeName='" + storeName + '\'' +
				", storeCode='" + storeCode + '\'' +
				", afterSalesOrderCode='" + afterSalesOrderCode + '\'' +
				", orderCode='" + orderCode + '\'' +
				", applyTime=" + applyTime +
				", endApplyTime=" + endApplyTime +
				", groupCode='" + groupCode + '\'' +
				", pageNo=" + pageNo +
				", pageSize=" + pageSize +
				", buyerName='" + buyerName + '\'' +
				", buyerPhone='" + buyerPhone + '\'' +
				'}';
	}
}
