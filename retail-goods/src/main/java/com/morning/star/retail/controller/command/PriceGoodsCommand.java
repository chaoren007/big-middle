package com.morning.star.retail.controller.command;

import java.math.BigDecimal;

public class PriceGoodsCommand {
    
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
