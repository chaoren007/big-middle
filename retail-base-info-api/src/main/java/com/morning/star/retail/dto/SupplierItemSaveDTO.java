package com.morning.star.retail.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.base.poi.ExcelColumn;
import com.morning.star.retail.validate.SaveGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商货品")
public class SupplierItemSaveDTO implements Serializable {
    private static final long serialVersionUID = -1932115876410624055L;

    @ApiModelProperty(value = "SAP货品编码")
    @NotNull(message = "SAP货品编码不能为空")
    @ExcelColumn(name = "SAP货品编码", column = "0")
    private String sapProductCode;

    @ApiModelProperty(value = "税率")
    @NotNull(message = "税率不能为空", groups = SaveGroup.class)
    @ExcelColumn(name = "税率", column = "1")
    private Integer taxRate;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为空", groups = SaveGroup.class)
    @ExcelColumn(name = "价格", column = "1")
    private BigDecimal price;

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
