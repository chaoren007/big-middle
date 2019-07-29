package com.morning.star.retail.base.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商审核失败原因
 *
 * @author jiangyf
 */
public enum SupplierAuthFailReasonEnum {
    QUALIFICATION_ERROR(1, "审核资质不全（资质不符合）"),
    QUALIFICATION_IMG_ERROR(2, "上传资质图片不清晰（拍照模糊）"),
    QUALIFICATION_EXPIRED(3, "上传资质已过有效期"),
    CATEGORY_ERROR(4, "该品类暂无招商需求"),
    GOODS_ERROR(5, "商品定位与公司定位不符"),
    CITY_ERROR(6, "常驻城市不正确");

    private Integer code;
    private String desc;

    SupplierAuthFailReasonEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SupplierAuthFailReasonEnum getEnum(Integer code) {
        for (SupplierAuthFailReasonEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    private static List<Map<String, Object>> list = new ArrayList<>();

    public static List<Map<String, Object>> list() {
        if (list == null || list.isEmpty()) {
            for (SupplierAuthFailReasonEnum e : values()) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", e.getCode());
                map.put("desc", e.getDesc());
                list.add(map);
            }
        }
        return list;
    }
}
