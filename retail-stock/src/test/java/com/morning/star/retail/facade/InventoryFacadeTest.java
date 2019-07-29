package com.morning.star.retail.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.morning.star.retail.StockServer;
import com.morning.star.retail.stock.dto.InventoryDTO;
import com.morning.star.retail.stock.dto.InventoryFormDTO;
import com.morning.star.retail.stock.dto.InventoryItemQueryDTO;
import com.morning.star.retail.stock.dto.InventoryItemSubmitDTO;
import com.morning.star.retail.stock.dto.InventoryQueryDTO;
import com.morning.star.retail.stock.dto.InventoryStatementQueryDTO;
import com.morning.star.retail.stock.dto.InventorySubmitDTO;
import com.morning.star.retail.stock.enums.InventoryTypeEnum;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.page.PageBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class InventoryFacadeTest {

    @Autowired
    private InventoryFacade inventoryFacade;

    @Test
    public void create() {
        InventoryFormDTO formDTO = new InventoryFormDTO();
        formDTO.setInventoryCode(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PD));
        formDTO.setInventoryName("一次伟大的盘点");
        formDTO.setRemark("一次伟大的盘点");

        List<String> list = new ArrayList<>();
        list.add("PC180810174047001005_GS00000043");
        list.add("PC180811145858001001_GS00000043");
        formDTO.setGoodsCodes(list);

        inventoryFacade.create(formDTO);
    }

    @Test
    public void submit() {
        InventorySubmitDTO submitDTO = new InventorySubmitDTO();
        submitDTO.setInventoryCode("PD180818145505001000");

        List<InventoryItemSubmitDTO> list = new ArrayList<>();
        InventoryItemSubmitDTO item = new InventoryItemSubmitDTO();
        item.setGoodsCode("PC180810174047001005_GS00000043");
        item.setNum(new BigDecimal(100));

        InventoryItemSubmitDTO item2 = new InventoryItemSubmitDTO();
        item2.setGoodsCode("PC180811145858001001_GS00000043");
        item2.setNum(new BigDecimal(100));

        submitDTO.setType(InventoryTypeEnum.SHELF.getCode());


        inventoryFacade.submit(submitDTO);
    }

    @Test
    public void save() {
        InventorySubmitDTO submitDTO = new InventorySubmitDTO();
        submitDTO.setInventoryCode("PD180818145505001000");

        List<InventoryItemSubmitDTO> list = new ArrayList<>();
        InventoryItemSubmitDTO item = new InventoryItemSubmitDTO();
        item.setGoodsCode("PC180810174047001005_GS00000043");
        item.setNum(new BigDecimal(100));

        InventoryItemSubmitDTO item2 = new InventoryItemSubmitDTO();
        item2.setGoodsCode("PC180811145858001001_GS00000043");
        item2.setNum(new BigDecimal(100));

        submitDTO.setType(InventoryTypeEnum.SHELF.getCode());


        inventoryFacade.save(submitDTO);
    }

    @Test
    public void list() {
        InventoryQueryDTO queryDTO = new InventoryQueryDTO();
        queryDTO.setGroupCode("JT00000030");
        queryDTO.setStoreCode("GS00000043");
        PageBean<InventoryDTO> list = inventoryFacade.list(queryDTO);
    }

    @Test
    public void get() {
        InventoryItemQueryDTO queryDTO = new InventoryItemQueryDTO();
        queryDTO.setGroupCode("JT00000030");
        queryDTO.setStoreCode("GS00000043");
        queryDTO.setInventoryCode("PD180818145505001000");
        InventoryDTO dto = inventoryFacade.get(queryDTO);
    }

    @Test
    public void batchRead() {
    }

    @Test
    public void auditSucc() {
    }

    @Test
    public void auditFail() {
    }

    @Test
    public void queryExportAllItem() {
    }

    @Test
    public void queryExportWarnItem() {
    }

    @Test
    public void createStatement() {
        inventoryFacade.createStatement("PD180822191015001003", false);
    }

    @Test
    public void formalStatement() {
        inventoryFacade.createStatement("PD180822191015001003", true);
    }

    @Test
    public void confirmStatement() {
        inventoryFacade.confirmStatement("PD180822191015001003");
    }

    @Test
    public void cancelStatement() {
        inventoryFacade.cancelStatement("PD180822191015001003");
    }

    @Test
    public void archiveStatement() {
        inventoryFacade.archiveStatement("PD180822191015001003");
    }

    @Test
    public void queryStatement() {
        inventoryFacade.queryStatement("PD180822191015001003");
    }

    @Test
    public void queryStatementItem() {
        InventoryStatementQueryDTO queryDTO = new InventoryStatementQueryDTO();
        queryDTO.setStatementCode("CDD180823110633001000");
        inventoryFacade.queryStatementItem(queryDTO);
    }
}