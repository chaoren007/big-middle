package com.morning.star.retail.stock.enums;

/**
 * 出库类型（0：其他，1：调拨出库，2：退货出库）
 *
 * @author jiangyf
 */
public enum OutstockTypeEnum {
    OTHER(0, "其他"), TRANSFER(1, "调拨出库"), REFUND(2, "退货出库");

    private Integer code;
    private String desc;

    OutstockTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static OutstockTypeEnum getEnum(Integer code) {
        for (OutstockTypeEnum e : values()) {
            if (e.getCode() == (code)) {
                return e;
            }
        }
        return null;
    }
}
