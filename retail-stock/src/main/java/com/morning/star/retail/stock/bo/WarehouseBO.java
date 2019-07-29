package com.morning.star.retail.stock.bo;

/**
 * 门店/仓库
 * 
 * @author Tim
 *
 */
public class WarehouseBO {

    private String id;
    private String name;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static WarehouseBO of(String id, String name) {
        WarehouseBO warehouseBO = new WarehouseBO();
        warehouseBO.setId(id);
        warehouseBO.setName(name);
        return warehouseBO;
    }
    
    
}
