package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class PurchaseOrderDTO implements Serializable {

	private static final long serialVersionUID = 7117356089100225871L;

	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty(value = "市")
	private Long cityId;

	@ApiModelProperty(value = "市名")
	private String cityName;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "审核状态：0、未审核 10、已审核 ")
	private Integer status;

	@ApiModelProperty(value = "单据状态：0、未入库 10、已入库")
	private Integer transStatus;

	@ApiModelProperty(value = "总金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "采购总金额(含税)")
	private BigDecimal rateAmount;

	@ApiModelProperty(value = "操作人编码")
	private String operatorId;

	@ApiModelProperty(value = "操作时间")
	private String operatorName;

	@ApiModelProperty(value = "审核人")
	private String approveId;

	@ApiModelProperty(value = "审核时间")
	private Date approveDate;

	@ApiModelProperty(value = "创建名字")
	private String creatorId;

	@ApiModelProperty(value = "创建人名字")
	private String creatorName;

	@ApiModelProperty(value = "采购合同")
	private String contract;

	@ApiModelProperty(value = "供应商合同")
	private String supplierContract;

	@ApiModelProperty(value = "支付方式")
	private Integer payments;

	@ApiModelProperty(value = "备注信息")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;

	@ApiModelProperty("本地发货")
	private Integer  localSend = 1;

	@ApiModelProperty(value = "采购单明细")
	private List<PurchaseOrderDetailDTO> orderDetail;
}
