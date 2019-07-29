package com.morning.star.retail.base.enums;

/**
 * 供应商申请状态
 *
 * @author jiangyf
 */
public enum SupplierApplyStatusEnum {
    SUBMIT(0, "已提交"), AUTH_PASS(1, "审核通过"), AUTH_FAIL(2, "审核失败");

    private Integer code;
    private String desc;

    private SupplierApplyStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierApplyStatusEnum getEnum(Integer code) {
        for (SupplierApplyStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
