package com.morning.star.retail.admin.enums;

/**
 * 集团（门店）方案变更方式
 *
 * @author jiangyf
 */
public enum ChangeTypeEnum {
    ROOT_GROUP_GROUP("1", "上帝端变更集团的集团方案"),
    ROOT_GROUP_COMPANY("2", "上帝端变更集团的门店方案"),
    GROUP_COMPANY_COMPANY("3", "集团端变更门店的门店方案");

    private String code;
    private String desc;

    ChangeTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ChangeTypeEnum getEnum(String code) {
        for (ChangeTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}