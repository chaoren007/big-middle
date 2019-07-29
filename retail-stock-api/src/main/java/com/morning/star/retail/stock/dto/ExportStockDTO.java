package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 导出库存数据
 *
 * @author jiangyf
 * @date 2017年9月20日 下午5:41:19
 */
public class ExportStockDTO implements Serializable {
    private static final long serialVersionUID = 1054224194525100107L;

    @ExcelColumn(name = "货品编码", isExport = true)
    private String productCode;

    @ExcelColumn(name = "货品名称", isExport = true)
    private String productName;

    @ExcelColumn(name = "upc", isExport = true)
    private String upcCode;

    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

    @ExcelColumn(name = "门店名称", isExport = true)
    private String storeName;

    @ExcelColumn(name = "门店库存", isExport = true)
    private BigDecimal doneInStockNum;

    @ExcelColumn(name = "库存成本", isExport = true)
    private BigDecimal costPrice;

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

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
