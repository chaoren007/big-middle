package com.morning.star.retail.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "retail_supplier_item")
@Where(clause = "delete_flag <> 1")
public class SupplierItemEntity extends BaseEntity {
    private static final long serialVersionUID = -1932115876410624055L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("集团编码")
    @Column(nullable = false, length = 32)
    private String groupCode;

    @Comment("供应商编码")
    @Column(nullable = false, length = 32)
    private String supplierCode;

    @Comment("SAP货品编码")
    @Column(updatable = false)
    private String sapProductCode;

    @Comment("货品唯一编码")
    @Column(nullable = false, length = 32)
    private String productCode;

    @Comment("货品名称")
    @Column(nullable = false, length = 200)
    private String productName;

    @Comment("UPC编码")
    @Column
    private String upcCode;

    @Comment("货品icon图片")
    @Column( length = 100)
    private String iconPath;

    @Comment("单位")
    @Column(nullable = false, length = 10)
    private String units;

    @Comment("规格编码")
    @Column(length = 200)
    private String spuInfo;

    @Comment("一级类目ID")
    @Column
    private Long categoryId1;

    @Comment("一级类目")
    @Column(length = 64)
    private String categoryName1;

    @Comment("二级类目ID")
    private Long categoryId2;

    @Comment("二级类目")
    @Column(length = 64)
    private String categoryName2;

    @Comment("三级类目ID")
    private Long categoryId3;

    @Comment("三级类目")
    @Column(length = 64)
    private String categoryName3;

    @Comment("四级类目ID")
    private Long categoryId4;

    @Comment("四级类目")
    @Column(length = 64)
    private String categoryName4;

    @Comment("五级类目ID")
    private Long categoryId5;

    @Comment("五级类目")
    @Column(length = 64)
    private String categoryName5;

    @Comment("税率")
    @Column
    private Integer taxRate;

    @Comment("价格")
    @Column
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
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

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
