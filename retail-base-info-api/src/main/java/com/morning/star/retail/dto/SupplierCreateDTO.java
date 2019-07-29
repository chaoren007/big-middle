package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "供应商新增")
public class SupplierCreateDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "供应商名称")
    @NotNull(message = "供应商名称不能为空")
    private String supplierName;

    @ApiModelProperty(value = "联系人姓名")
    @NotNull(message = "联系人姓名不能为空")
    private String linkman;

    @ApiModelProperty(value = "联系方式")
    @NotNull(message = "联系方式不能为空")
    private String contact;

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "经营品类")
    @NotNull(message = "经营品类不能为空")
    private Long categoryId;

    @ApiModelProperty(value = "经营品类")
    @NotNull(message = "经营品类不能为空")
    private String categoryName;

    @ApiModelProperty(value = "所属省份id")
    @NotNull(message = "所属省份id不能为空")
    private Long provinceId;

    @ApiModelProperty(value = "所属省份名称")
    @NotNull(message = "所属省份名称不能为空")
    private String provinceName;

    @ApiModelProperty(value = "所属城市id")
    @NotNull(message = "所属城市id不能为空")
    private Long cityId;

    @ApiModelProperty(value = "所属城市编码")
    @NotNull(message = "所属城市编码不能为空")
    private String cityCode;

    @ApiModelProperty(value = "所属城市名称")
    @NotNull(message = "所属城市名称不能为空")
    private String cityName;

    @ApiModelProperty(value = "常驻城市id")
    @NotNull(message = "常驻城市id不能为空")
    private Long permanentCityId;

    @ApiModelProperty(value = "常驻城市名称")
    @NotNull(message = "常驻城市名称不能为空")
    private String permanentCityName;

    @ApiModelProperty(value = "合同年份")
    @NotNull(message = "合同年份不能为空")
    private Integer contractYear;

    @ApiModelProperty(value = "营业执照")
    @NotNull(message = "营业执照不能为空")
    private String businessLicense;

    @ApiModelProperty(value = "授权证书")
    @NotNull(message = "授权证书不能为空")
    private String authority;

    @ApiModelProperty(value = "身份证正面")
    @NotNull(message = "身份证正面不能为空")
    private String idcardFront;

    @ApiModelProperty(value = "身份证背面")
    @NotNull(message = "身份证背面不能为空")
    private String idcardBack;

    @ApiModelProperty(value = "集团编码", hidden = true)
    private String groupCode;

    @ApiModelProperty(value = "门店编码", hidden = true)
    private String storeCode;

    @ApiModelProperty(value = "供应商类型（0：总部；1：分公司）", hidden = true)
    private Integer type;

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

    public Integer getContractYear() {
        return contractYear;
    }

    public void setContractYear(Integer contractYear) {
        this.contractYear = contractYear;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
