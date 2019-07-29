package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务出库信息回写dto细表
 * @author kimhuhg
 */
@ApiModel
public class OutStockWmsDetailPullDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "商品编码")
    @NotNull(message = "商品编码不能为空")
    private String pcode;

    @ApiModelProperty(required = true, value = "出库数量")
    @NotNull(message = "出库数量不能为空")
    private BigDecimal count;

    @ApiModelProperty(required = true, value = "公司编码")
    @NotNull(message = "公司编码不能为空")
    private String scode;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }
}
