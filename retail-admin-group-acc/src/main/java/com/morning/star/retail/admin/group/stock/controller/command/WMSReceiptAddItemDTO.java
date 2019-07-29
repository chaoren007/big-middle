package com.morning.star.retail.admin.group.stock.controller.command;

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

    /**
     * 商品编号
     */
    private String pcode;
    /**
     * 商品入库数量
     */
    private BigDecimal count;
    /**
     * 商品入库单位
     */
    private String units;
    /**
     * 生产日期
     */
    private Date pdate;

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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }
}
