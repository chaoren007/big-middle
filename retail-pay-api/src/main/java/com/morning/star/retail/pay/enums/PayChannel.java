package com.morning.star.retail.pay.enums;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

public enum PayChannel {

    ALI_SCAN(1, "支付宝支付"),
    WX_SCAN(2, "微信支付"),
    YZF(3, "翼支付扫码"),
    UNION(4, "银联支付"),
    HBPAY(6, "和包支付"),
    JDPAY(7,"京东支付"),
    QQPAY(8,"QQ钱包支付"),

    UNKNOWN(20,"未知支付方式"),
    OTHERPAY(101,"其他支付");

    
    private final int code;
    private final String desc;
    
    private PayChannel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static PayChannel get(Integer code) {
        if(code == null) {
            return null;
        }
        return getMap().get(code);
    }
    
    private static Map<Integer, PayChannel> map;
    private static Map<Integer, PayChannel> getMap() {
        if(map != null) {
            return map;
        }
        Map<Integer, PayChannel> m = new HashMap<>();
        for(PayChannel c : values()) {
            m.put(c.getCode(), c);
        }
        map = m;
        return map;
    }
    public static class Convert implements AttributeConverter<PayChannel, Integer> {
        @Override
        public Integer convertToDatabaseColumn(PayChannel attribute) {
            return attribute == null ? null : attribute.getCode();
        }

        @Override
        public PayChannel convertToEntityAttribute(Integer dbData) {
            for (PayChannel type : PayChannel.values()) {
                if (dbData.equals(type.getCode())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }

}
