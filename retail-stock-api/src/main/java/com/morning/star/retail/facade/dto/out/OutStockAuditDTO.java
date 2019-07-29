package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 出库单单申请提交数据
 */
@ApiModel
public class OutStockAuditDTO implements Serializable {
	private static final long serialVersionUID = 6156993290436174199L;

	@NotNull(message = "出库单号不能为空")
	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@ApiModelProperty(value = "审核状态：20、审核成功 30、审核失败", hidden = true)
	private Integer status;

	@ApiModelProperty(value = "审核备注")
	private String remark;

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
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
}
