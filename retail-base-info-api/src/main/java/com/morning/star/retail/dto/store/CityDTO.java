package com.morning.star.retail.dto.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("城市")
public class CityDTO implements Serializable {
    private static final long serialVersionUID = -5886149595928713815L;

    @ApiModelProperty("城市id")
    private Long cityId;

    @ApiModelProperty("城市名称")
    private String cityName;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
