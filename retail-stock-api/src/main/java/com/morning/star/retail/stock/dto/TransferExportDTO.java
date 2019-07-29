package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 调拨商品
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class TransferExportDTO implements Serializable {
    private static final long serialVersionUID = 6177930044594156802L;

    @ExcelColumn(name = "商品编码", isExport = true)
    private String goodsCode;

    @ExcelColumn(name = "商品名称", isExport = true)
    private String productName;

    @ExcelColumn(name = "upc", isExport = true)
    private String upcCode;

    @ExcelColumn(name = "调拨数量", isExport = true)
    private BigDecimal num;

    @ExcelColumn(name = "单位", isExport = true)
    private String unitsName;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }
}
