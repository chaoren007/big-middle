package com.morning.star.retail.stock.enums;

/**
 * Created by lenovo on 2018/5/23.
 */
public enum ReturnReasonEnum {
    SUBSTANDARD_QUALITY(0, "品质不达标"),DAMAGED_GOOD(1, "货品损坏"), OTHER(2, "其他");

    private int code;
    private String desc;

    private ReturnReasonEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ReturnReasonEnum getReceiptStatus(int code) {
        for (ReturnReasonEnum ReturnReasonEnum : values()) {
            if (ReturnReasonEnum.getCode() == (code)) {
                return ReturnReasonEnum;
            }
        }
        return null;
    }
}
