package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDetailDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseSubmitDTO;
import com.morning.star.retail.stock.enums.PurchaseInStatusEnum;
import com.morning.star.retail.stock.enums.PurchaseSubmitEnum;
import com.morning.star.retail.stock.helper.vo.SupplierInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import lombok.Data;
import org.hibernate.annotations.Where;

import com.morning.star.retail.stock.enums.PurchaseStatusEnum;

@Table(name = "retail_purchase")
@Where(clause = "delete_flag <> 1")
@Entity
@Data
public class PurchaseOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 5208328161187191942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("采购单号")
	@Column(length = 64, unique = true, updatable = false)
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

	@Comment("供应商编码")
	@Column(length = 64, nullable = false)
	private String supplierCode;

	@Comment("供应商名称")
	private String supplierName;

	@Comment("采购单状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = PurchaseStatusEnum.DBConverter.class)
	private PurchaseStatusEnum status;

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

	@Comment("本地发货")
	@Column(length = 64)
	private Integer  localSend;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "purchaseCode", referencedColumnName = "purchaseCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private List<PurchaseOrderDetailEntity> detailEntityList;

	/**
	 * entity 转 dto
	 */
	public static PurchaseOrderDTO toDTO(PurchaseOrderEntity entity) {
		if(entity == null) {
			return null;
		}
		PurchaseOrderDTO dto = new PurchaseOrderDTO();
		BeanUtils.copy(entity, dto);
		List<PurchaseOrderDetailDTO> detailDTOList = entity.getDetailEntityList().stream().map(e -> {
			PurchaseOrderDetailDTO detailDTO = new PurchaseOrderDetailDTO();
			BeanUtils.copy(e, detailDTO);
			return detailDTO;
		}).collect(Collectors.toList());
		dto.setOrderDetail(detailDTOList);
		if (entity.getOperator() != null) {
			dto.setOperatorId(String.valueOf(entity.getOperator().getOperatorId() == null ? "" : entity.getOperator().getOperatorId()));
			dto.setOperatorName(entity.getOperator().getOperatorName());
		}
		return dto;
	}

	public void formSubmit(PurchaseSubmitDTO purchaseSubmitDTO, SupplierInfo supplierInfo) {
		this.setGroupCode(purchaseSubmitDTO.getGroupCode());
		this.setGroupName(purchaseSubmitDTO.getGroupName());
		this.setStoreCode(purchaseSubmitDTO.getStoreCode());
		this.setStoreName(purchaseSubmitDTO.getStoreName());

		this.setSupplierCode(supplierInfo.getSupplierCode());
		this.setSupplierName(supplierInfo.getSupplierName());

		this.setPayments(purchaseSubmitDTO.getPayments());
		this.setContract(purchaseSubmitDTO.getContract());
		this.setRemark(purchaseSubmitDTO.getRemark());
		//提交审核
		if (purchaseSubmitDTO.getIsDraft() == 1) {
			this.setStatus(PurchaseStatusEnum.PREPARE_DRAFT);
		} else {
			this.setStatus(PurchaseStatusEnum.WAIT_AUDIT);
		}

		// 提交类型
		if (purchaseSubmitDTO.getSubmitType().equals(PurchaseSubmitEnum.STORE.getCode())) {
			this.setSubmitType(PurchaseSubmitEnum.STORE);
		} else {
			this.setSubmitType(PurchaseSubmitEnum.GROUP);
		}
		this.setLocalSend(purchaseSubmitDTO.getLocalSend());
	}

	public static PurchaseInOrderEntity formIn(PurchaseOrderEntity purchaseOrderEntity,
	                                           List<PurchaseOrderDetailEntity> purchaseDetailList,
	                                           String code) {
		PurchaseInOrderEntity entity = new PurchaseInOrderEntity();
		entity.setPurchaseInCode(code);
		entity.setPurchaseCode(purchaseOrderEntity.getPurchaseCode());

		entity.setGroupCode(purchaseOrderEntity.getGroupCode());
		entity.setGroupName(purchaseOrderEntity.getGroupName());

		entity.setCityId(purchaseDetailList.get(0).getCityId());
		entity.setCityName(purchaseDetailList.get(0).getCityName());
		entity.setStoreCode(purchaseDetailList.get(0).getStoreCode());
		entity.setStoreName(purchaseDetailList.get(0).getStoreName());

		entity.setWarehouseCityId(purchaseDetailList.get(0).getWarehouseCityId());
		entity.setWarehouseCityName(purchaseDetailList.get(0).getWarehouseCityName());
		entity.setWarehouseCode(purchaseDetailList.get(0).getWarehouseCode());
		entity.setWarehouseName(purchaseDetailList.get(0).getWarehouseName());

		entity.setSupplierCode(purchaseOrderEntity.getSupplierCode());
		entity.setSupplierName(purchaseOrderEntity.getSupplierName());

		entity.setStatus(PurchaseInStatusEnum.SUCCESS);
		entity.setSubmitType(purchaseOrderEntity.getSubmitType());
		entity.setTransStatus(purchaseOrderEntity.getTransStatus());
		entity.setPayments(purchaseOrderEntity.getPayments());
		entity.setLocalSend(purchaseOrderEntity.getLocalSend());

		entity.setContract(purchaseOrderEntity.getContract());
		entity.setRemark(purchaseOrderEntity.getRemark());
		entity.setApproveId(purchaseOrderEntity.getApproveId());
		entity.setApproveName(purchaseOrderEntity.getApproveName());
		entity.setApproveDate(purchaseOrderEntity.getApproveDate());
		entity.setCreatorId(purchaseOrderEntity.getCreatorId());
		entity.setCreatorName(purchaseOrderEntity.getCreatorName());
		entity.setDetailEntityList(purchaseDetailList.stream()
			.map(item -> PurchaseOrderDetailEntity.formIn(item, code))
			.collect(Collectors.toList()));

		BigDecimal amount = purchaseDetailList.stream()
			.map(PurchaseOrderDetailEntity::getAmount)
			.reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO);
		BigDecimal rateAmount = purchaseDetailList.stream()
			.map(PurchaseOrderDetailEntity::getRateAmount)
			.reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO);
		entity.setAmount(amount);
		entity.setRateAmount(rateAmount);

		return entity;
	}
}
