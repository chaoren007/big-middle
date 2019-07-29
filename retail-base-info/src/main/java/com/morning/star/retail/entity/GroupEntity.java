package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * Created by kimhuhg.
 */
@Entity
@Table(name = "retail_group")
@Where(clause = "delete_flag <> 1")
public class GroupEntity extends BaseEntity {

	private static final long serialVersionUID = -8294655291995041409L;

	@Id
	@Column(length = 64, updatable = false)
	private String groupCode;

	@Column(length = 128)
	private String groupName;

	private Integer provinceId;

	@Column(length = 64)
	private String province;

	private Integer cityId;

	@Column(length = 64)
	private String city;

	private Integer districtId;

	@Column(length = 64)
	private String district;

	private String address;

	@Column(length = 2)
	@Convert(converter = GroupType.DBConverter.class)
	private GroupType type;

	/**
	 * 门店权限
	 */
	private String roleIds;

	/**
	 * 集团权限
	 */
	private String accessIds;

	/**
	 * 是否修改了角色ID(仅编辑时使用)
	 */
	private Integer isModifyRoleIds;

	private String creator;

	private String creatorName;
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

	public GroupType getType() {
		return type;
	}

	public void setType(GroupType type) {
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
//        if (StringUtils.isBlank(this.merchantCode)) {
//            throw RetailException.of(RetailErrorCode.INPAREMERROR, "支付商户号");
//        }
//    }
}
