package com.morning.star.retail.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 货品销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum GoodsSalesTypeEnum {
    ONLY_SELF_SALES(0, "仅自营"),
    ONLY_AGENT_SALES(1, "仅代销"),
    SELF_AGENT_SALES(2, "先自营后代销"),
    AGENT_SELF_SALES(3, "先代销后自营");

    private Integer code;
    private String desc;

    private GoodsSalesTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static GoodsSalesTypeEnum getEnum(Integer code) {
        for (GoodsSalesTypeEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    public static List<Map<Integer, String>> list() {
        List<Map<Integer, String>> list = new ArrayList<>();
        for (GoodsSalesTypeEnum value : values()) {
            Map<Integer, String> map = new HashMap<>();
            map.put(value.getCode(), value.getDesc());
            list.add(map);
        }
        return list;
    }

}
