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
import com.morning.star.retail.stock.dto.TransferDTO;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.dto.TransferQueryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServer.class)
public class TransferFacadeTest {

    @Autowired
    private TransferFacade transferFacade;

    @Test
    public void pageQuery() {
    }

    @Test
    public void saveDraft() {
        TransferFormDTO formDTO = new TransferFormDTO();
        formDTO.setTransferCode("DB180825234946001011");
        formDTO.setGroupCode("JT00000008");
        formDTO.setReceiverCode("GS00000014");
        formDTO.setReceiverName("利群金狮广场店");

        List<TransferItemDTO> items = new ArrayList<>();

        TransferItemDTO itemDTO = new TransferItemDTO();
        itemDTO.setSapProductCode("PC180824200228001046_GS00000014");
        itemDTO.setNum(new BigDecimal(10));
        items.add(itemDTO);

        formDTO.setItems(items);

        transferFacade.saveDraft(formDTO);
    }

    @Test
    public void submit() {
        TransferFormDTO formDTO = new TransferFormDTO();
        formDTO.setTransferCode("DB180825234946001000");
        formDTO.setGroupCode("JT00000008");
        formDTO.setReceiverCode("GS00000014");
        formDTO.setReceiverName("利群金狮广场店");

        List<TransferItemDTO> items = new ArrayList<>();

        TransferItemDTO itemDTO = new TransferItemDTO();
        itemDTO.setSapProductCode("SAP180824200228001047");
        itemDTO.setNum(new BigDecimal(2));
        items.add(itemDTO);

        formDTO.setItems(items);

        transferFacade.submit(formDTO);
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
        TransferQueryDTO queryDTO = new TransferQueryDTO();
        queryDTO.setGroupCode("JT00000003");
        queryDTO.setTransferCode("DB180825224259001018");
        TransferDTO dto = transferFacade.get(queryDTO);
        System.out.println("---------------");
    }

    @Test
    public void queryExportData() {
    }

    @Test
    public void getImportData() {
    }

    @Test
    public void auditSuccess() {
        TransferFormDTO formDTO = new TransferFormDTO();
        formDTO.setTransferCode("PD180814150720001000");
        formDTO.setSenderCode("GS00000044");
        formDTO.setGroupCode("JT00000030");
        transferFacade.auditSuccess(formDTO);
    }

    @Test
    public void auditReject() {
        TransferFormDTO formDTO = new TransferFormDTO();
        formDTO.setTransferCode("DB180815203646001002");
        formDTO.setSenderCode("GS00000044");
        formDTO.setGroupCode("JT00000030");
        transferFacade.auditReject(formDTO);
    }
}