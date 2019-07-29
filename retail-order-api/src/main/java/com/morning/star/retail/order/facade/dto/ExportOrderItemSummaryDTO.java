package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2018/3/23.
 */
public class ExportOrderItemSummaryDTO implements Serializable {
    private static final long serialVersionUID = -4828818106281532923L;

    @ExcelColumn(name = "日期", isExport = true)
    private String payTime;

    @ExcelColumn(name = "商品名称", isExport = true)
    private String goodsName;

    @ExcelColumn(name = "商品编码", isExport = true)
    private String goodsCode;

    @ExcelColumn(name = "UPC", isExport = true)
    private String upc;

    @ExcelColumn(name = "数量", isExport = true)
    private Integer num;

    @ExcelColumn(name = "类型", isExport = true)
    private String type;

    @ExcelColumn(name = "金额", isExport = true)
    private BigDecimal amount;

    @ExcelColumn(name = "一级类别", isExport = true)
    private String categoryName1;

    @ExcelColumn(name = "二级类别", isExport = true)
    private String categoryName2;

    @ExcelColumn(name = "三级类别", isExport = true)
    private String categoryName3;

    @ExcelColumn(name = "规格", isExport = true)
    private String specInfo;

    @ExcelColumn(name = "门店", isExport = true)
    private String storeName;

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
