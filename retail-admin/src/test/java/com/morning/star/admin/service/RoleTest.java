package com.morning.star.admin.service;

import com.morning.star.retail.Main;
import com.morning.star.retail.admin.application.RoleApplication;
import com.morning.star.retail.admin.bean.RoleDO;
import com.morning.star.retail.admin.facade.RoleFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author ethan
 * @create_time 2018/8/11 14:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class RoleTest {
	@Autowired
	private RoleFacade roleFacade;
	@Autowired
	private RoleApplication roleApplication;

	@Test
	public void test(){
		RoleDO roleDO = new RoleDO();
		roleDO.setName("test");
		roleDO.setClassify("group");
		roleDO.setDescription("test");
		roleApplication.create(roleDO);
	}

	@Test
	public void test1(){
		RoleDO roleDO = new RoleDO();
		roleDO.setId(272L);
		roleApplication.delete(roleDO);
	}
}
