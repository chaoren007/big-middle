package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 供应商门店-实体
 *
 * @author jiangyf
 */
@Entity
@Table(name = "retail_supplier_store")
@Where(clause = "delete_flag <> 1")
public class SupplierStoreEntity extends BaseEntity {
    private static final long serialVersionUID = 4505193978818395702L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 供应商编码
     */
    @Column(nullable = false, length = 32)
    private String supplierCode;
    /**
     * 门店编码
     */
    @Column(nullable = false, length = 32)
    private String storeCode;
    /**
     * 门店名称
     */
    @Column(nullable = false, length = 32)
    private String storeName;
    /**
     * 集团编码
     */
    @Column(nullable = false, length = 32)
    private String groupCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
