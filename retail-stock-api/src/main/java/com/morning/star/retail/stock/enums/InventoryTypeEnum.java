package com.morning.star.retail.stock.enums;

/**
 * 盘点类型盘点类型（0：盘点货架；1：盘点仓库）
 *
 * @author jiangyf
 */
public enum InventoryTypeEnum {
    SHELF(0, "盘点货架"), WAREHOUSE(1, "盘点仓库");

    private Integer code;
    private String desc;

    InventoryTypeEnum(Integer code, String desc) {
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

    public static InventoryTypeEnum getEnum(Integer code) {
        for (InventoryTypeEnum statusEnum : values()) {
            if (statusEnum.getCode() == (code)) {
                return statusEnum;
            }
        }
        return null;
    }
}
