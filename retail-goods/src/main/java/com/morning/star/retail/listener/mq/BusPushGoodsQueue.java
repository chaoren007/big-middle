package com.morning.star.retail.listener.mq;

import com.morning.star.retail.facade.dto.BusProductDTO;
import org.springframework.stereotype.Component;

@Component
public class BusPushGoodsQueue extends AbstractQueue<BusProductDTO> {

    public BusPushGoodsQueue() {
        super("topic."+BusPushGoodsQueue.class.getSimpleName());
    }

}
