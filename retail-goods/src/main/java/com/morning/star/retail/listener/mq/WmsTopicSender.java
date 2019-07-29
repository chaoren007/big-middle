package com.morning.star.retail.listener.mq;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WmsTopicSender {
    private static Logger log = LoggerFactory.getLogger(WmsTopicSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendForGoods(GoodsWmsDTO dto) {
        try {
            this.rabbitTemplate.convertAndSend("wmsexchange", "topic.ProductWmsFacadeImpl", dto);
        } catch (Exception e) {
            log.info("商品推送失败：" + JSON.toJSONString(dto));
        }

    }

}