package com.morning.star.retail.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.morning.star.retail.utils.audit.Operator;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 实体基础信息
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -5733386633728577588L;
	/**
	 * 创建时间
	 */
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	@Comment("创建时间")
	private Date createTime;
	/**
	 * 修改时间
	 */
	@Column
	@org.hibernate.annotations.UpdateTimestamp
	@Comment("修改时间")
	private Date modifyTime;
	
	/**
	 * 删除标志
	 */
	@Column(length = 2, nullable = false)
	@Comment("删除标志")
	private Integer deleteFlag = DeleteFlagEnum.NORMAL.getCode();
	
	/**
     * 操作人
     */
    @Embedded
    @LastModifiedBy
    private Operator operator;

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

    public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    
    public void delete() {
        this.deleteFlag = DeleteFlagEnum.DELETE.getCode();
    }
}
