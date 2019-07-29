package com.morning.star.sentinel.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@SpringBootApplication
public class SentinelClusterClient {

    public static void main(String[] args) throws Exception {
    	InitExecutor.doInit();
        SpringApplication.run(SentinelClusterClient.class, args);
        
        while(true) {
        	Entry entry = null;
        	try {
        	    entry = SphU.entry("HelloWorld");
                    /*您的业务逻辑 - 开始*/
                    System.out.println("hello world");
                    /*您的业务逻辑 - 结束*/
        	} catch (BlockException e1) {
                    /*流控逻辑处理 - 开始*/
        	    System.out.println("block!");
                    /*流控逻辑处理 - 结束*/
        	} finally {
        	   if (entry != null) {
        	       entry.exit();
        	   }
        	}
        	Thread.sleep(2000);
        }
    }
}
