package com.morning.star.retail.stock.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.morning.star.retail.utils.audit.Operator;

/**
 * 实体基础信息
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class WaterEntity implements Serializable {
	private static final long serialVersionUID = -5733386633728577588L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long wid; // 主键id

	/**
	 * 创建时间
	 */
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date operateTime;

	/**
	 * 操作人
	 */
	@Embedded
	@LastModifiedBy
	private Operator operator;

	/**
	 * 操作人
	 */
	@Column
	private String operatorRemark;

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getOperatorRemark() {
		return operatorRemark;
	}

	public void setOperatorRemark(String operatorRemark) {
		this.operatorRemark = operatorRemark;
	}
}
