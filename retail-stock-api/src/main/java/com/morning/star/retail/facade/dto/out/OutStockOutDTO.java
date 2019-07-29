package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 出库单实际出库提交
 */
@ApiModel
public class OutStockOutDTO implements Serializable {
	private static final long serialVersionUID = 6156993290436174199L;

	@NotNull(message = "出库单号不能为空")
	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@NotNull(message = "出库详情不能为空")
	@ApiModelProperty(value = "出库详情")
	@Valid
	private List<OutStockOutDetailDTO> detailDTOList;

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

	public List<OutStockOutDetailDTO> getDetailDTOList() {
		return detailDTOList;
	}

	public void setDetailDTOList(List<OutStockOutDetailDTO> detailDTOList) {
		this.detailDTOList = detailDTOList;
	}
}
