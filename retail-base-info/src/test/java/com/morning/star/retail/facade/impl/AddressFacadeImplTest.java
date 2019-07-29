package com.morning.star.retail.facade.impl;

import com.morning.star.retail.Main;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.facade.AddressFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author ethan
 * @create_time 2019/5/27 10:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class AddressFacadeImplTest {

	@Autowired
	private AddressFacade addressFacade;

	@Test
	public void getAll() {
		List<AddressDTO> all = addressFacade.getAll();
		assertTrue(all.size() > 0);
	}

}