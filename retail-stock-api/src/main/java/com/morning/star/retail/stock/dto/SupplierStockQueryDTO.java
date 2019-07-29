package com.morning.star.retail.stock.dto;

import com.morning.star.retail.stock.bean.SupplierStockDO;

import java.io.Serializable;

/**
 * 供应商库存
 *
 * @author jiangyf
 * @date 2017/11/15
 */
public class SupplierStockQueryDTO implements Serializable {
    private static final long serialVersionUID = -7654643474484227941L;

    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 门店编码
     */
    private String storeCode;

    /**
     * 货品编码
     */
    private String goodsCode;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 供应商编码
     */
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 条形码
     */
    private String upcCode;

    /**
     * 销售类型（0：自营；1：代销）
     */
    private Integer salesType;

    public SupplierStockQueryDTO() {
    }

    public SupplierStockQueryDTO(String companyCode, String storeCode, String goodsCode, String goodsName, String supplierCode, String supplierName, String upcCode, Integer salesType) {
        this.companyCode = companyCode;
        this.storeCode = storeCode;
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.upcCode = upcCode;
        this.salesType = salesType;
    }

    public static SupplierStockQueryDTO of(String companyCode, String storeCode, String goodsCode, String supplierCode, Integer salesType) {
        return new SupplierStockQueryDTO(companyCode, storeCode, goodsCode, null, supplierCode, null, null, salesType);
    }

    public static SupplierStockQueryDTO from(SupplierStockDO supplierStockDO) {
        return new SupplierStockQueryDTO(supplierStockDO.getCompanyCode(), supplierStockDO.getStoreCode(), supplierStockDO.getGoodsCode(), null, supplierStockDO.getSupplierCode(), null, null, supplierStockDO.getSalesType());
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
    }
}
