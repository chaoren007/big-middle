package com.morning.star.retail.stock.entity;

import com.morning.star.retail.facade.dto.out.OutStockDetailDTO;
import com.morning.star.retail.facade.dto.out.OutStockDetailSubmitDTO;
import com.morning.star.retail.facade.dto.out.OutStockOutDetailDTO;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 出库单明细
 */
@Table(name = "retail_out_stock_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class OutStockDetailEntity extends BaseEntity {
	private static final long serialVersionUID = 1827509987480591886L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 19)
	@Comment(value = "主键id")
	private Long id;

	@Column(length = 64)
	@Comment(value = "出库单号")
	private String outStockCode;

	@Column(length = 64, nullable = false)
	@Comment(value = "集团编码")
	private String groupCode;

	@Comment(value = "集团名称")
	private String groupName;

	@Comment("商品编码")
	@Column(length = 64)
	private String goodsCode;

	@Comment("货品编码")
	@Column(length = 64, nullable = false)
	private String productCode;

	@Column(length = 64)
	@Comment(value = "商品名称")
	private String productName;

	@Comment(value = "商品规格")
	private String spuInfo;

	@Column(length = 64)
	@Comment(value = "upc编码")
	private String upcCode;

	@Column(length = 19, scale = 3)
	@Comment(value = "单位")
	private String units;

	@Column(precision = 19, scale = 2)
	@Comment(value = "采购价")
	private BigDecimal purchasePrice;

	@Column(precision = 19, scale = 3)
	@Comment(value = "需求出库数量")
	private BigDecimal initialOutNum;

	@Column(precision = 19, scale = 3)
	@Comment(value = "实际出库数量")
	private BigDecimal realOutNum = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3)
	@Comment(value = "可退数量")
	private BigDecimal returnableNum = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3)
	@Comment(value = "退货数量")
	private BigDecimal refundNum = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3)
	@Comment(value = "实际入库数量")
	private BigDecimal realInNum = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
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

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getInitialOutNum() {
		return initialOutNum;
	}

	public void setInitialOutNum(BigDecimal initialOutNum) {
		this.initialOutNum = initialOutNum;
	}

	public BigDecimal getRealOutNum() {
		return realOutNum;
	}

	public void setRealOutNum(BigDecimal realOutNum) {
		this.realOutNum = realOutNum;
	}

	public BigDecimal getReturnableNum() {
		return returnableNum;
	}

	public void setReturnableNum(BigDecimal returnableNum) {
		this.returnableNum = returnableNum;
	}

	public BigDecimal getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(BigDecimal refundNum) {
		this.refundNum = refundNum;
	}

	public BigDecimal getRealInNum() {
		return realInNum;
	}

	public void setRealInNum(BigDecimal realInNum) {
		this.realInNum = realInNum;
	}


	private void fillGoodsInfo(GoodsInfo goodsInfo) {
		this.setGroupCode(goodsInfo.getGroupCode());
		this.setGroupName(goodsInfo.getGroupName());

		this.setProductCode(goodsInfo.getProductCode());
		this.setGoodsCode(goodsInfo.getGoodsCode());
		this.setProductName(goodsInfo.getProductName());
		this.setSpuInfo(goodsInfo.getSpuInfo());
		this.setUnits(goodsInfo.getUnitsName());
	}

	public static OutStockDetailEntity formSubmit(String outStockCode, OutStockDetailSubmitDTO submitDTO, GoodsInfo goodsInfo) {
		OutStockDetailEntity entity = new OutStockDetailEntity();
		entity.setOutStockCode(outStockCode);

		entity.fillGoodsInfo(goodsInfo);

		entity.setInitialOutNum(submitDTO.getInitialOutNum());
		if (submitDTO.getRealOutNum() != null) {
			entity.setRealOutNum(submitDTO.getRealOutNum());
		}

		entity.setUpcCode(submitDTO.getUpcCode());
		return entity;
	}

	public static OutStockDetailEntity formOther(String outStockCode, OutStockDetailDTO detailDTO, GoodsInfo goodsInfo) {
		OutStockDetailEntity entity = new OutStockDetailEntity();
		entity.setOutStockCode(outStockCode);

		entity.setInitialOutNum(detailDTO.getInitialOutNum());
		entity.setRealOutNum(detailDTO.getRealOutNum());

		entity.setUpcCode(detailDTO.getUpcCode());

		entity.fillGoodsInfo(goodsInfo);
		return entity;
	}

	/**
	 * 把提交的实际出库数量填入详情中
	 */
	public void fillOutData(OutStockOutDetailDTO dto) {
		if (dto.getRealOutNum() != null) {
			this.setRealOutNum(dto.getRealOutNum());
		}

		if (dto.getRealInNum() != null) {
			this.setRealInNum(dto.getRealInNum());
		}

		if (dto.getReturnableNum() != null) {
			this.setReturnableNum(dto.getReturnableNum());
		}

		if (dto.getRefundNum() != null) {
			this.setRefundNum(dto.getRefundNum());
		}

	}
}
