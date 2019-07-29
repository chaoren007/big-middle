package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;

public class InventoryItemExportDTO implements Serializable {
    private static final long serialVersionUID = -5196228839756751315L;

    @ExcelColumn(name = "商品编码", isExport = true)
    private String goodsCode;

    @ExcelColumn(name = "货品编码", isExport = true)
    private String productCode;

    @ExcelColumn(name = "货品名称", isExport = true)
    private String productName;

    @ExcelColumn(name = "集团编码", isExport = true)
    private String groupCode;

    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

    @ExcelColumn(name = "门店名称", isExport = true)
    private String storeName;

    @ExcelColumn(name = "品牌ID", isExport = true)
    private Long brandId;

    @ExcelColumn(name = "品牌名称", isExport = true)
    private String brandName;

    @ExcelColumn(name = "一级类目ID", isExport = true)
    private Long categoryId1;

    @ExcelColumn(name = "一级类目", isExport = true)
    private String categoryName1;

    @ExcelColumn(name = "二级类目ID", isExport = true)
    private Long categoryId2;

    @ExcelColumn(name = "二级类目", isExport = true)
    private String categoryName2;

    @ExcelColumn(name = "三级类目ID", isExport = true)
    private Long categoryId3;

    @ExcelColumn(name = "三级类目", isExport = true)
    private String categoryName3;

    @ExcelColumn(name = "四级类目ID", isExport = true)
    private Long categoryId4;

    @ExcelColumn(name = "四级类目", isExport = true)
    private String categoryName4;

    @ExcelColumn(name = "五级类目ID", isExport = true)
    private Long categoryId5;

    @ExcelColumn(name = "五级类目", isExport = true)
    private String categoryName5;

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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public String getCategoryName1() {
        return categoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        this.categoryName1 = categoryName1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public String getCategoryName2() {
        return categoryName2;
    }

    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCategoryName3() {
        return categoryName3;
    }

    public void setCategoryName3(String categoryName3) {
        this.categoryName3 = categoryName3;
    }

    public Long getCategoryId4() {
        return categoryId4;
    }

    public void setCategoryId4(Long categoryId4) {
        this.categoryId4 = categoryId4;
    }

    public String getCategoryName4() {
        return categoryName4;
    }

    public void setCategoryName4(String categoryName4) {
        this.categoryName4 = categoryName4;
    }

    public Long getCategoryId5() {
        return categoryId5;
    }

    public void setCategoryId5(Long categoryId5) {
        this.categoryId5 = categoryId5;
    }

    public String getCategoryName5() {
        return categoryName5;
    }

    public void setCategoryName5(String categoryName5) {
        this.categoryName5 = categoryName5;
    }
}
