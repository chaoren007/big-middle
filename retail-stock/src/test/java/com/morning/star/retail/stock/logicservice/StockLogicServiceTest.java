package com.morning.star.retail.stock.logicservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class StockLogicServiceTest {

    @Autowired
    private StockLogicService stockLogicService;

    @Test
    public void onlinePreStock() {
    }

    @Test
    public void checkOnlinePreStock() {
    }

    @Test
    public void onlineFreeStock() {
    }

    @Test
    public void onlineOutStock() {
    }

    @Test
    public void rejectInStock() {
    }

    @Test
    public void returnInStock() {
    }

    @Test
    public void offlineOutStock() {
    }

    @Test
    public void waitInStock() {
    }

    @Test
    public void inStock() {
    }

    @Test
    public void transferOutStock() {
        StockOrderDTO dto = new StockOrderDTO();

        dto.setGroupCode("JT00000022");
        dto.setStoreCode("GS00000036");
        dto.setOrderCode("s123456");
        dto.setStatus("0");

        List<ItemDTO> items = new ArrayList<>();
        items.add(new ItemDTO("PC180803144315001003_GS00000036", new BigDecimal(20), new BigDecimal(20), "包"));
        dto.setItems(items);

        stockLogicService.transferOutStock(dto);
    }
}