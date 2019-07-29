package com.morning.star.retail.admin.goods.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class GoodsExportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;

	@ExcelColumn(name = "商品名称")
	private String goodsName;

	@ExcelColumn(name = "商品编码")
	private String goodsCode;

	@ExcelColumn(name = "UPC")
	private String upcCode;

	@ExcelColumn(name = "一级分类")
	private String categoryName1;

	@ExcelColumn(name = "二级分类")
	private String categoryName2;

	@ExcelColumn(name = "三级分类")
	private String categoryName3;

	@ExcelColumn(name = "四级分类")
	private String categoryName4;

	@ExcelColumn(name = "五级分类")
	private String categoryName5;

	@ExcelColumn(name = "单位")
	private String unitsName;

	@ExcelColumn(name = "销售指导价")
	private BigDecimal salePrice;

	@ExcelColumn(name = "销售状态")
	private String saleStatus;

	@ExcelColumn(name = "产地")
	private String originPlace;

	@ExcelColumn(name = "税率")
	private Integer taxRate;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public String getCategoryName4() {
		return categoryName4;
	}

	public void setCategoryName4(String categoryName4) {
		this.categoryName4 = categoryName4;
	}

	public String getCategoryName5() {
		return categoryName5;
	}

	public void setCategoryName5(String categoryName5) {
		this.categoryName5 = categoryName5;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}
}
