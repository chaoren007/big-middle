package com.morning.star.retail.order;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.order.facade.BusOrderFacade;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/14 14:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BusItemTest {
    @Autowired
    private BusOrderFacade busOrderFacade;

    @Test
    public void test1(){
        BusOrderDTO byDealWith = busOrderFacade.getByDealWith();
        List<BusOrderDTO.Detail> detailList = byDealWith.getDetailList();
        List<Long> list = new ArrayList<>();
        for (BusOrderDTO.Detail detail : detailList) {
            list.add(detail.getId());
        }
        busOrderFacade.updateStatus(list);
    }

}
  
  
   