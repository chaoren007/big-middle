package com.morning.star.retail.order.facade.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SalesOrderOperationDTO implements Serializable {

    private String operationId;

    private String operationName;

    private String operationContent;

    private String operationTime;

    private Integer orderStatus;



}
