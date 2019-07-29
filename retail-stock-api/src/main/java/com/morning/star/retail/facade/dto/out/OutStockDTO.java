package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 出库单明细
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@ApiModel
public class OutStockDTO implements Serializable {
	private static final long serialVersionUID = 6177930044594156802L;
	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@ApiModelProperty(value = "入库单号")
	private String inStockCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty(value = "调出门店编码")
	private String outStoreCode;

	@ApiModelProperty(value = "调出门店名称")
	private String outStoreName;

	@ApiModelProperty("调出仓库编码")
	private String outWarehouseCode;

	@ApiModelProperty("调出仓库名称")
	private String outWarehouseName;

	@ApiModelProperty(value = "调入门店编码")
	private String inStoreCode;

	@ApiModelProperty(value = "调入门店名称")
	private String inStoreName;

	@ApiModelProperty("调入仓库编码")
	private String inWarehouseCode;

	@ApiModelProperty("调入仓库名称")
	private String inWarehouseName;

	@ApiModelProperty(value = "出库类型（0：其他，1：调拨出库）")
	private Integer type;

	@ApiModelProperty(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
	private Integer status;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	private List<OutStockDetailDTO> detailList;

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

	public String getInStockCode() {
		return inStockCode;
	}

	public void setInStockCode(String inStockCode) {
		this.inStockCode = inStockCode;
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

	public String getOutStoreName() {
		return outStoreName;
	}

	public void setOutStoreName(String outStoreName) {
		this.outStoreName = outStoreName;
	}

	public String getOutWarehouseCode() {
		return outWarehouseCode;
	}

	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}

	public String getOutWarehouseName() {
		return outWarehouseName;
	}

	public void setOutWarehouseName(String outWarehouseName) {
		this.outWarehouseName = outWarehouseName;
	}

	public String getInStoreCode() {
		return inStoreCode;
	}

	public void setInStoreCode(String inStoreCode) {
		this.inStoreCode = inStoreCode;
	}

	public String getInStoreName() {
		return inStoreName;
	}

	public void setInStoreName(String inStoreName) {
		this.inStoreName = inStoreName;
	}

	public String getInWarehouseCode() {
		return inWarehouseCode;
	}

	public void setInWarehouseCode(String inWarehouseCode) {
		this.inWarehouseCode = inWarehouseCode;
	}

	public String getInWarehouseName() {
		return inWarehouseName;
	}

	public void setInWarehouseName(String inWarehouseName) {
		this.inWarehouseName = inWarehouseName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OutStockDetailDTO> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OutStockDetailDTO> detailList) {
		this.detailList = detailList;
	}
}
