package com.morning.star.retail.stock.helper.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2018/12/5 10:50
 **/
@ApiModel(value = "仓库管理-新增")
public class WarehouseInfo implements Serializable {
	private static final long serialVersionUID = 7436140691086422746L;

	@ApiModelProperty("仓库名称")
	private String warehouseName;

	@ApiModelProperty("仓库编码-后台生成")
	private String warehouseCode;

	@ApiModelProperty("城市ID")
	private Long cityId;

	@ApiModelProperty("城市-门店端由后台注入")
	private String city;

	private String storeCode;

	private String storeName;
	private String groupCode;

	@ApiModelProperty("仓库地址")
	private String warehouseAddress;

	@ApiModelProperty("负责人")
	private String createName;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("备注")
	private String remark;

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
  
  
   