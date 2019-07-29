package com.morning.star.retail.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过导入类型
 *
 * @author zhouwen
 */
public enum NoticeType {


    /**
     * 通过邮件通知
     */
    EMAIL("1", "通过邮件通知"),

    /**
     * 通过短息通知
     */
    PHONE("2", "通过短息通知"),

    /**
     * 通过企业微信通知
     */
    QYWX("3", "通过企业微信通知"),


    /**
     * 通过微信通知
     */
    WX("3", " 通过微信通知");


    /**
     * 通知编码
     */
    private String code;
    /**
     * 通知方式描述
     */
    private String msg;


    /**
     * 错误代码基类
     *
     * @param code 错误编码
     * @param msg  错误描述
     */
    NoticeType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 错误编码以及对应的错误枚举对应关系
     */
    private static Map<String, NoticeType> codeEnumMap = new HashMap<String, NoticeType>();


    /**
     * 根据编码获取通知方式
     *
     * @param code
     * @return
     */
    public NoticeType getValueByCode(String code) {

        if (codeEnumMap.isEmpty()) {
            for (NoticeType error : NoticeType.values()) {
                codeEnumMap.put(error.getValue(), error);
            }
        }
        return codeEnumMap.get(code);
    }

    /**
     * 通知编码
     *
     * @return
     */
    public String getValue() {
        return code;
    }

    /**
     * 通知描述
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

}
