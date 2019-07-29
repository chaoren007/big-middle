package com.morning.star.retail.entity;

import com.morning.star.retail.utils.audit.Operator;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基础信息
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
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
}
