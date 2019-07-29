package com.morning.star.retail;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.morning.star.retail.async.AsyncSetterFactory;

@SpringBootApplication
public class OrderServer {
    @Bean
    public Executor asyncSetterThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(150);
        executor.setMaxPoolSize(500);
        executor.setQueueCapacity(80);
        executor.setThreadNamePrefix("order-asyncSetter-executor-");
        executor.initialize();
        return executor;
    }

    @Bean
    public AsyncSetterFactory asyncSetterFactoryBean() {
        return new AsyncSetterFactory(asyncSetterThreadPool(), 10);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class, args);
    }
}
