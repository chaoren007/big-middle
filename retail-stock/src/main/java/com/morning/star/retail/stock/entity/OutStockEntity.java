package com.morning.star.retail.stock.entity;

import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.facade.dto.out.OutStockDetailDTO;
import com.morning.star.retail.facade.dto.out.OutStockSubmitDTO;
import com.morning.star.retail.stock.enums.OutStockStatusEnum;
import com.morning.star.retail.stock.enums.OutStockType;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 出库单
 */
@Table(name = "retail_out_stock")
@Where(clause = "delete_flag <> 1")
@Entity
public class OutStockEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 64, nullable = false)
	@Comment(value = "出库单号")
	private String outStockCode;

	@Column(length = 64)
	@Comment(value = "入库单号")
	private String inStockCode;

	@Column(length = 64, nullable = false)
	@Comment(value = "集团编码")
	private String groupCode;

	@Comment(value = "集团名称")
	private String groupName;

	@Column(length = 64, nullable = false)
	@Comment(value = "调出门店编码")
	private String outStoreCode;

	@Column(length = 64)
	@Comment(value = "调出门店名称")
	private String outStoreName;

	@Comment("调出仓库编码")
	@Column(length = 128, nullable = false)
	private String outWarehouseCode;

	@Comment("调出仓库名称")
	@Column(length = 128, nullable = false)
	private String outWarehouseName;

	@Column(length = 64)
	@Comment(value = "调入门店编码")
	private String inStoreCode;

	@Column(length = 64)
	@Comment(value = "调入门店名称")
	private String inStoreName;

	@Comment("调入仓库编码")
	@Column(length = 128)
	private String inWarehouseCode;

	@Comment("调入仓库名称")
	@Column(length = 128)
	private String inWarehouseName;

	@Column(length = 10)
	@Comment(value = "出库类型（0：其他，1：调拨出库）")
	@Convert(converter = OutStockType.DBConverter.class)
	private OutStockType type;

	@Column(length = 10)
	@Comment(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
	@Convert(converter = OutStockStatusEnum.DBConverter.class)
	private OutStockStatusEnum status;

	@Column(length = 64)
	@Comment(value = "备注")
	private String remark;

	@Column(length = 50)
	private String approveId;

	private String approveName;

	private Date approveDate;

	@Column(length = 64)
	private String creatorId;

	private String creatorName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "outStockCode", referencedColumnName = "outStockCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private List<OutStockDetailEntity> detailList;

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

	public String getInStockCode() {
		return inStockCode;
	}

	public void setInStockCode(String inStockCode) {
		this.inStockCode = inStockCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOutStoreCode() {
		return outStoreCode;
	}

	public void setOutStoreCode(String outStoreCode) {
		this.outStoreCode = outStoreCode;
	}

	public String getOutStoreName() {
		return outStoreName;
	}

	public void setOutStoreName(String outStoreName) {
		this.outStoreName = outStoreName;
	}

	public String getOutWarehouseCode() {
		return outWarehouseCode;
	}

	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}

	public String getOutWarehouseName() {
		return outWarehouseName;
	}

	public void setOutWarehouseName(String outWarehouseName) {
		this.outWarehouseName = outWarehouseName;
	}

	public String getInStoreCode() {
		return inStoreCode;
	}

	public void setInStoreCode(String inStoreCode) {
		this.inStoreCode = inStoreCode;
	}

	public String getInStoreName() {
		return inStoreName;
	}

	public void setInStoreName(String inStoreName) {
		this.inStoreName = inStoreName;
	}

	public String getInWarehouseCode() {
		return inWarehouseCode;
	}

	public void setInWarehouseCode(String inWarehouseCode) {
		this.inWarehouseCode = inWarehouseCode;
	}

	public String getInWarehouseName() {
		return inWarehouseName;
	}

	public void setInWarehouseName(String inWarehouseName) {
		this.inWarehouseName = inWarehouseName;
	}

	public OutStockType getType() {
		return type;
	}

	public void setType(OutStockType type) {
		this.type = type;
	}

	public OutStockStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OutStockStatusEnum status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public List<OutStockDetailEntity> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OutStockDetailEntity> detailList) {
		this.detailList = detailList;
	}

	public static OutStockDTO toDTO(OutStockEntity entity) {
		if (entity == null) {
			return null;
		}
		OutStockDTO dto = new OutStockDTO();
		BeanUtils.copy(entity, dto);
		List<OutStockDetailDTO> detailDTOList = entity.getDetailList().stream().map(e -> {
			OutStockDetailDTO detailDTO = new OutStockDetailDTO();
			BeanUtils.copy(e, detailDTO);
			return detailDTO;
		}).collect(Collectors.toList());
		dto.setDetailList(detailDTOList);
		return dto;
	}

	public void formSubmit(OutStockSubmitDTO submitDTO, WarehouseInfo outWarehouse, WarehouseInfo inWarehouse) {
		this.setGroupCode(submitDTO.getGroupCode());
		this.setGroupName(submitDTO.getGroupName());
		this.setOutStoreCode(outWarehouse.getStoreCode());
		this.setOutStoreName(outWarehouse.getStoreName());
		this.setOutWarehouseCode(outWarehouse.getWarehouseCode());
		this.setOutWarehouseName(outWarehouse.getWarehouseName());

		if (inWarehouse != null) {
			this.setInStoreCode(inWarehouse.getStoreCode());
			this.setInStoreName(inWarehouse.getStoreName());
			this.setInWarehouseCode(inWarehouse.getWarehouseCode());
			this.setInWarehouseName(inWarehouse.getWarehouseName());
		}

		OutStockType outStockType = OutStockType.from(submitDTO.getType());
		Validate.notNull(outStockType, "出库类型不存在：" + submitDTO.getType());
		this.setType(outStockType);
		this.setRemark(submitDTO.getRemark());
		//提交审核
		if (submitDTO.getIsDraft() == 1) {
			this.setStatus(OutStockStatusEnum.PREPARE_DRAFT);
		} else {
			this.setStatus(OutStockStatusEnum.WAIT_AUDIT);
		}
	}
}
