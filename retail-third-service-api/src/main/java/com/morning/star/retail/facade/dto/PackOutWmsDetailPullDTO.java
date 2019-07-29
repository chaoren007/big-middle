package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务加工出库细表回写dto细表
 * @author kimhuhg
 */
@ApiModel
public class PackOutWmsDetailPullDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "商品编码")
    @NotNull(message = "商品编码不能为空")
    private String pcode;

    @ApiModelProperty(required = true, value = "公司编码")
    @NotNull(message = "公司编码不能为空")
    private String scode;

    @ApiModelProperty(required = true, value = "入库数量")
    @NotNull(message = "入库数量")
    private BigDecimal incount;

    @ApiModelProperty(required = true, value = "商品入库单位")
    @NotNull(message = "商品入库不能为空")
    private String units;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public BigDecimal getIncount() {
        return incount;
    }

    public void setIncount(BigDecimal incount) {
        this.incount = incount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
