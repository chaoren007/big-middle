package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * WMS 入库单 - 入库明细
 *
 * @author jiangyf
 */
public class WMSReceiptAddItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, value = "商品编号")
    @NotNull(message = "商品编号不能为空")
    private String pcode;

    @ApiModelProperty(required = true, value = "商品入库数量")
    @NotNull(message = "商品入库数量不能为空")
    private BigDecimal count;

    @ApiModelProperty(required = true, value = "生产日期")
    private Date pdate;

    @ApiModelProperty(required = true, value = "分公司编码")
    @NotNull(message = "分公司编码不能为空")
    private String scode;

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

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }


}
