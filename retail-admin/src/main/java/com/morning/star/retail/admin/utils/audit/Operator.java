package com.morning.star.retail.admin.utils.audit;


import javax.persistence.Column;

public class Operator {

	@Column(name = "operator_id")
	private Long operatorId;

	@Column(name = "operator_name")
	private String operatorName;

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
