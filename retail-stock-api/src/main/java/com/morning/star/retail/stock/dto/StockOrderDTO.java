package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 出库
 *
 * @author jiangyf
 * @date 2017/11/15
 */
public class StockOrderDTO implements Serializable {
    private static final long serialVersionUID = -7369338709416270303L;

    /**
     * 集团编码
     */
    private String groupCode;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 仓库编码
     */
    private String warehouseCode;
    /**
     * 流水单号(如：订单编号，补货编号等)
     */
    private String orderCode;
    /**
     * 流水单状态
     */
    private String status;
    /**
     * 明细
     */
    private List<ItemDTO> items;

    public StockOrderDTO() {
    }

    public StockOrderDTO(String groupCode, String storeCode, String orderCode, String status, List<ItemDTO> items) {
        this.groupCode = groupCode;
        this.storeCode = storeCode;
        this.orderCode = orderCode;
        this.status = status;
        this.items = items;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
