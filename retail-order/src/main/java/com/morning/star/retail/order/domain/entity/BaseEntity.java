package com.morning.star.retail.order.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.morning.star.retail.utils.audit.Operator;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;

import lombok.Data;

/**
 * 实体基础信息
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -5733386633728577588L;
	/**
	 * 创建时间
	 */
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createTime;
	/**
	 * 修改时间
	 */
	@Column
	@org.hibernate.annotations.UpdateTimestamp
	private Date modifyTime;
	
	/**
	 * 删除标志
	 */
	@Column(length = 2, nullable = false)
	private Integer deleteFlag = DeleteFlagEnum.NORMAL.getCode();
	
	/**
     * 操作人
     */
    @Embedded
    @LastModifiedBy
    private Operator operator;

}
