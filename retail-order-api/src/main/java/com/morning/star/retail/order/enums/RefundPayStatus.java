package com.morning.star.retail.order.enums;

public enum RefundPayStatus {
    WAIT_REFUND(0, "待退款"),
    OFFLINE_REFUND(1, "线下成功"),  // 线下

//    WAIT_ASK(10, "未调用请求"),

    WAIT_PAY(20, "退款中"),
    ASK_FAIL(30, "请求失败"),
    REFUND_SUCCESS(40, "退款成功"),
    REFUND_FAIL(50, "退款失败"),
    UNSUPPORTED(60,"不支持线上退款"),
    ;



    private Integer code;
    private String desc;


    RefundPayStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;

    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }

    public static String getDesc(int code) {
        for(RefundPayStatus status : values()) {
            if(code == status.code) {
                return status.desc;
            }
        }
        return "";
    }

    public static RefundPayStatus getStatus(int code) {
        for(RefundPayStatus status : values()) {
            if(code == status.code) {
                return status;
            }
        }
        return null;
    }

    /**
     * 这里，线下退款和线上退款成功都是success
     * @return
     */
    public static boolean isSuccess(Integer code) {
        if(code == OFFLINE_REFUND.getCode() || code == REFUND_SUCCESS.getCode()) {
            return true;
        }

        return false;
    }

    /**
     * 这里请求失败和退款失败都是fail
     * @param code
     * @return
     */
    public static boolean isFail(Integer code) {
        if(code == ASK_FAIL.getCode() || code == REFUND_FAIL.getCode()) {
            return true;
        }

        return false;
    }
}
