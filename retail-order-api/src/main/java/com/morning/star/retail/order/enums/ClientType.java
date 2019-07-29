package com.morning.star.retail.order.enums;

import java.util.Arrays;

public enum ClientType {

    ANDROID(1, "android"),
    IOS(2, "ios"),
    WAP(3, "wap"),
    PC(4, "pc"),
    POS(5, "pos");  // 条形码
    
    private final int code;
    private final String desc;
    
    private ClientType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ClientType get(Integer code) {
        if(code == null) {
            return null;
        }
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code.intValue()).findFirst().get();
    }
    
    public static ClientType parse(String value) {
        if (value.equalsIgnoreCase("IOS")){
            return IOS;
        } else if (value.equalsIgnoreCase("WAP")) {
            return WAP;
        } else if (value.equalsIgnoreCase("PC")) {
            return PC;
        } else if (value.equalsIgnoreCase("ANDROID")) {
            return ANDROID;
        }
        return null;
    }
}
