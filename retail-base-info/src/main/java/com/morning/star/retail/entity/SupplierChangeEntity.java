package com.morning.star.retail.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 供应商-供货资格变更单
 *
 * @author jiangyf
 */
@Entity
@Table(name = "retail_supplier_change")
@Where(clause = "delete_flag <> 1")
public class SupplierChangeEntity extends BaseEntity {
    private static final long serialVersionUID = 4505193978818395702L;

    /**
     * 变更单号
     */
    @Id
    @Column(length = 32)
    private String code;
    /**
     * 供应商编码
     */
    @Column(nullable = false, length = 32)
    private String supplierCode;
    /**
     * 供应商名称
     */
    @Column(nullable = false, length = 64)
    private String supplierName;
    /**
     * 集团编码
     */
    @Column(nullable = false, length = 32)
    private String groupCode;
    /**
     * 状态
     */
    @Column(nullable = false)
    private Integer status;
    /**
     * 类型
     */
    @Column(nullable = false)
    private Integer type;
    /**
     * 创建人
     */
    @Column
    private Long createrId;
    @Column(length = 32)
    private String createrName;
    /**
     * 审核人
     */
    @Column
    private Long auditorId;
    @Column(length = 32)
    private String auditorName;
    @Column
    private Date auditTime;
    /**
     * 备注
     */
    @Column(length = 100)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
