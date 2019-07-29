package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 外部服务仓库dto
 */
@ApiModel
public class StorageWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "分部编码")
    private String storeCode;

    @ApiModelProperty(required = true, value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty("城市名称")
    private String cityName;

    @ApiModelProperty("城市id")
    private Long cityId;

    @ApiModelProperty(required = true, value = "仓库编码")
    private String warehouseCode;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}
