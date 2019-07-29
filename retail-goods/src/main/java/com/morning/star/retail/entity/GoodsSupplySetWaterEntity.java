package com.morning.star.retail.entity;

import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySetDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "retail_supply_goods_set_water")
public class GoodsSupplySetWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 559028683041454996L;

	private Long id;

	@Comment("关联主表ID")
	private Long goodsSupplyId;

	@Column(length = 64, updatable = false)
	@Comment("商品提交供应编码编码")
	private String goodsSupplyCode;

	@Column(length = 64, updatable = false)
	@Comment("商品编码")
	private String productCode;

	@Column(length = 64, updatable = false)
	@Comment("版本编码")
	private String versionCode;

	@Comment("单价")
	@Column(precision = 19, scale = 3)
	private BigDecimal price;

	@Comment("数量")
	@Column(precision = 19, scale = 3)
	private BigDecimal totalNum;

	@Comment("销售数量")
	@Column(precision = 19, scale = 3)
	private BigDecimal salesNum;

	@Comment("省ID")
	private Long provinceId;

	@Comment("省名称")
	private String provinceName;

	@Comment("城市ID")
	private Long cityId;

	@Comment("城市名称")
	private String cityName;

	@Comment("供应商编码")
	@Column(length = 64)
	private String supplierCode;

	@Comment("供应商名称")
	@Column(length = 64)
	private String supplierName;

	@Column(length = 2)
	@Convert(converter = GoodsSupplyStatus.DBConverter.class)
	@Comment("商品提交审核状态")
	private GoodsSupplyStatus supplyStatus;

	public static GoodsSupplySetDTO toDTO(GoodsSupplySetWaterEntity entity) {
		if (entity == null) {
			return null;
		}
		GoodsSupplySetDTO dto = new GoodsSupplySetDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

}
