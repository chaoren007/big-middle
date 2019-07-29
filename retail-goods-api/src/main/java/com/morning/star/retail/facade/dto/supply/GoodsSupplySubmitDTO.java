package com.morning.star.retail.facade.dto.supply;


import com.morning.star.retail.facade.SubmitSystem;
import com.morning.star.retail.facade.dto.ProductSpecDTO;
import com.morning.star.retail.facade.dto.supply.groups.StoreAdminSubmit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel
@Data
public class GoodsSupplySubmitDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码,(有编码则修改)")
	private String goodsSupplyCode;

	@NotNull(message = "分类ID不能为空")
	@ApiModelProperty(value = "最后一级分类ID")
	private String categoryId;

	@NotNull(message = "货品名称不能为空")
	@ApiModelProperty(value = "货品名称")
	private String productName;

//	@NotNull(message = "供应商编码不能为空", groups = StoreAdminSubmit.class)
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "产地")
	private String originPlace;

	@NotNull(message = "单位ID不能为空")
	@ApiModelProperty(value = "单位ID")
	private String unitsId;

	@ApiModelProperty(value = "品牌ID")
	private String brandId;

	@ApiModelProperty(value = "保质期")
	private Integer shelfLife;

//	@NotNull(message = "商品存储类型不能为空")
	@ApiModelProperty(value = "存储类型，0,冷藏存储;1,普通存储;2,冷冻存储")
	private Integer storageType;

//	@NotNull(message = "商品类型不能为空")
	@ApiModelProperty(value = "商品类型，0,普通商品;1,生鲜商品；2,服饰")
	private Integer commodityType;

	@NotNull(message = "商品类型不能为空")
	@ApiModelProperty(value = "存货类别:1000:水果、2000:生鲜、3000:食品、4000:⾮食品、5000:服务类、 6000:OEM自有品牌")
	private Integer categoryType;

	@NotNull(message = "明细中税率为空")
	@Min(value = 0, message = "税率不能小于0")
	@Max(value = 99, message = "税率不能大于99")
	@ApiModelProperty(value = "税率")
	private Integer taxRate = 1;

	@ApiModelProperty(value = "分类规格信息")
	private List<ProductSpecDTO> categorySpecInfo;

	@ApiModelProperty(value = "多规格商品信息")
	private List<GoodsSupplySpuSubmitDTO> detail;

	@ApiModelProperty(value = "商品icon")
	private String iconPath;

	@NotNull(message = "商品主图不能为空")
	@ApiModelProperty(value = "商品主图（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品详情图（逗号隔开）")
	private String introImgPaths;

	@ApiModelProperty(value = "商品详情")
	private String goodsDesc;

	@ApiModelProperty(value = "商品属性,OUT_BUY:外购")
	private String goodsAttribute;

	@ApiModelProperty(value = "箱规格")
	private String boxSpec;

	@ApiModelProperty(value = "提交方", hidden = true)
	private SubmitSystem submitSystem = SubmitSystem.DEFAULT;

	@ApiModelProperty(value = "UPC编码")
	private String upcCode;

}
