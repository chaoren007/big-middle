package com.morning.star.retail.stock.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.util.Json;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class GoodsHelperService {
	@Autowired
	private StockGoodsHelper goodsService;
	
	
	@Test
	public void Test1(){
		GoodsInfo goods = goodsService.getGoods("GC180322200906001027_GS00000016");
		System.out.println(Json.toJson(goods));
	}
	
	

}
