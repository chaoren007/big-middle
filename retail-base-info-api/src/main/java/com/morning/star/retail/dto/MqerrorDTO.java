package com.morning.star.retail.dto;

import java.io.Serializable;

public class MqerrorDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2415654623413404712L;
    private String exchange;
    private String routingKey;
    private String queue;
    private String json;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
