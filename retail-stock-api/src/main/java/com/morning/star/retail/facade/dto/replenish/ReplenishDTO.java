package com.morning.star.retail.facade.dto.replenish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "补货单")
public class ReplenishDTO implements Serializable {
	private static final long serialVersionUID = 700733871275750587L;

	@ApiModelProperty(value = "补货单号")
	private String replenishCode;

	@ApiModelProperty(value = "收货单号")
	private String deliveryCode;

	@ApiModelProperty("城市id")
	private Long cityId;

	@ApiModelProperty("城市名称")
	private String cityName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty(value = "补货单状态（0：待确认，1：已确认，2：驳回）")
	private Integer status;

	@ApiModelProperty(value = "补货单状态详情")
	private String statusName;

	@ApiModelProperty(value = "补货类型，0：门店申请补货，1：总部主动补货")
	private Integer type;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "审核时间")
	private Date authTime;

	@ApiModelProperty("补货仓库编码集")
	private String warehouseCodes;

	@ApiModelProperty("补货仓库名称集")
	private String warehouseNames;

	@ApiModelProperty(value = "补货明细")
	private List<ReplenishItemDTO> items;

	public String getReplenishCode() {
		return replenishCode;
	}

	public void setReplenishCode(String replenishCode) {
		this.replenishCode = replenishCode;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAuthTime() {
		return authTime;
	}

	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}

	public String getWarehouseCodes() {
		return warehouseCodes;
	}

	public void setWarehouseCodes(String warehouseCodes) {
		this.warehouseCodes = warehouseCodes;
	}

	public String getWarehouseNames() {
		return warehouseNames;
	}

	public void setWarehouseNames(String warehouseNames) {
		this.warehouseNames = warehouseNames;
	}

	public List<ReplenishItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ReplenishItemDTO> items) {
		this.items = items;
	}
}
