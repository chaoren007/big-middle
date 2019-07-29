package com.morning.star.retail.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.morning.star.retail.util.RegexUtil;

/**
 * 货品导入对象
 *
 * @author jiangyf
 * @date 2017年6月13日 下午4:22:57
 */
public class GoodsImportBO implements Serializable {
    private static final long serialVersionUID = 7162192709603487837L;

    /**
     * 货品名称
     */
    private String goodsName;
    /**
     * upc
     */
    private String upcCode;
    /**
     * 一级类目
     */
    private String categoryName1;
    /**
     * 二级类目
     */
    private String categoryName2;
    /**
     * 三级类目
     */
    private String categoryName3;
    /**
     * 计量单位名称
     */
    private String unitsName;
    /**
     * 采购价
     */
    private BigDecimal purchasePrice;
    /**
     * 销售指导价
     */
    private BigDecimal guidePrice;
    /**
     * 销售价
     */
    private BigDecimal salePrice;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 品牌名称
     */
    private String brandName;

    private String originPlace;

    private Integer taxRate;

    public GoodsImportBO() {
    }

    public GoodsImportBO(String goodsName, String upcCode, String categoryName1, String categoryName2, String categoryName3,
                         String unitsName, BigDecimal purchasePrice, BigDecimal guidePrice, BigDecimal salePrice, String supplierCode,
                         String brandName,String originPlace,Integer taxRate) {
        this.goodsName = goodsName;
        this.upcCode = upcCode;
        this.categoryName1 = categoryName1;
        this.categoryName2 = categoryName2;
        this.categoryName3 = categoryName3;
        this.unitsName = unitsName;
        this.purchasePrice = purchasePrice;
        this.guidePrice = guidePrice;
        this.salePrice = salePrice;
        this.supplierCode = supplierCode;
        this.brandName = brandName;
        this.originPlace=originPlace;
        this.taxRate=taxRate;
    }

    public static GoodsImportBO of(String goodsName, String upcCode, String categoryName1, String categoryName2, String categoryName3,
                                   String unitsName, String purchasePrice, String guidePrice, String salePrice, String supplierCode,
                                   String brandName,String originPlace,String taxRate) throws Exception {
        if (StringUtils.isBlank(goodsName)) {
            throw new Exception("商品名称不能为空");
        }
        if (StringUtils.isBlank(upcCode)) {
            throw new Exception("upc不能为空");
        }
        if(upcCode.length()<3||upcCode.length()>15){
            throw new Exception("UPC长度为3-15位数字");
        }
        if (StringUtils.isBlank(categoryName1)) {
            throw new Exception("一级类目不能为空");
        }
        if (StringUtils.isBlank(categoryName2)) {
            throw new Exception("二级类目不能为空");
        }
//        if (StringUtils.isBlank(categoryName3)) {
//            throw new Exception("三级类目不能为空");
//        }
        if (StringUtils.isBlank(unitsName)) {
            throw new Exception("单位不能为空");
        }
        if (StringUtils.isBlank(purchasePrice)) {
            throw new Exception("采购价不能为空");
        }
        if (!RegexUtil.isPositiveNumber(purchasePrice)) {
            throw new Exception("采购价只能为大于0的数字");
        }
        if (StringUtils.isBlank(guidePrice)) {
            throw new Exception("销售指导价不能为空");
        }
        if (!RegexUtil.isPositiveNumber(guidePrice)) {
            throw new Exception("销售指导价只能为大于0的数字");
        }
        if (StringUtils.isBlank(salePrice)) {
            throw new Exception("销售定价不能为空");
        }
        if (!RegexUtil.isPositiveNumber(salePrice)) {
            throw new Exception("销售定价只能为大于0的数字");
        }
//        if (StringUtils.isBlank(supplierCode)) {
//            throw new Exception("供应商编码不能为空");
//        }
        if (StringUtils.isBlank(brandName)) {
            throw new Exception("品牌不能为空");
        }
        if (!RegexUtil.isRangeNumber(taxRate)) {
            //throw new Exception("税率只能为大于0的数字");
            throw new Exception("税率只能为0-99整数");
        }
        return new GoodsImportBO(goodsName, upcCode, categoryName1, categoryName2, categoryName3, unitsName,
                new BigDecimal(purchasePrice).setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(guidePrice).setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(salePrice).setScale(2, BigDecimal.ROUND_HALF_UP),
                supplierCode, brandName,originPlace,Integer.valueOf(taxRate));
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
