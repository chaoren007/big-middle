package com.morning.star.retail.stock.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.validate.ModifyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "库存-表单")
public class StockFormDTO implements Serializable {
    private static final long serialVersionUID = -298016382709475288L;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @NotNull(message = "货品编码不能为空")
    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @NotNull(message = "库存数量不能为空", groups = ModifyGroup.class)
    @Min(value = 0, message = "库存数量不能小于0")
    @ApiModelProperty(value = "在库数量")
    private BigDecimal doneInStockNum;

    /**
     * 库存流水类型
     */
    private StockRecordTypeEnum stockRecordType;
    /**
     * 库存流水单号
     */
    private String orderCode;
    /**
     * 库存流水状态
     */
    private String orderStatus;

    public void supply(AdminLoginContent content, StockRecordTypeEnum stockRecordType) {
        this.setGroupCode(content.getGroupCode());
        this.setStoreCode(content.getStoreCode());
        this.setStockRecordType(stockRecordType);
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public StockRecordTypeEnum getStockRecordType() {
        return stockRecordType;
    }

    public void setStockRecordType(StockRecordTypeEnum stockRecordType) {
        this.stockRecordType = stockRecordType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
