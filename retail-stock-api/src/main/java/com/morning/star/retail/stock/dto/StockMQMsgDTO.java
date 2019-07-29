package com.morning.star.retail.stock.dto;

import java.io.Serializable;

/**
 * 库存消息队列服务消息
 *
 * @author jiangyf
 * @date 2017年9月12日 下午4:09:16
 */
public class StockMQMsgDTO implements Serializable {
    private static final long serialVersionUID = 8510211560560726202L;

    /**
     * 调用服务名称
     */
    private String action;

    /**
     * 调用服务入参
     */
    private StockOrderDTO stockOrderDTO;

    public StockMQMsgDTO() {
    }

    public StockMQMsgDTO(String action, StockOrderDTO stockOrderDTO) {
        this.action = action;
        this.stockOrderDTO = stockOrderDTO;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public StockOrderDTO getStockOrderDTO() {
        return stockOrderDTO;
    }

    public void setStockOrderDTO(StockOrderDTO stockOrderDTO) {
        this.stockOrderDTO = stockOrderDTO;
    }
}
