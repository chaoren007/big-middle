package com.morning.star.retail.order.facade.order.req;

import com.morning.star.retail.order.enums.SalesOrderType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderListReqParams implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单类型")
    private SalesOrderType orderType;

    @ApiModelProperty(value = "下单开始时间")
    private Date startTime;

    @ApiModelProperty(value = "下单结束时间")
    private Date endTime;

    @ApiModelProperty(value = "购买人名称")
    private String buyerName;

    @ApiModelProperty(value = "购买人电话")
    private String buyerPhone;

    @ApiModelProperty(value = "门店code")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "订单code")
    private String orderCode;

    //============================================================

    @ApiModelProperty(value = "分组code")
    private String groupCode;

    @ApiModelProperty(value = "状态list")
    private List<Integer> statusList;

    private Integer pageNo;
    private Integer pageSize;

}
