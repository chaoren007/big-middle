package com.morning.star.retail.dto;

import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * 供应货品
 */
public class ExportSuppilerItemDTO implements Serializable {
    private static final long serialVersionUID = -1770133376799599533L;

    @ExcelColumn(name = "供应商编码", isExport = true)
    private String supplierCode;
    @ExcelColumn(name = "货品编码", isExport = true)
    private String productCode;
    @ExcelColumn(name = "货品名称", isExport = true)
    private String productName;
    @ExcelColumn(name = "UPC", isExport = true)
    private String upcCode;
    @ExcelColumn(name = "单位", isExport = true)
    private String units;
    @ExcelColumn(name = "规格", isExport = true)
    private String spuInfo;
    @ExcelColumn(name = "一级类目", isExport = true)
    private String categoryName1;
    @ExcelColumn(name = "二级类目", isExport = true)
    private String categoryName2;
    @ExcelColumn(name = "三级类目", isExport = true)
    private String categoryName3;
    @ExcelColumn(name = "税率", isExport = true)
    private Integer taxRate;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
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

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
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

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }
}
