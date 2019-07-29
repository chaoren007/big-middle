package com.morning.star.retail.facade.dto.supply;


import com.morning.star.retail.facade.SubmitSystem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@ApiModel
@Data
public class GoodsSupplyAuditDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "批量供货商品编码")
	private Set<String> goodsSupplyCodeSet;

	@ApiModelProperty(value = "审核原因")
	private String reason;

	@ApiModelProperty(value = "是否具有多区域审核权限（0：无，1：有）", hidden = true)
	private Integer auditPermission = 0;

	@ApiModelProperty(value = "提交方", hidden = true)
	private SubmitSystem submitSystem = SubmitSystem.DEFAULT;

}
