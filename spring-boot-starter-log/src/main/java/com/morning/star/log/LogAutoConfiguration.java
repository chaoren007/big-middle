package com.morning.star.log;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name="logging.around.pattern")
public class LogAutoConfiguration {

    @Bean
    public MethodAroundLoggerAspect methodAspect() {
        return new MethodAroundLoggerAspect();
    }

    public DubboContextFilter dubboContextFilter() {
        return new DubboContextFilter();
    }
}
