package com.morning.star.retail.stock.entity;

import com.morning.star.retail.facade.dto.purchasein.PurchaseInOrderDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInOrderDetailDTO;
import com.morning.star.retail.stock.enums.PurchaseInStatusEnum;
import com.morning.star.retail.stock.enums.PurchaseSubmitEnum;
import com.morning.star.retail.utils.entity.BeanUtils;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "retail_purchase_in")
@Where(clause = "delete_flag <> 1")
@Entity
@Data
public class PurchaseInOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 5208328161187191942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("采购入库单号")
	@Column(length = 64, unique = true, updatable = false)
	private String purchaseInCode;

	@Comment("采购单号")
	@Column(length = 64, updatable = false)
	private String purchaseCode;

	@Comment("集团编码")
	@Column(length = 64, nullable = false)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Column(length = 64)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64)
	@Comment("门店名称")
	private String storeName;

	@Comment("市")
	private Long cityId;

	@Comment("市名")
	@Column(length = 16)
	private String cityName;

	@Comment("仓库市")
	private Long warehouseCityId;

	@Comment("仓库市名")
	@Column(length = 16)
	private String warehouseCityName;

	@Comment("仓库编码")
	@Column(length = 64)
	private String warehouseCode;

	@Comment("仓库名称")
	@Column(length = 64)
	private String warehouseName;

	@Comment("供应商编码")
	@Column(length = 64, nullable = false)
	private String supplierCode;

	@Comment("供应商名称")
	private String supplierName;

	@Comment("采购入库单状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = PurchaseInStatusEnum.DBConverter.class)
	private PurchaseInStatusEnum status;

	@Comment("采购单提交类型")
	@Column(length = 2, nullable = false)
	@Convert(converter = PurchaseSubmitEnum.DBConverter.class)
	private PurchaseSubmitEnum submitType;

	@Comment("入库状态")
	@Column(length = 2)
	private Integer transStatus;

	@Comment("支付类型")
	@Column(length = 2)
	private Integer payments;

	@Comment("采购总价(不含税)")
	@Column(precision = 19, scale = 3)
	private BigDecimal amount;

	@Comment("采购总价(含税)")
	@Column(precision = 19, scale = 3)
	private BigDecimal rateAmount;

	@Comment("采购合同")
	private String contract;

	@Comment("备注")
	private String remark;

	@Column(length = 50)
	private String approveId;

	private String approveName;

	private Date approveDate;

	@Column(length = 64)
	private String creatorId;

	private String creatorName;

	@Comment("预计入库时间")
	private Date preReceiptDate;

	@Comment("本地发货")
	@Column(length = 64)
	private Integer  localSend = 1;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "purchaseInCode", referencedColumnName = "purchaseInCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private List<PurchaseInOrderDetailEntity> detailEntityList;

	/**
	 * entity 转 dto
	 */
	public static PurchaseInOrderDTO toDTO(PurchaseInOrderEntity entity) {
		if (entity == null) {
			return null;
		}
		PurchaseInOrderDTO dto = new PurchaseInOrderDTO();
		BeanUtils.copy(entity, dto);
		List<PurchaseInOrderDetailDTO> detailDTOList = entity.getDetailEntityList().stream().map(e -> {
			PurchaseInOrderDetailDTO detail = new PurchaseInOrderDetailDTO();
			BeanUtils.copy(e, detail);
			return detail;
		}).collect(Collectors.toList());
		dto.setOrderDetail(detailDTOList);
		if (entity.getOperator() != null) {
			dto.setOperatorId(String.valueOf(entity.getOperator().getOperatorId() == null ? "" : entity.getOperator().getOperatorId()));
			dto.setOperatorName(entity.getOperator().getOperatorName());
		}

		return dto;
	}
}
