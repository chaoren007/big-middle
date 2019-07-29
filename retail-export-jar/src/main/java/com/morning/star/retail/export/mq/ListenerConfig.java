package com.morning.star.retail.export.mq;

import com.morning.star.retail.export.listener.ExportListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: kimhuhg
 * @Date: 18-11-13 上午10:50
 * @desc:
 */
@Configuration
public class ListenerConfig implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ExportListener exportListener;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {  //项目启动后，执行启动消费者方法
        try {
            exportListener.getCustomer();   //消费者的实现方法
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
