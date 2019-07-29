/**
 * Title: MQ 消息发送
 * fileName: HelloSender.java
 * @author Wiktor
 * @Created on 2018年9月1日 上午11:22:58
 * @version 1.0
 * @Copyright 2018 MorningStar Software Co.,Ltd. Rights Reserved.
 * @Company 深圳启明星电子商务有限公司
 */

package com.morning.star.retail.listener.mq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqMessageSender {
	
	private static final Logger log = LoggerFactory.getLogger(MqMessageSender.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
    public void send(Object obj,String mqType) {
        try {
        	rabbitTemplate.convertAndSend(mqType, obj);
		} catch (Exception e) {
			log.error("调用发送消息失败，失败原因：{}, 发送数据：{}",e.getMessage(), JSON.toJSONString(obj));
//			e.printStackTrace();
		}
    }

}
