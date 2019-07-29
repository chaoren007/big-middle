package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 耗材
 */
@ApiModel
public class ConsumableWaterDTO implements Serializable {

	private static final long serialVersionUID = 5309186858474685886L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "耗材编码")
	private String consumableCode;

	@ApiModelProperty(value = "耗材名称")
	private String consumableName;

	@ApiModelProperty(value = "耗材剩余数量")
	private Integer consumableNum;

	@ApiModelProperty(value = "耗材创建时间")
	private Date createTime;

	@ApiModelProperty("操作人id")
	private Long operatorId;

	@ApiModelProperty("操作人名称")
	private String operatorName;

	@ApiModelProperty("操作时间")
	private Date operateTime;

	@ApiModelProperty("操作备注")
	private String operatorRemark;

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

	public String getConsumableCode() {
		return consumableCode;
	}

	public void setConsumableCode(String consumableCode) {
		this.consumableCode = consumableCode;
	}

	public String getConsumableName() {
		return consumableName;
	}

	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
	}

	public Integer getConsumableNum() {
		return consumableNum;
	}

	public void setConsumableNum(Integer consumableNum) {
		this.consumableNum = consumableNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperatorRemark() {
		return operatorRemark;
	}

	public void setOperatorRemark(String operatorRemark) {
		this.operatorRemark = operatorRemark;
	}
}
