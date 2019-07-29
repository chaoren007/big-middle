package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2018/1/5.
 */
public class ExportSellerSummaryVO implements Serializable {
    private static final long serialVersionUID = -6693854643128465195L;

    @ExcelColumn(name = "促销员", isExport = true)
    private String sellerCode;

    @ExcelColumn(name = "促销员编码", isExport = true)
    private String sellerName;

    @ExcelColumn(name = "促销订单数", isExport = true)
    private Integer saleNum;

    @ExcelColumn(name = "订单金额", isExport = true)
    private BigDecimal saleAmount = BigDecimal.ZERO;

    @ExcelColumn(name = "退款单数", isExport = true)
    private Integer refundNum;

    @ExcelColumn(name = "退款金额", isExport = true)
    private BigDecimal refundAmount = BigDecimal.ZERO;

    @ExcelColumn(name = "促销订单数", isExport = true)
    private BigDecimal sellAmount = BigDecimal.ZERO;

    @ExcelColumn(name = "门店名称", isExport = true)
    private String storeName;

    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

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

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }
}
