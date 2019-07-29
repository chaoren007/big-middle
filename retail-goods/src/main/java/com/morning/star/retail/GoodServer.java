package com.morning.star.retail;

import com.alibaba.csp.sentinel.init.InitExecutor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.morning.star.retail.dao")
public class GoodServer {

	public static void main(String[] args) {
		InitExecutor.doInit();
		SpringApplication.run(GoodServer.class, args);
	}
}
