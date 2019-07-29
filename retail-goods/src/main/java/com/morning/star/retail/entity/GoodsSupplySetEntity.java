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
@Table(name = "retail_supply_goods_set")
@Where(clause = "delete_flag <> 1")
public class GoodsSupplySetEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Comment("ID")
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
	private BigDecimal salesNum = BigDecimal.ZERO;

	@Comment("省ID")
	private Long provinceId;

	@Comment("省名称")
	private String provinceName;

	@Comment("大区编码")
	private String regionCode;

	@Comment("大区名称")
	private String regionName;

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

	@Comment("提交组")
	@Column(length = 2)
	private Integer submitGroup = 0;

	@Column(length = 2)
	@Convert(converter = GoodsSupplyStatus.DBConverter.class)
	@Comment("商品提交审核状态")
	private GoodsSupplyStatus supplyStatus = GoodsSupplyStatus.ON_SALE;

	public static GoodsSupplySetDTO toDTO(GoodsSupplySetEntity entity) {
		if (entity == null) {
			return null;
		}
		GoodsSupplySetDTO dto = new GoodsSupplySetDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

}
