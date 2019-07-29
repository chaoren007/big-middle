package com.morning.star.retail.dto.group;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/10/12.
 */
public class GroupCreateDTO implements Serializable {

    private static final long serialVersionUID = -8294655291995041409L;

    @NotNull(message = "集团编码不能为空")
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

    private String creator;

    private String creatorName;

    @ApiModelProperty(value = "聚合支付的商户号")
    private String merchantCode;


    public String getGroupCode() {
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
