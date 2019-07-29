package com.morning.star.retail.dto;

import com.wms.Getorder;
import com.wms.Getorderdet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 外部服务商品dto
 */
@ApiModel
public class PurchaseWmsInfoDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    private List<Getorder> getorder;

    private List<Getorderdet> getorderdets;

    public List<Getorder> getGetorder() {
        return getorder;
    }

    public void setGetorder(List<Getorder> getorder) {
        this.getorder = getorder;
    }

    public List<Getorderdet> getGetorderdets() {
        return getorderdets;
    }

    public void setGetorderdets(List<Getorderdet> getorderdets) {
        this.getorderdets = getorderdets;
    }
}
