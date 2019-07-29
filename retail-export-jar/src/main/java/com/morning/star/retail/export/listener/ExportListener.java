package com.morning.star.retail.export.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.dao.ExportRecordDAO;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.ExportRecordDTO;
import com.morning.star.retail.export.util.SpringUtil;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;


/**
 * @author kimhuhg
 * @create 2018-10-15 17:53
 * @desc MQ处理统计导出
 **/
@Component
public class ExportListener {
    private static Logger logger = LoggerFactory.getLogger(ExportListener.class);

    @Autowired
    ExportRecordDAO exportRecordDAO;

    // 创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    @Value("${spring.rabbitmq.port}")
    Integer port;

    @Value("${spring.application.name}")
    private String queueName;

    /**
     * 动态消费消息
     */
    public void getCustomer() throws IOException, TimeoutException {
        //设置RabbitMQ地址
        factory.setUsername(username);
        factory.setPassword(password);
//        factory.setVirtualHost(virtualHost);
        factory.setHost(host);
        factory.setPort(port);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        //消息消费完成确认(false为手动应答)
        channel.basicConsume(queueName + "-export", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                ExportMqDTO exportMqDTO = null;

                try {
                    String message = new String(body, "UTF-8");
                    logger.info("监听查询参数："+JSON.toJSONString(message));
                    JSONObject jsonObject = JSON.parseObject(message);
                    exportMqDTO = jsonObject.toJavaObject(ExportMqDTO.class);
                    Object obj = SpringUtil.getBean(exportMqDTO.getType());
                    if (obj == null) {
                        logger.warn("该导出bean不存在："+exportMqDTO.getType());
                    } else {
                        // 获取方法
                        Method method = ReflectionUtils.findMethod(obj.getClass(),"export", ExportMqDTO.class);
                        // 设置些属性是可以访问的
                        method.setAccessible(true);
                        // 反射执行方法
                        Object result = ReflectionUtils.invokeMethod(method, obj, exportMqDTO);
                        if (result != null) {
                            update(String.valueOf(result), exportMqDTO.getId());
                        }
                    }

                }catch (Exception e) {
                    if (exportMqDTO != null) {
                        updateFailStatus(exportMqDTO.getId());
                    }
                    e.printStackTrace();
                }finally {
                    //不管消费是否成功，都删掉这条消息
                    channel.basicAck(envelope.getDeliveryTag(), true);
                }
            }
        });
    }

    public void update(String url, Long id) {
//        logger.info("导出返回地址:"+url+"(id:"+id+")");
        if (url != null) {
            ExportRecordDTO exportRecordDTO = new ExportRecordDTO();
            exportRecordDTO.setUrl(url);
            exportRecordDTO.setStatus(1);
            exportRecordDTO.setId(id);
            exportRecordDAO.update(exportRecordDTO);
        } else {//为空当做导出失败
            updateFailStatus(id);
        }
    }

    public void updateFailStatus(Long id) {
        try {
            ExportRecordDTO exportRecordDTO = new ExportRecordDTO();
            exportRecordDTO.setStatus(2);
            exportRecordDTO.setId(id);
            exportRecordDAO.update(exportRecordDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
