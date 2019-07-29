package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.Date;

public class StatementOrderSearchDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 8785519666139549693L;
	//账期单号
	private String statementCode;
	//集团编码
	private String groupCode;
	private String companyCode;

	private Integer status;

	private Date beginTime;
	// 账期结束时间
	private Date endTime;
	// 最近一次对账时间
	private Date lastAccountTime;
	
    private String storeCode;
    private String storeName;
    private String goodsName;
    private String goodsCode;
    //订单号
    private String orderCode;
    //退款单号
    private String refundCode;
    //结算对象
    private String settlementObject;
    //账期类型：“入账” “出账”
    private String type;
    
    private String upcCode;
    //货品规格
    private String goodsSpecInfo;
    //一级类目
    private Long categoryId1;
    //二级类目
    private Long categoryId2;
    //三级类目
    private Long categoryId3;
	//四级类目
	private Long categoryId4;
	//五级类目
	private Long categoryId5;
    //支付方式
    private Integer payChannel;
    //供应商
	private String supplierCode;
	private String supplierName;
	/**
	 * 页码
	 */
	private Integer pageNo;
	/**
	 * 记录数
	 */
	private Integer pageSize;
    
	/**
	 *开始行
	 */
	private Integer startNo;

	public String getStatementCode() {
		return statementCode;
	}

	public void setStatementCode(String statementCode) {
		this.statementCode = statementCode;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getLastAccountTime() {
		return lastAccountTime;
	}

	public void setLastAccountTime(Date lastAccountTime) {
		this.lastAccountTime = lastAccountTime;
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSettlementObject() {
		return settlementObject;
	}

	public void setSettlementObject(String settlementObject) {
		this.settlementObject = settlementObject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getGoodsSpecInfo() {
		return goodsSpecInfo;
	}

	public void setGoodsSpecInfo(String goodsSpecInfo) {
		this.goodsSpecInfo = goodsSpecInfo;
	}

	public Long getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Long categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public Long getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Long categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public Long getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Long categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getRefundCode() {
		return refundCode;
	}

	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getCategoryId4() {
		return categoryId4;
	}

	public void setCategoryId4(Long categoryId4) {
		this.categoryId4 = categoryId4;
	}

	public Long getCategoryId5() {
		return categoryId5;
	}

	public void setCategoryId5(Long categoryId5) {
		this.categoryId5 = categoryId5;
	}
}
