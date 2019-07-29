package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.Date;

public class StatementSettingDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6309262050694363743L;
	private Integer id;
	 /**
    * 账期
    */
   private Integer accountPeriod;
   
   /**
    * 上次结算时间
    */
   private Date LastAccountTime;
   
   private Integer operatorId;
   private String operatorName;
   private Date createTime;
   private Date modifyTime;
   private String remark;
   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountPeriod() {
		return accountPeriod;
	}
	public void setAccountPeriod(Integer accountPeriod) {
		this.accountPeriod = accountPeriod;
	}
	public Date getLastAccountTime() {
		return LastAccountTime;
	}
	public void setLastAccountTime(Date lastAccountTime) {
		LastAccountTime = lastAccountTime;
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
