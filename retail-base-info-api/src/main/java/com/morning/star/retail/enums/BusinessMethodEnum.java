package com.morning.star.retail.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 经营方式: 1、代销 2、经销 3、联营 4、自营
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum BusinessMethodEnum {

    AGENCY_SALE(1, "代销"),
    DISTRIBUTE_SALE(2, "经销"),
    JOINT_SALE(3, "联营"),
    SELF_SALE(4, "自营");

    private Integer code;
    private String desc;

    BusinessMethodEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BusinessMethodEnum getEnum(Integer code) {
        for (BusinessMethodEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    private static List<Map<String, Object>> list = new ArrayList<>();

    public static List<Map<String, Object>> list() {
        if (list == null || list.isEmpty()) {
            for (BusinessMethodEnum method : values()) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", method.getCode());
                map.put("desc", method.getDesc());
                list.add(map);
            }
        }
        return list;
    }

}
