package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 出库单提交
 */
public class OutStockSubmitDTO implements Serializable {
	private static final long serialVersionUID = 5708018644854459788L;

	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty(value = "调出门店编码")
	private String outStoreCode;

	@ApiModelProperty("调出仓库编码")
	private String outWarehouseCode;

	@ApiModelProperty(value = "调入门店编码")
	private String inStoreCode;

	@ApiModelProperty("调入仓库编码")
	private String inWarehouseCode;

	@ApiModelProperty(value = "出库类型（1,调拨出库 2,退货出库 3,其他)")
	private Integer type;

	@ApiModelProperty(value = "是否存为草稿，0：否  1：是", hidden = true)
	private Integer isDraft;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(required = true, value = "出库单明细")
	private List<OutStockDetailSubmitDTO> detailList;

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

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

	public String getOutStoreCode() {
		return outStoreCode;
	}

	public void setOutStoreCode(String outStoreCode) {
		this.outStoreCode = outStoreCode;
	}

	public String getOutWarehouseCode() {
		return outWarehouseCode;
	}

	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}

	public String getInStoreCode() {
		return inStoreCode;
	}

	public void setInStoreCode(String inStoreCode) {
		this.inStoreCode = inStoreCode;
	}

	public String getInWarehouseCode() {
		return inWarehouseCode;
	}

	public void setInWarehouseCode(String inWarehouseCode) {
		this.inWarehouseCode = inWarehouseCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Integer isDraft) {
		this.isDraft = isDraft;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<OutStockDetailSubmitDTO> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OutStockDetailSubmitDTO> detailList) {
		this.detailList = detailList;
	}
}
