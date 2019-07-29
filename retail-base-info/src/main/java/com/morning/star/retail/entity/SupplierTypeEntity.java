package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 供应商类别-实体
 */
@Entity
@Table(name = "retail_supplier_type")
@Where(clause = "delete_flag <> 1")
public class SupplierTypeEntity extends BaseEntity {
    private static final long serialVersionUID = 559028683041454996L;

    /**
     * 编码
     */
    @Id
    @Column(length = 32)
    private String code;
    /**
     * 名称
     */
    @Column(nullable = false, length = 64)
    private String name;
    /**
     * 上级编码
     */
    @Column(nullable = false, length = 32)
    private String parentCode;
    /**
     * 集团编码
     */
    @Column(nullable = false, length = 32)
    private String groupCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
