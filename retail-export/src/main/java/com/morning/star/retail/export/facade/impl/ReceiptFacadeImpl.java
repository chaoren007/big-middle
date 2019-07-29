package com.morning.star.retail.export.facade.impl;

import com.morning.star.retail.export.dao.ReceiptDAO;
import com.morning.star.retail.export.dto.ReceiptInfoDTO;
import com.morning.star.retail.export.dto.ReceiptQueryDTO;
import com.morning.star.retail.facade.ReceiptFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptFacadeImpl implements ReceiptFacade {

    @Autowired
    ReceiptDAO receiptDAO;

    @Override
    public List<ReceiptInfoDTO> queryOrder(ReceiptQueryDTO searchDTO) {
        return receiptDAO.selectAll(searchDTO);
    }
}
