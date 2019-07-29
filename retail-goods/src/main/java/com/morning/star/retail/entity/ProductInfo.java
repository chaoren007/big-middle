package com.morning.star.retail.entity;

import com.morning.star.retail.enums.CommodityTypeEnum;
import com.morning.star.retail.enums.FreshTypeEnum;
import com.morning.star.retail.enums.ProductMarketStatus;
import com.morning.star.retail.enums.StorageTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductInfo {
	private static final long serialVersionUID = 559028683041454996L;

	@Column(length = 64, updatable = false)
	@Comment("货品唯一编码")
	private String productCode;

	@Column(updatable = false)
	@Comment("货品唯一编码")
	private String sapProductCode;

	@Column(updatable = false)
	@Comment("货品SAP母码")
	private String sapMotherCode;

	@Comment("货品名称")
	private String productName;

	@Column(length = 64, updatable = false)
	@Comment("集团编码")
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Comment("spu编码")
	@Column(length = 64, updatable = false)
	private String spuCode;

	@Comment("规格信息")
	@Column(length = 64, updatable = false)
	private String spuInfo;

	@Comment("UPC编码")
	@Column(length = 64, updatable = false)
	private String upcCode;

	@Comment("是否为串码管理，0-否 1-是")
	@Column(length = 2)
	private Integer isSerialCode;

	@Comment("计量单位ID")
	private Long unitsId;

	@Comment("计量单位名称")
	private String unitsName;

	@Column(length = 2)
	@Comment("货品类型 SP-单品,PP-套装")
	private String productType;

	@Comment("包装容量")
	private Integer packSpecNum;

	@Column(length = 50)
	@Comment("包装容量单位（如：箱）")
	private String packSpecUnits;

	@Column(length = 64)
	@Comment("如果是单品为null，如果是套装，记录套装内对应单品的goods_code")
	private String unitProductCode;

	@Comment("上下架状态")
	@Column(length = 2)
	@Convert(converter = ProductMarketStatus.DBConverter.class)
	private ProductMarketStatus status;

	@Comment("成本价")
	@Column(precision = 19, scale = 3)
	private BigDecimal costPrice;

	@Comment("销售指导价")
	@Column(precision = 19, scale = 3)
	private BigDecimal guidePrice;

	@Comment("销售价")
	@Column(precision = 19, scale = 3)
	private BigDecimal salePrice;

	@Comment("品牌ID")
	private Long brandId;

	@Comment("品牌名称")
	@Column(length = 64)
	private String brandName;

	@Comment("标准类型（0：非称重，1：称重, 2:服饰）")
	@Column(length = 2)
	private Integer standardType;

	@Comment("货品图标")
	private String iconPath;

	@Comment("货品重量")
	@Column(precision = 19, scale = 3)
	private BigDecimal weight;

	@Comment("货品介绍")
	private String productIntroduce;

	@Comment("一级类目ID")
	private Long categoryId1;

	@Comment("一级类目")
	@Column(length = 64)
	private String categoryName1;

	@Comment("二级类目ID")
	private Long categoryId2;

	@Comment("二级类目")
	@Column(length = 64)
	private String categoryName2;

	@Comment("三级类目ID")
	private Long categoryId3;

	@Comment("三级类目")
	@Column(length = 64)
	private String categoryName3;

	@Comment("四级类目ID")
	private Long categoryId4;

	@Comment("四级类目")
	@Column(length = 64)
	private String categoryName4;

	@Comment("五级类目ID")
	private Long categoryId5;

	@Comment("五级类目")
	@Column(length = 64)
	private String categoryName5;

	@Comment("保质期（天）")
	private Integer shelfLife;

	@Comment("权重")
	private Integer priority;

	@Comment("三公里配送字段 1是 0否")
	@Column(length = 2)
	private Integer delivery = 0;

	@Comment("销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
	@Column(length = 2)
	private Integer salesType;

	@Comment("供应商编码")
	@Column(length = 64)
	private String supplierCode;

	@Comment("供应商名称")
	@Column(length = 64)
	private String supplierName;

	@Comment("采购价")
	@Column(precision = 19, scale = 3)
	private BigDecimal purchasePrice;

	@Comment("产地")
	private String originPlace;

	@Comment("税率")
	private Integer taxRate;

	@Column(length = 2)
	@Comment("生鲜类型")
	@Convert(converter = FreshTypeEnum.DBConverter.class)
	private FreshTypeEnum freshType;

	@Comment("商品类型")
	@Column(nullable = false)
	@Convert(converter = CommodityTypeEnum.DBConverter.class)
	private CommodityTypeEnum commodityType;

	@Comment("存储类型")
	@Column(nullable = false)
	@Convert(converter = StorageTypeEnum.DBConverter.class)
	private StorageTypeEnum storageType;

	@Comment("货品母码")
	@Column
	private String motherCode;

	@Comment("市")
	private Long cityId;

	@Comment("市名")
	@Column(length = 16)
	private String cityName;

	@Comment("是否可以拆零，0-否 1-是")
	@Column(length = 2)
	private Integer splitType;

	@Comment("体积长度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeLength;

	@Comment("体积宽度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeWidth;

	@Comment("体积高度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeHeight;

	@Comment("数量/重量/体积 属性信息")
	private String outAttrInfo;

	@Comment("分类规格信息")
	private String categorySpuInfo;

}
