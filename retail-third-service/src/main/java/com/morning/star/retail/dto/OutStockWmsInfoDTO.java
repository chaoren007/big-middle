package com.morning.star.retail.dto;

import com.wms.Getorder;
import com.wms.Getorderdet;
import com.wms.Putorder;
import com.wms.Putorderdet;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * 外部服务商品dto
 */
@ApiModel
public class OutStockWmsInfoDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    private List<Putorder> putorders;

    private List<Putorderdet> putorderdets;

    public List<Putorder> getPutorders() {
        return putorders;
    }

    public void setPutorders(List<Putorder> putorders) {
        this.putorders = putorders;
    }

    public List<Putorderdet> getPutorderdets() {
        return putorderdets;
    }

    public void setPutorderdets(List<Putorderdet> putorderdets) {
        this.putorderdets = putorderdets;
    }
}
