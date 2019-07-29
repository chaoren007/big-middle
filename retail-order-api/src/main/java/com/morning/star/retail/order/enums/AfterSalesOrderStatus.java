package com.morning.star.retail.order.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liangguobin on 2017/5/18.
 */
public enum AfterSalesOrderStatus {

    WAIT_AUDIT(100,"待审核"),
    AUDIT_FAIL(110, "审核失败"),
    WAIT_EXAMINE_GOODS(120,"待验货"),
    EXAMINE_GOODS_FAIL(130,"验货失败"),
    WAIT_REFUND(140,"待退款"),
    HAS_REFUND(150,"已退款");


    private Integer code;
    private String desc;

    AfterSalesOrderStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    public static boolean isAuditResult(Integer newStatus) {
        return WAIT_EXAMINE_GOODS.getCode().equals(newStatus) ||  AUDIT_FAIL.getCode().equals(newStatus);
    }

    public static boolean isExamineGoodsResult(Integer newStatus) {
        return WAIT_REFUND.getCode().equals(newStatus) || EXAMINE_GOODS_FAIL.getCode().equals(newStatus);
    }


    public static String getDesc(Integer code) {
        if(code == null) {
            return "";
        }

        for(AfterSalesOrderStatus status :AfterSalesOrderStatus.values()) {
            if(status.getCode().equals(code)) {
                return  status.getDesc();
            }
        }
        return "";
    }

    public static boolean isFinish(Integer status) {
        return AUDIT_FAIL.getCode().equals(status) || EXAMINE_GOODS_FAIL.getCode().equals(status)
                || HAS_REFUND.getCode().equals(status);
    }


    public static boolean isFail(Integer status) {
        return AUDIT_FAIL.getCode().equals(status) || EXAMINE_GOODS_FAIL.getCode().equals(status);
    }

    public static List<Integer> failList() {
        return Arrays.asList(AUDIT_FAIL.getCode(), 
                EXAMINE_GOODS_FAIL.getCode());
    }
}
