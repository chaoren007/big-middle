package com.morning.star.retail.stock.bo;

import java.util.List;

/**
 * 入库BO
 * 
 * @author Tim
 *
 */
public class WarehouseInBO {
    private String companyCode;
    private WarehouseBO warehouseBO;
    private List<ItemInBO> itemInBOs;
    private OperatorBO operatorBO;
    
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    public WarehouseBO getWarehouseBO() {
        return warehouseBO;
    }
    public void setWarehouseBO(WarehouseBO warehouseBO) {
        this.warehouseBO = warehouseBO;
    }
    public List<ItemInBO> getItemInBOs() {
        return itemInBOs;
    }
    public void setItemInBOs(List<ItemInBO> itemInBOs) {
        this.itemInBOs = itemInBOs;
    }
    public OperatorBO getOperatorBO() {
        return operatorBO;
    }
    public void setOperatorBO(OperatorBO operatorBO) {
        this.operatorBO = operatorBO;
    }
}
