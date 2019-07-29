package com.morning.star.retail.mq.enums;

/**
 * Created by lenovo on 2017/9/20.
 */
public enum QueueEnum {
    STOCK_SYNC("stock_sync", "同步库存");

    private String code;
    private String desc;

    private QueueEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static QueueEnum getGoodsType(String code) {
        for (QueueEnum goodsTypeEnum : values()) {
            if (goodsTypeEnum.getCode().equals(code)) {
                return goodsTypeEnum;
            }
        }
        return null;
    }
}
