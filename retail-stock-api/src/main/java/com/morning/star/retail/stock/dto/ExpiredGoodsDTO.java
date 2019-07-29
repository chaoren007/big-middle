package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 过期商品
 * @author jiangyf
 * @date 2018/4/11
 */
public class ExpiredGoodsDTO implements Serializable {
    private static final long serialVersionUID = 1008904959846793214L;

    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "条形码")
    private String upcCode;

    @ApiModelProperty(value = "单位id")
    private String unitsId;

    @ApiModelProperty(value = "单位名称")
    private String unitsName;

    @ApiModelProperty(value = "包装规格数量")
    private Integer packSpecNum;

    @ApiModelProperty(value = "包装规格单位")
    private String packSpecUnits;

    @ApiModelProperty(value = "保质期")
    private int shelfLife;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "过期时间")
    private Date expirationDate;

    @ApiModelProperty(value = "剩余保质期")
    private int lastShelfLife;

    @ApiModelProperty(value = "在库数量")
    private int doneInStockNum;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getLastShelfLife() {
        return lastShelfLife;
    }

    public void setLastShelfLife(int lastShelfLife) {
        this.lastShelfLife = lastShelfLife;
    }

    public int getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(int doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public String getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(String unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public Integer getPackSpecNum() {
        return packSpecNum;
    }

    public void setPackSpecNum(Integer packSpecNum) {
        this.packSpecNum = packSpecNum;
    }

    public String getPackSpecUnits() {
        return packSpecUnits;
    }

    public void setPackSpecUnits(String packSpecUnits) {
        this.packSpecUnits = packSpecUnits;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
