package com.morning.star.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@ImportResource(locations={"classpath:application-soa.xml"})
@ConditionalOnResource(resources={"classpath:application-soa.xml"})
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {
    
    @Autowired
    private DubboProperties dubboProperties;

    @Bean
    public ApplicationConfig requestApplicationConfig() {
        return dubboProperties.getApplication();
    }

    @Bean
    public RegistryConfig requestRegistryConfig() {
        return dubboProperties.getRegistry();
    }

    @Bean
    public ProtocolConfig requestProtocolConfig() {
        return dubboProperties.getProtocol();
    }
    

    @ConditionalOnProperty(prefix = "spring.jpa", name = "open-in-dubbo", havingValue = "true", matchIfMissing = true)
    @Bean
    public OpenEntityManagerInDubbo openEntityManagerInDubbo() {
        return new OpenEntityManagerInDubbo();
    }
}
