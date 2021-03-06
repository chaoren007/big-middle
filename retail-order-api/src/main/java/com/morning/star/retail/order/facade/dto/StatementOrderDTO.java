package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StatementOrderDTO implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 3001801189864856829L;
		private String statementCode;
	    private String companyCode;
	    private String companyName;
	    //账期开始时间
	    private Date beginTime;
	    //账期结束时间
	    private Date endTime;
	    private Integer accountPeriod;
	    /**
	     * 结算状态：0：未结算1、全部结算 2、部分结算 
	     */
	    private Integer status;
	    //应结算总金额
	    private BigDecimal amount;
	    //	成交订单金额
	    private BigDecimal dealAmount;
	    //退款金额
	    private BigDecimal refundAmount;
	    //已付金额
	    private BigDecimal payAmount;
	    //剩余金额
	    private BigDecimal remainAmount;
	    private String remark;
	    private Integer operatorId;
	    private String operatorName;
	    private Date createTime;
	    private Date modifyTime;
	    
	    private String action;
	    
	    private List<StatementWaterDTO> statementWaterDTO;
	    
		public StatementOrderDTO() {
			super();
		}
		
		
		public StatementOrderDTO(String statementCode, String companyCode, Date beginTime, Date endTime,
				Integer accountPeriod, Integer status, BigDecimal amount, BigDecimal dealAmount, BigDecimal refundAmount,
				BigDecimal payAmount, BigDecimal remainAmount, String remark, Integer operatorId, String operatorName,
				Date createTime, Date modifyTime, String action) {
			super();
			this.statementCode = statementCode;
			this.companyCode = companyCode;
			this.beginTime = beginTime;
			this.endTime = endTime;
			this.accountPeriod = accountPeriod;
			this.status = status;
			this.amount = amount;
			this.dealAmount = dealAmount;
			this.refundAmount = refundAmount;
			this.payAmount = payAmount;
			this.remainAmount = remainAmount;
			this.remark = remark;
			this.operatorId = operatorId;
			this.operatorName = operatorName;
			this.createTime = createTime;
			this.modifyTime = modifyTime;
			this.action = action;
		}


		public String getStatementCode() {
			return statementCode;
		}
		public void setStatementCode(String statementCode) {
			this.statementCode = statementCode;
		}
		public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
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
		public Integer getAccountPeriod() {
			return accountPeriod;
		}
		public void setAccountPeriod(Integer accountPeriod) {
			this.accountPeriod = accountPeriod;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public BigDecimal getDealAmount() {
			return dealAmount;
		}
		public void setDealAmount(BigDecimal dealAmount) {
			this.dealAmount = dealAmount;
		}
		public BigDecimal getRefundAmount() {
			return refundAmount;
		}
		public void setRefundAmount(BigDecimal refundAmount) {
			this.refundAmount = refundAmount;
		}
		public BigDecimal getPayAmount() {
			return payAmount;
		}
		public void setPayAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
		}
		public BigDecimal getRemainAmount() {
			return remainAmount;
		}
		public void setRemainAmount(BigDecimal remainAmount) {
			this.remainAmount = remainAmount;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Integer getOperatorId() {
			return operatorId;
		}
		public void setOperatorId(Integer operatorId) {
			this.operatorId = operatorId;
		}
		public String getOperatorName() {
			return operatorName;
		}
		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public Date getModifyTime() {
			return modifyTime;
		}
		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}

       
		public String getCompanyName() {
			return companyName;
		}


		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}


		public List<StatementWaterDTO> getStatementWaterDTO() {
			return statementWaterDTO;
		}


		public void setStatementWaterDTO(List<StatementWaterDTO> statementWaterDTO) {
			this.statementWaterDTO = statementWaterDTO;
		}
	    
		
}
