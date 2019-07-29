package com.morning.star.retail.test.order;

import org.junit.Test;

import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.util.Json;

public class SalesOrderPayResultTaskTest {

    
    @Test
    public void test() {
    	WebJsonBean succ = new WebJsonBean(CODE.SUCCESS, null);;
    	System.out.println(Json.toJson(succ));
    }
}
