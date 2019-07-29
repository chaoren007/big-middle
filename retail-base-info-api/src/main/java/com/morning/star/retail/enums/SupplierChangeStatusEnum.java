package com.morning.star.retail.enums;

/**
 * 供应商变更状态
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum SupplierChangeStatusEnum {
    DRAFT(0, "草稿"),
    WAIT_AUDIT(1, "待审核"),
    AUDIT_SUCCESS(2, "已审核"),
    AUDIT_FAIL(3, "已驳回");

    private Integer code;
    private String desc;

    SupplierChangeStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierChangeStatusEnum getEnum(Integer code) {
        for (SupplierChangeStatusEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
