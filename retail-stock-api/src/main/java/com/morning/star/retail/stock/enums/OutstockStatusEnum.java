package com.morning.star.retail.stock.enums;

/**
 * 出库单审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、已出库
 *
 * @author jiangyf
 */
public enum OutstockStatusEnum {
    DRAFT(0, "草稿"), WAIT_AUDIT(10, "待审核"), AUDIT_SUCCESS(20, "已审核"), AUDIT_REJECT(30, "驳回"), OUT_STOCK(40, "已出库");

    private Integer code;
    private String desc;

    OutstockStatusEnum(Integer code, String desc) {
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

    public static OutstockStatusEnum getEnum(Integer code) {
        for (OutstockStatusEnum e : values()) {
            if (e.getCode() == (code)) {
                return e;
            }
        }
        return null;
    }
}
