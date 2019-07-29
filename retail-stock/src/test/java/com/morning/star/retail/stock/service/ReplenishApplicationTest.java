package com.morning.star.retail.stock.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.redis.Redis;
import com.morning.star.retail.StockServer;
import com.morning.star.retail.stock.application.ReplenishApplication;
import com.morning.star.retail.util.Context;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class ReplenishApplicationTest {
	@Autowired
	private ReplenishApplication replenishApplication;
	
	    @Test
	    public void submitReplenish(){
	    	Context.getBean(Redis.class);
	    
	    }
	    @Test
	    public void getReplenishList(){
	    }
	    
	    @Test
	    public void replenishDetail(){
	    }
}
