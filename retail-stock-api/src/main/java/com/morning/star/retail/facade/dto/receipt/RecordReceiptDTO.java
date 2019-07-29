package com.morning.star.retail.facade.dto.receipt;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg on 2018/8/4.
 */
public class RecordReceiptDTO implements Serializable {
    private static final long serialVersionUID = 700733871275750587L;
    @NotNull(message = "入库细表主键id不能为空")
    @ApiModelProperty(value = "入库细表主键id")
    private Long id;
    @NotNull(message = "入库单号不能为空")
    @ApiModelProperty(value = "入库单号")
    private String receiptCode;
    @NotNull(message = "保质期不能为空")
    @ApiModelProperty(value = "保质期(天)")
    private Integer shelfLife;
    @NotNull(message = "生产日期不能为空")
    @ApiModelProperty(value = "生产日期")
    private Date productionDate;
    @NotNull(message = "收货数量不能为空")
    @ApiModelProperty(value = "收货数量")
    private BigDecimal qty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
