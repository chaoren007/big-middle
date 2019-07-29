package com.morning.star.retail.enums;

/**
 * 类目级别（0：根类目；1：一级类目；2：二级类目；3：三级类目）
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum CategoryLevelEnum {
    ROOT(0, "根类目"),
    FIRST(1, "一级类目"),
    SECOND(2, "二级类目"),
    THIRD(3, "三级类目"),
    FOUR(4,"四级类目"),
    FIVE(5,"五级类目");

    private Integer code;
    private String desc;

    CategoryLevelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CategoryLevelEnum getEnum(Integer code) {
        for (CategoryLevelEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
