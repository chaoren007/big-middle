package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/5/31.
 */
public class ExportPurchaseRefundDTO implements Serializable {
    private static final long serialVersionUID = -8242712198014815831L;

    /**
     * 商品编码
     */
    @ExcelColumn(name = "货品编码", isExport = true)
    private String goodsCode;
    /**
     * 商品名称
     */
    @ExcelColumn(name = "货品名称", isExport = true)
    private String goodsName;
    /**
     * 条形码
     */
    @ExcelColumn(name = "upc", isExport = true)
    private String upcCode;
    /**
     * 出库数量
     */
    @ExcelColumn(name = "退货数量", isExport = true)
    private Integer refundNum;

    /**
     * 实际出库数量
     */
    @ExcelColumn(name = "实际出库数量", isExport = true)
    private Integer realNum;
    /**
     * 单位
     */
    @ExcelColumn(name = "单位", isExport = true)
    private String units;

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

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public Integer getRealNum() {
        return realNum;
    }

    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
