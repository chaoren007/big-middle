package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;

/**
 * 库存-导入
 *
 * @author jiangyf
 */
public class StockImportDTO implements Serializable {
    private static final long serialVersionUID = -298016382709475288L;

    @ExcelColumn(name = "商品编码", column = "0")
    private String goodsCode;

    @ExcelColumn(name = "门店编码", column = "1")
    private String storeCode;

    @ExcelColumn(name = "门店库存", column = "2")
    private String doneInStockNum;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(String doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }
}
