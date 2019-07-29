package com.morning.star.retail.dto;

import com.wms.Goods;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * 外部服务商品dto
 */
@ApiModel
public class GoodsWmsInfoDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    private List<Goods> goods;

    private List<Goods> codes;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Goods> getCodes() {
        return codes;
    }

    public void setCodes(List<Goods> codes) {
        this.codes = codes;
    }
}
