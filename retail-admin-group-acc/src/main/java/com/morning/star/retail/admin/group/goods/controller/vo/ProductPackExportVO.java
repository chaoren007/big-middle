package com.morning.star.retail.admin.group.goods.controller.vo;

import java.io.Serializable;
import java.util.Date;

import com.morning.star.retail.base.poi.ExcelColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProductPackExportVO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ApiModelProperty(value = "大包装货品编码")
	@ExcelColumn(name = "大包装货品编码")
	private String productCode;

	@ApiModelProperty(value = "大包装货品名称")
	@ExcelColumn(name = "大包装货品名称")
	private String productName;

	@ApiModelProperty(value = "大包装UPC编码")
	@ExcelColumn(name = "大包装UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "大包装计量单位ID")
	@ExcelColumn(name = "大包装计量单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "大包装计量单位名称")
	@ExcelColumn(name = "大包装计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "小包装货品编码")
	@ExcelColumn(name = "小包装货品编码")
	private String packProductCode;

	@ApiModelProperty(value = "小包装货品名称")
	@ExcelColumn(name = "小包装货品名称")
	private String packProductName;

	@ApiModelProperty(value = "小包装UPC编码")
	@ExcelColumn(name = "小包装UPC编码")
	private String packUpcCode;

	@ApiModelProperty(value = "小包装计量单位ID")
	@ExcelColumn(name = "小包装计量单位ID")
	private Long packUnitsId;

	@ApiModelProperty(value = "小包装计量单位名称")
	@ExcelColumn(name = "小包装计量单位名称")
	private String packUnitsName;

	@ApiModelProperty(value = "包装容量")
	@ExcelColumn(name = "包装容量")
	private Integer packNum;

	@ApiModelProperty(value = "状态")
	@ExcelColumn(name = "状态")
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	@ExcelColumn(name = "创建时间")
	private Date createTime;


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

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Long getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getPackProductCode() {
		return packProductCode;
	}

	public void setPackProductCode(String packProductCode) {
		this.packProductCode = packProductCode;
	}

	public String getPackProductName() {
		return packProductName;
	}

	public void setPackProductName(String packProductName) {
		this.packProductName = packProductName;
	}

	public String getPackUpcCode() {
		return packUpcCode;
	}

	public void setPackUpcCode(String packUpcCode) {
		this.packUpcCode = packUpcCode;
	}

	public Long getPackUnitsId() {
		return packUnitsId;
	}

	public void setPackUnitsId(Long packUnitsId) {
		this.packUnitsId = packUnitsId;
	}

	public String getPackUnitsName() {
		return packUnitsName;
	}

	public void setPackUnitsName(String packUnitsName) {
		this.packUnitsName = packUnitsName;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
