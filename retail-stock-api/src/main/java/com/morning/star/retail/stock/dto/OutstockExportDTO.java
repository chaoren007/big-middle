package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * 出库商品
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutstockExportDTO implements Serializable {
    private static final long serialVersionUID = 6177930044594156802L;

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
     * 需求出库数量
     */
    @ExcelColumn(name = "需求出库数量", isExport = true)
    private BigDecimal initialNum;
    /**
     * 实际出库数量
     */
    @ExcelColumn(name = "实际出库数量", isExport = true)
    private BigDecimal realNum;
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

    public BigDecimal getInitialNum() {
        return initialNum;
    }

    public void setInitialNum(BigDecimal initialNum) {
        this.initialNum = initialNum;
    }

    public BigDecimal getRealNum() {
        return realNum;
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
