package com.morning.star.retail.facade.dto.purchase;

import com.morning.star.retail.bean.AdminLoginContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel
@Data
public class PurchaseSubmitDTO implements Serializable {

	private static final long serialVersionUID = 7117356089100225871L;

	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "集团名称", hidden = true)
	private String groupName;

	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	@ApiModelProperty(value = "门店名称", hidden = true)
	private String storeName;

	@NotNull(message = "供应商编码不能为空")
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@NotNull(message = "供应商名称不能为空")
	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "采购合同")
	private String contract;

	@ApiModelProperty(value = "供应商合同")
	private String supplierContract;

	@NotNull(message = "结算方式不能为空")
	@ApiModelProperty(value = "结算方式（1 指定账期，2 货到付款，3 预付款）")
	private Integer payments;

	@ApiModelProperty(value = "备注信息")
	private String remark;

	@ApiModelProperty(value = "是否存为草稿，0：否  1：是", hidden = true)
	private Integer isDraft;

	@ApiModelProperty(value = "提交类型，0：总部提交  1：分城市提交", hidden = true)
	private Integer submitType = 0;

	@ApiModelProperty(value = "本地发货（1：是  0：否）")
	private Integer localSend;

	@NotNull(message = "采购单明细不能为空")
	@ApiModelProperty(value = "采购货品明细")
	private List<PurchaseDetailSubmitDTO> orderDetail;

	public void fillLoginUser(AdminLoginContent login) {
		this.setGroupCode(login.getGroupCode());
		this.setGroupName(login.getGroupName());
		this.setStoreCode(login.getStoreCode());
		this.setStoreName(login.getStoreName());
	}
}
