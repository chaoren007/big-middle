package com.morning.star.retail.order.facade.order.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class IndexVo implements Serializable{

    @ApiModelProperty("实际收入模块")
    private Model1Vo model1;

    @ApiModelProperty("销售模块")
    private Model2Vo model2;

    @ApiModelProperty("退货模块")
    private Model3Vo model3;

    private Map<String, String> monthSalesPicture;

}
