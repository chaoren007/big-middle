package com.morning.star.retail.facade.dto.receipt;

import com.morning.star.retail.base.poi.ExcelColumn;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by kimhuhg on 2018/8/4.
 * 保存商品串码
 */
public class ReceiptImeiDTO implements Serializable {
    private static final long serialVersionUID = 700733871275750587L;

    @ExcelColumn(name = "商品编码", column = "0")
    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ExcelColumn(name = "商品名称", column = "1")
    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ExcelColumn(name = "串码", column = "2")
    @ApiModelProperty(value = "串码")
    private String imei;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
