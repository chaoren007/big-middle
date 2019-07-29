package com.morning.star.retail.stock.bo;

import java.util.List;

/**
 * 出库BO
 * 
 * @author Tim
 *
 */
public class WarehouseOutBO {
    private String companyCode;
    private WarehouseBO warehouseBO;
    private List<ItemOutBO> itemOutBOs;
    private OperatorBO operatorBO;
    
    public WarehouseBO getWarehouseBO() {
        return warehouseBO;
    }
    public void setWarehouseBO(WarehouseBO warehouseBO) {
        this.warehouseBO = warehouseBO;
    }
    public List<ItemOutBO> getItemOutBOs() {
        return itemOutBOs;
    }
    public void setItemOutBOs(List<ItemOutBO> itemOutBOs) {
        this.itemOutBOs = itemOutBOs;
    }
    public OperatorBO getOperatorBO() {
        return operatorBO;
    }
    public void setOperatorBO(OperatorBO operatorBO) {
        this.operatorBO = operatorBO;
    }
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    
}
