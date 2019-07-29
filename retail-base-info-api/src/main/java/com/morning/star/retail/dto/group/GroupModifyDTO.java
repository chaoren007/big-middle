package com.morning.star.retail.dto.group;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kimhuhg.
 */
public class GroupModifyDTO implements Serializable {

    private static final long serialVersionUID = -8294655291995041409L;

    @NotNull(message = "集团主键不能为空")
    private Long id;

    @NotNull(message = "集团编码不能为空(且不能修改)")
    @ApiModelProperty(value = "集团编码", required = true)
    private String groupCode;

    @NotNull(message = "集团名称不能为空")
    @ApiModelProperty(value = "集团名称", required = true)
    private String groupName;

    @NotNull(message = "省份id不能为空")
    @ApiModelProperty(value = "省份id", required = true)
    private Integer provinceId;

    @NotNull(message = "省份不能为空")
    @ApiModelProperty(value = "省份", required = true)
    private String province;

    @NotNull(message = "城市id不能为空")
    @ApiModelProperty(value = "城市id", required = true)
    private Integer cityId;

    @ApiModelProperty(value = "城市", required = true)
    private String city;

//    @NotNull(message = "区域id不能为空")
    @ApiModelProperty(value = "区域id", required = true)
    private Integer districtId;

//    @NotNull(message = "区域不能为空")
    @ApiModelProperty(value = "区域", required = true)
    private String district;

    @NotNull(message = "地址详情不能为空")
    @ApiModelProperty(value = "地址详情", required = true)
    private String address;

    @ApiModelProperty(value = "类型(1-集团型,2-POP型)")
    private Integer type;

    /**
     * 门店权限
     */
    @ApiModelProperty(value = "门店权限")
    private String roleIds;

    /**
     * 集团权限
     */
    @ApiModelProperty(value = "集团权限")
    private String accessIds;

    /**
     * 是否修改了角色ID(仅编辑时使用)
     */
    @ApiModelProperty(value = "是否修改了角色ID(仅编辑时使用)")
    private Integer isModifyRoleIds;

    @ApiModelProperty(value = "聚合支付的商户号")
    private String merchantCode;


    public Long getId() {
        return id;
    }public void setId(Long id) {
        this.id = id;
    }public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getAccessIds() {
        return accessIds;
    }

    public void setAccessIds(String accessIds) {
        this.accessIds = accessIds;
    }

    public Integer getIsModifyRoleIds() {
        return isModifyRoleIds;
    }

    public void setIsModifyRoleIds(Integer isModifyRoleIds) {
        this.isModifyRoleIds = isModifyRoleIds;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    //    public void check() {
//        if (StringUtils.isBlank(this.groupCode)) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "集团编码");
//        }
//        if (StringUtils.isBlank(this.groupName)) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "集团名称");
//        }
//        if (StringUtils.isBlank(this.address)) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "集团地址");
//        }
//        if (this.province == null) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "省");
//        }
//        if (this.city == null) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "市");
//        }
//        if (this.district == null) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "区/县");
//        }
//        if (StringUtils.isBlank(this.roleIds)) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "服务");
//        }
//    }
}
