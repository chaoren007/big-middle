package com.morning.star.retail.facade.dto.replenish;

import com.morning.star.retail.facade.dto.ReturnDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class ReplenishReceiveDTO implements Serializable {
	private static final long serialVersionUID = -7855854947181329374L;

	@ApiModelProperty(value = "补货单号")
	private String replenishCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "退货商品明细")
	private List<ReturnDTO> returnData;

	public String getReplenishCode() {
		return replenishCode;
	}

	public void setReplenishCode(String replenishCode) {
		this.replenishCode = replenishCode;
	}

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

	public List<ReturnDTO> getReturnData() {
		return returnData;
	}

	public void setReturnData(List<ReturnDTO> returnData) {
		this.returnData = returnData;
	}
}
