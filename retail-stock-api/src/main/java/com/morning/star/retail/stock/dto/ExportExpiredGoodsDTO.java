package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.util.Date;

/**
 * 过期货品导出
 *
 * @author kimhuhg
 */
public class ExportExpiredGoodsDTO implements Serializable {
    private static final long serialVersionUID = 6957903682293573682L;

    @ExcelColumn(name = "入库单号")
    private String receiptCode;

    @ExcelColumn(name = "集团编码")
    private String groupCode;

    @ExcelColumn(name = "门店编码")
    private String storeCode;

    @ExcelColumn(name = "门店名称")
    private String storeName;

    @ExcelColumn(name = "货品编码")
    private String goodsCode;

    @ExcelColumn(name = "条形码")
    private String upcCode;

    @ExcelColumn(name = "单位id")
    private String unitsId;

    @ExcelColumn(name = "单位名称")
    private String unitsName;

    @ExcelColumn(name = "包装规格数量")
    private Integer packSpecNum;

    @ExcelColumn(name = "包装规格单位")
    private String packSpecUnits;

    @ExcelColumn(name = "保质期")
    private int shelfLife;

    @ExcelColumn(name = "生产日期")
    private Date productionDate;

    @ExcelColumn(name = "过期时间")
    private Date expirationDate;

    @ExcelColumn(name = "剩余保质期")
    private int lastShelfLife;

    @ExcelColumn(name = "在库数量")
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
}
