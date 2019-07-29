package com.morning.star.retail.facade.dto.supply;

import com.morning.star.retail.facade.dto.ProductSpecDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class GoodsSupplyDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "商品名称")
	private String goodsName;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "门店名称")
	private String storeName;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "货品版本号")
	private String versionCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty(value = "规格编码")
	private String spuCode;

	@ApiModelProperty(value = "规格详情")
	private String spuInfo;

	@ApiModelProperty(value = "UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "计量单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "货品类型 SP-单品,PP-套装")
	private String productType;

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "一级类目ID")
	private Long categoryId1;

	@ApiModelProperty(value = "一级类目")
	private String categoryName1;

	@ApiModelProperty(value = "二级类目ID")
	private Long categoryId2;

	@ApiModelProperty(value = "二级类目")
	private String categoryName2;

	@ApiModelProperty(value = "三级类目ID")
	private Long categoryId3;

	@ApiModelProperty(value = "三级类目")
	private String categoryName3;

	@ApiModelProperty(value = "保质期（天）")
	private Integer shelfLife;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "产地")
	private String originPlace;

	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty(value = "权重")
	private Integer priority;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@ApiModelProperty(value = "商品主图（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品详情图（逗号隔开）")
	private String introImgPaths;

	@ApiModelProperty("商品类型")
	private Integer commodityType;

	@ApiModelProperty("商品存储类型")
	private Integer storageType;

	@ApiModelProperty("货品母码")
	private String motherCode;

	@ApiModelProperty("市ID")
	private Long cityId;

	@ApiModelProperty("市名")
	private String cityName;

	@ApiModelProperty("分类规格信息")
	private String categorySpuInfo;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("库存")
	private BigDecimal stockNum;

	@ApiModelProperty("库存预警值")
	private BigDecimal stockWarningNum;

	@ApiModelProperty("累积销量")
	private BigDecimal salesNum;

	@ApiModelProperty("单价最大值")
	private BigDecimal priceMax;

	@ApiModelProperty("单价最小值")
	private BigDecimal priceMin;

	@ApiModelProperty(value = "供应商品状态")
	private Integer supplyStatus;

	@ApiModelProperty("供货区域城市ID，逗号分隔")
	private String supplyCityIds;

	@ApiModelProperty("供货区域城市名称，逗号分隔")
	private String supplyCityNames;

	@ApiModelProperty("供货区域是否多区域")
	private String supplyCityType;

	@ApiModelProperty("存货类别")
	private Integer categoryType;

	@ApiModelProperty("商详")
	private String goodsDesc;

	@ApiModelProperty("所属方")
	private String ownSystem;

	@ApiModelProperty(value = "商品属性,OUT_BUY:外购")
	private String goodsAttribute;

	@ApiModelProperty(value = "箱规格")
	private String boxSpec;

	@ApiModelProperty(value = "商品分类规格详情列表")
	private List<ProductSpecDTO> categorySpuInfoList;

	@ApiModelProperty(value = "货品规格")
	private List<ProductSpecDTO> productSpecInfo;

	@ApiModelProperty("多规格商品详情列表")
	private List<GoodsSupplySpuDTO> spuDetailList;

	@ApiModelProperty("供货区域设置详情")
	private List<GoodsSupplySetDTO> areaDetailList;


}
