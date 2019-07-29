package com.morning.star.retail.enums;

/**
 * 类目级别（0：根类目；1：一级类目；2：二级类目；3：三级类目）
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum BusOpcEnum {
    SHENZHEN("GS00000041", "sz_sz"),
    ;

    private String source;
    private String target;

    BusOpcEnum(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public static BusOpcEnum getEnum(String source) {
        for (BusOpcEnum value : values()) {
            if (value.getSource().equals(source)) {
                return value;
            }
        }
        return SHENZHEN;
    }
    public static boolean exitCode(String source){
        for (BusOpcEnum value : values()) {
            if (value.getSource().equals(source)) {
                return true;
            }
        }
        return false;
    }

}
