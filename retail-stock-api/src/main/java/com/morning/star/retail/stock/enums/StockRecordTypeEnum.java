package com.morning.star.retail.stock.enums;

/**
 * 库存流水记录类型
 *
 * @author jiangyf
 */
public enum StockRecordTypeEnum {
    ADMIN_ADD("ADMIN_ADD", "后台添加库存"),
    ADMIN_IMPORT("ADMIN_IMPORT", "后台导入库存"),
    ADMIN_MODIFY("ADMIN_MODIFY", "后台修改库存"),
    MANUAL_MODIFY("MANUAL_MODIFY", "手动修改库存"),
    STORE_MODIFY("ADMIN_MODIFY", "门店修改库存"),
    ADMIN_SYNC("ADMIN_SYNC", "后台同步数据"),
    INVENTORY("INVENTORY", "库存盘点"),

    ONLINE_PRE("ONLINE_PRE", "线上预占库存"),
    ONLINE_WAIT_OUT("ONLINE_WAIT_OUT", "线上待发库存"),
    ONLINE_FREE_PRE("ONLINE_FREE_PRE", "线上释放预占库存"),
    ONLINE_FREE_WAIT_OUT("ONLINE_FREE_WAIT_OUT", "线上释放待发库存"),
    ONLINE_OUT("ONLINE_OUT", "线上销售出库"),
    OFFLINE_OUT("OFFLINE_OUT", "线下销售出库"),
    MANUAL_OUT("MANUAL_OUT", "人工手动出库"),
    RETURN_OUT("RETURN_OUT", "退货供应商出库"),
    WASTE_OUT("WASTE_OUT", "货品折损出库"),
    TRANSFER_OUT("TRANSFER_OUT", "门店调拨出库"),
    INVENTORY_LOSS_OUT("INVENTORY_LOSS_OUT", "门店盘亏出库"),

    PURCHASE_WAIT_IN("PURCHASE_WAIT_IN", "门店采购待入库"),
    PURCHASE_IN("PURCHASE_IN", "门店采购入库"),
    REPLENISH_IN("REPLENISH_IN", "总部补货入库"),
    MANUAL_IN("MANUAL_IN", "人工手动入库"),
    REJECT_IN("REJECT_IN", "客户拒收入库"),
    RETURN_IN("RETURN_IN", "客户退货入库"),
    TRANSFER_WAIT_IN("TRANSFER_WAIT_IN", "调拨待入库"),
    TRANSFER_IN("TRANSFER_IN", "调拨入库"),
    TRANSFER_RETURN("TRANSFER_RETURN", "调拨退回入库"),
    INVENTORY_PROFIT_IN("INVENTORY_PROFIT_IN", "门店盘盈入库"),
    OTHER_IN("OTHER_IN", "其它入库");

    private String code;
    private String desc;

    private StockRecordTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static StockRecordTypeEnum get(String code) {
        for (StockRecordTypeEnum stockRecordTypeEnum : values()) {
            if (stockRecordTypeEnum.getCode().equals(code)) {
                return stockRecordTypeEnum;
            }
        }
        return null;
    }

}
