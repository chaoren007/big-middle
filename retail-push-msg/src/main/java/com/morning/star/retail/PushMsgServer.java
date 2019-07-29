package com.morning.star.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Dell on 2018/7/17.
 */
@SpringBootApplication
public class PushMsgServer {

	public static void main(String[] args) {
		SpringApplication.run(PushMsgServer.class, args);
	}

//    @Bean
//    public NettyServerBootstrap createSocketLine() throws InterruptedException {
//        return new NettyServerBootstrap();
//    }
}
