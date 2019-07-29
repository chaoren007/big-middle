package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * 导出盘点明细
 *
 * @author jiangyf
 * @date 2017年9月20日 下午1:52:42
 */
public class ExportInventoryItemDTO implements Serializable {
    private static final long serialVersionUID = 7885122055258773408L;

    /**
     * 门店编码
     */
    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

    /**
     * 门店名称
     */
    @ExcelColumn(name = "门店名称", isExport = true)
    private String storeName;

    /**
     * 商品名称
     */
    @ExcelColumn(name = "商品名称", isExport = true)
    private String goodsName;

    /**
     * 商品编码
     */
    @ExcelColumn(name = "商品编码", isExport = true)
    private String goodsCode;

    /**
     * UPC
     */
    @ExcelColumn(name = "upc", isExport = true)
    private String upcCode;

    /**
     * 系统库存
     */
    @ExcelColumn(name = "系统库存", isExport = true)
    private BigDecimal systemAmount;

    /**
     * 盘点库存
     */
    @ExcelColumn(name = "盘点库存", isExport = true)
    private BigDecimal realAmount;

    /**
     * 单位
     */
    @ExcelColumn(name = "单位", isExport = true)
    private String units;

    /**
     * 盘点结果
     */
    @ExcelColumn(name = "盘点结果", isExport = true)
    private String status;

    /**
     * 差值 = 人工盘点库存 - 系统库存
     */
    @ExcelColumn(name = "差值", isExport = true)
    private BigDecimal amount;


  

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

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public BigDecimal getSystemAmount() {
        return systemAmount;
    }

    public void setSystemAmount(BigDecimal systemAmount) {
        this.systemAmount = systemAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
