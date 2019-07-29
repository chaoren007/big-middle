package com.morning.star.retail.entity;

import com.morning.star.retail.enums.CommodityTypeEnum;
import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.enums.StorageTypeEnum;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "retail_supply_goods_water")
public class GoodsSupplyWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 559028683041454996L;

	private Long id;

	@Column(length = 64, updatable = false)
	@Comment("商品供货编码（多规格的编码相同）")
	private String goodsSupplyCode;

	@Column(length = 64, updatable = false)
	@Comment("版本编码")
	private String versionCode;

	@Comment("商品名称，同货品名")
	private String goodsName;

	@Comment("门店编码")
	@Column(length = 64)
	private String storeCode;

	@Comment("门店名称")
	private String storeName;

	@Comment("库存")
	@Column(precision = 19, scale = 3)
	private BigDecimal stockNum;

	@Comment("库存预警值")
	@Column(precision = 19, scale = 3)
	private BigDecimal stockWarningNum;

	@Comment("累积销量")
	@Column(precision = 19, scale = 3)
	private BigDecimal salesNum;

	@Column(length = 2)
	@Convert(converter = GoodsSupplyStatus.DBConverter.class)
	@Comment("商品提交审核状态")
	private GoodsSupplyStatus supplyStatus;

	@Column(length = 64)
	@Comment("商品提交审核状态描述")
	private String supplyStatusDesc;

	@Comment("是否是主规格")
	@Column(length = 2)
	private Integer mainSpu;

	@Column(length = 64, updatable = false)
	@Comment("货品唯一编码")
	private String productCode;

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

	@Comment("计量单位ID")
	private Long unitsId;

	@Comment("计量单位名称")
	private String unitsName;

	@Column(length = 2)
	@Comment("货品类型 SP-单品,PP-套装")
	private String productType;

	@Comment("品牌ID")
	private Long brandId;

	@Comment("品牌名称")
	@Column(length = 64)
	private String brandName;

	@Comment("货品图标")
	private String iconPath;

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

	@Comment("保质期（天）")
	private Integer shelfLife;

	@Comment("供应商编码")
	@Column(length = 64)
	private String supplierCode;

	@Comment("供应商名称")
	@Column(length = 64)
	private String supplierName;

	@Comment("产地")
	private String originPlace;

	@Comment("税率")
	private Integer taxRate;

	@Comment("商品类型")
	@Column(nullable = false)
	@Convert(converter = CommodityTypeEnum.DBConverter.class)
	private CommodityTypeEnum commodityType;

	@Comment("存储类型")
	@Column(nullable = false)
	@Convert(converter = StorageTypeEnum.DBConverter.class)
	private StorageTypeEnum storageType;

	@Comment("数量/重量/体积 属性信息")
	private String outAttrInfo;

	@Comment("分类规格信息")
	private String categorySpuInfo;

	@Comment("存货类别")
	private Integer categoryType;

	@Comment("商详")
	private String goodsDesc;

	@Comment("所属方")
	private String ownSystem;

	@Comment(value = "商品属性")
	private String goodsAttribute;

	@Comment(value = "箱规格")
	private String boxSpec;
}
