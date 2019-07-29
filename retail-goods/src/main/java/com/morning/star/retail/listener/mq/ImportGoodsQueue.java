package com.morning.star.retail.listener.mq;

import com.morning.star.retail.facade.dto.GoodsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportGoodsQueue extends AbstractQueue<List<GoodsDTO>> {

    public ImportGoodsQueue() {
        super(ImportGoodsQueue.class.getSimpleName());
    }

}
