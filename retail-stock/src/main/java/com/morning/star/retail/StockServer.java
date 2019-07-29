package com.morning.star.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StockServer {

	public static void main(String[] args) {

		SpringApplication.run(StockServer.class, args);

	}
}
