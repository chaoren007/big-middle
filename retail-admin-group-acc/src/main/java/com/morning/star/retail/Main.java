package com.morning.star.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.csp.sentinel.init.InitExecutor;

@SpringBootApplication
public class Main {
    
    public static void main(String[] args) {
    	InitExecutor.doInit();
        SpringApplication.run(Main.class, args);
    }
    
}
