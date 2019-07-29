package com.morning.star.retail.test;

import com.alibaba.fastjson.JSON;
import com.morning.star.redis.Redis;
import com.morning.star.retail.PushMsgServer;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.util.Context;
import com.morning.star.retail.util.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ethan
 * @create_time 2018/9/25 9:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PushMsgServer.class)
public class RedisTest {
	@Test
	public void getUser() {
		AdminLoginContent userInfo = UserUtils.getUserInfo("GG7q6bPk");
		System.out.print(JSON.toJSONString(userInfo));
	}

	@Test
	public void get() {
		String result = Context.getBean(Redis.class).get("2cc143a7-b408-49cb-b406-7968d8548a73");
		System.out.print(result);
	}
}
