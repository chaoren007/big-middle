package com.morning.star.retail.stock.bean;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/11/14.
 */
public class PurchaseImportResultBean implements Serializable {

    private static final long serialVersionUID = 2463667388818504001L;

    private String upc;

    private String storeCode;

    private String supplierCode;

    private String msg;

    public PurchaseImportResultBean() {
    }

    public PurchaseImportResultBean(String upc, String storeCode, String supplierCode, String msg) {
        this.upc = upc;
        this.storeCode = storeCode;
        this.supplierCode = supplierCode;
        this.msg = msg;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
