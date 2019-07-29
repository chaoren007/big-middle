package com.morning.star.retail.order.facade.order.resp;

import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import com.morning.star.retail.order.facade.order.dto.PaymentDTO;
import com.morning.star.retail.order.facade.order.dto.SalesOrderOperationDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SalesOrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单code")
    private String orderCode;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "商品总个数")
    private BigDecimal totalBuyNum;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "门店code")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "集团code")
    private String groupCode;

    @ApiModelProperty(value = "集团名称")
    private String groupName;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "购买人code")
    private String buyerCode;

    @ApiModelProperty(value = "购买人名称")
    private String buyerName;

    @ApiModelProperty(value = "购买人电话")
    private String buyerPhone;

    @ApiModelProperty(value = "购买备注")
    private String remark;

    @ApiModelProperty(value = "是否关闭")
    private boolean canceling;

    @ApiModelProperty(value = "订单类型  0：线上    1：线下")
    private Integer orderType;

    @ApiModelProperty(value = "下单时间")
    private String orderTime;

    @ApiModelProperty(value = "商品列表")
    private List<OrderGoodsItemDTO> items = new ArrayList<>();

    @ApiModelProperty(value = "操作记录")
    private List<SalesOrderOperationDTO> operation = new ArrayList<>();

    @ApiModelProperty(value = "支付信息,可能存在混合支付，所以是个list")
    private List<PaymentDTO> payment;


}
