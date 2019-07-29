package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 供应商申请-实体
 *
 * @author jiangyf
 */
@Entity
@Table(name = "retail_supplier_apply")
@Where(clause = "delete_flag <> 1")
public class SupplierApplyEntity extends BaseEntity {
    private static final long serialVersionUID = 4505193978818395702L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment(value = "供应商名称")
    @Column(length = 64)
    private String supplierName;

    @Comment(value = "联系人姓名")
    @Column(length = 32)
    private String linkman;

    @Comment(value = "联系方式")
    @Column(length = 18)
    private String contact;

    @Comment(value = "手机号")
    @Column(length = 11)
    private String mobile;

    @Comment(value = "经营品类id")
    @Column(length = 20)
    private Long categoryId;

    @Comment(value = "经营品类名称")
    @Column(length = 32)
    private String categoryName;

    @Comment(value = "所属省份id")
    @Column(length = 20)
    private Long provinceId;

    @Comment(value = "所属省份名称")
    @Column(length = 32)
    private String provinceName;

    @Comment(value = "所属城市id")
    @Column(length = 20)
    private Long cityId;

    @Comment(value = "所属城市编码")
    @Column(length = 32)
    private String cityCode;

    @Comment(value = "所属城市名称")
    @Column(length = 32)
    private String cityName;

    @Comment(value = "常驻城市id")
    @Column(length = 20)
    private Long permanentCityId;

    @Comment(value = "常驻城市名称")
    @Column(length = 32)
    private String permanentCityName;

    @Comment(value = "营业执照")
    @Column(length = 100)
    private String businessLicense;

    @Comment(value = "授权证书")
    @Column(length = 100)
    private String authority;

    @Comment(value = "身份证正面")
    @Column(length = 100)
    private String idcardFront;

    @Comment(value = "身份证背面")
    @Column(length = 100)
    private String idcardBack;

    @Comment(value = "状态")
    @Column(length = 2)
    private Integer status;

    @Comment(value = "审核失败原因")
    @Column(length = 100)
    private String reason;

    @Comment(value = "备注")
    @Column(length = 100)
    private String remark;

    @Comment(value = "门店编码")
    @Column(nullable = false, length = 32)
    private String storeCode;

    @Comment(value = "集团编码")
    @Column(nullable = false, length = 32)
    private String groupCode;

    @Comment("供应商类型（0：总部；1：分公司）")
    @Column(length = 32)
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getPermanentCityId() {
        return permanentCityId;
    }

    public void setPermanentCityId(Long permanentCityId) {
        this.permanentCityId = permanentCityId;
    }

    public String getPermanentCityName() {
        return permanentCityName;
    }

    public void setPermanentCityName(String permanentCityName) {
        this.permanentCityName = permanentCityName;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront;
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
