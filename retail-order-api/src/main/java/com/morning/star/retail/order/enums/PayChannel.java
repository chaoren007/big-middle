package com.morning.star.retail.order.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.morning.star.retail.order.facade.dto.PayChannelDTO;

import javax.persistence.AttributeConverter;

public enum PayChannel {

	CASH(0,"现金支付"),
    ALI(1, "支付宝支付"),
    WX(2, "微信支付"),
    YZF(3, "翼支付"),
    UNION(4, "银联支付"),
    PERPAY(5, "预付卡"),
    HBPAY(6, "和包支付"),
    JDPAY(7,"京东支付"),
    QQPAY(8,"QQ钱包支付"),
	OTHERPAY(101, "其他支付");
    
    private final int code;
    private final String desc;
    
    PayChannel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 错误编码以及对应的错误枚举对应关系
     */
    private static Map<Integer,PayChannel> map = new HashMap<>();

    /**
     * 根据错误编码返回对应的错误枚举
     * @param code
     * @return
     */
    public static PayChannel getStatusByCode(int code){
        if(map == null || map.isEmpty()) {
            map = new HashMap<>();
            for(PayChannel status : PayChannel.values()) {
                map.put(status.getCode(), status);
            }
        }
        return map.get(code);
    }

    /**
     * 根据错误编码返回对应的错误信息
     * @param code
     * @return
     */
    public static String getName(int code){
        return getStatusByCode(code).getDesc();
    }
    
    public static List<PayChannelDTO> toList() {
        return Arrays.asList(PayChannel.values()).stream()
                .map(e -> new PayChannelDTO(e.getCode(), e.getDesc()))
                .collect(Collectors.toList());
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
