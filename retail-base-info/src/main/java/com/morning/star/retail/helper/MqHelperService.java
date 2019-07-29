package com.morning.star.retail.helper;

import com.morning.star.retail.dto.MqerrorDTO;
import com.morning.star.retail.facade.MqErrorFacade;
import com.morning.star.retail.mq.MessageWithUserPostProcessor;
import com.morning.star.retail.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/8/20 11:44
 */
@Service
public class MqHelperService {
	private Logger log = LoggerFactory.getLogger(MqHelperService.class);
	@Autowired
	private MqErrorFacade mqErrorFacade;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 透传用户信息，catch到异常，存入mysql ， 可用其他数据库代替
	 *
	 * @param exchange
	 * @param routingKey
	 * @param msg
	 */
	public void send(String exchange, String routingKey, Object msg) {
		log.info("========================================发送消息队列:" + routingKey);
		try {
			rabbitTemplate.convertAndSend(routingKey, msg, new MessageWithUserPostProcessor());
		} catch (Exception e) {
			MqerrorDTO error = new MqerrorDTO();
			error.setExchange(exchange);
			error.setRoutingKey(routingKey);
			error.setQueue(routingKey);
			error.setJson(Json.toJson(msg));
			mqErrorFacade.insert(error);
		}
	}
}
