package com.morning.star.retail.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商-结算方式（1 指定账期，2 货到付款，3 预付款，4 返单结算，5 人工指定）
 */
public enum SettlementMethodEnum {
    SPECIFIED_ACCOUNT_PERIOD(1, "账期付款"),
    CASH_ON_DELIVERY(2, "货到付款"),
    ADVANCE_PAYMENT(3, "预付款");
    //REORDER_SETTLEMENT(4, "返单结算"),
    //MANUALLY_SPECIFIED(5, "人工指定");

    private Integer code;
    private String desc;

    SettlementMethodEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SettlementMethodEnum get(String code) {
        for (SettlementMethodEnum e : values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

    private static List<Map<String, Object>> list = new ArrayList<>();

    public static List<Map<String, Object>> list() {
        if (list == null || list.isEmpty()) {
            for (SettlementMethodEnum method : values()) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", method.getCode());
                map.put("desc", method.getDesc());
                list.add(map);
            }
        }
        return list;
    }
}
