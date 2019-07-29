package com.morning.star.retail.stock.bo;

import java.math.BigDecimal;

/**
 * 入库物品
 *
 * @author Tim
 */
public class ItemInBO {

    private String goodsName; // 货品名称
    private String goodsId; // 货品编号
    private String goodsUnit; // 货品单位
    private String goodsSpec; // 货品规格
    private String serialId; // 序列号
    private String barCode; // 条形码
    private String purchaseId; // 采购单号
    private String replenishId; // 补货单号
    private BigDecimal purchasePrice; // 采购价
    private String inId; // 入库单号
    private String provider; // 供应商编号
    private String providerName; // 供应商名称

    private boolean serialCode; // 是否序列号管理

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getReplenishId() {
        return replenishId;
    }

    public void setReplenishId(String replenishId) {
        this.replenishId = replenishId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isSerialCode() {
        return serialCode;
    }

    public void setSerialCode(boolean serialCode) {
        this.serialCode = serialCode;
    }


}
