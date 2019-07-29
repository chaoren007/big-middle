package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatementWaterDTO implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2023953670641285343L;

	/**
     * 结算单编号
     */
    private String statementCode;
  
    /**
     * 支付账户类型：0：银行卡,1:支付宝，2:微信支付
     */
    private Integer accountType;
 
    /**
     * 支付流水号
     */
    private String paymentCode;
    /**
     * 支付账户（银行卡支付时记录卡号，其它支付记录支付账户）
     */
    private String accountCode;
    /**
     * 账户名称
     */
    private String accountName;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 开户银行名称
     */
    private String depositBankName;
    //结算金额
    private BigDecimal amount;
  
    private Integer operatorId;
    private String operatorName;
    private Date createTime;
    private Date modifyTime;
    private String remark;
    
    
	public StatementWaterDTO() {
		
	}

	public StatementWaterDTO(String statementCode, Integer accountType, String paymentCode, String accountCode,
			String accountName, String bankName, String depositBankName, BigDecimal amount, Integer operatorId,
			String operatorName, Date createTime, Date modifyTime, String remark) {
		
		this.statementCode = statementCode;
		this.accountType = accountType;
		this.paymentCode = paymentCode;
		this.accountCode = accountCode;
		this.accountName = accountName;
		this.bankName = bankName;
		this.depositBankName = depositBankName;
		this.amount = amount;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.remark = remark;
	}
	
	public String getStatementCode() {
		return statementCode;
	}
	public void setStatementCode(String statementCode) {
		this.statementCode = statementCode;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getDepositBankName() {
		return depositBankName;
	}
	public void setDepositBankName(String depositBankName) {
		this.depositBankName = depositBankName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}
