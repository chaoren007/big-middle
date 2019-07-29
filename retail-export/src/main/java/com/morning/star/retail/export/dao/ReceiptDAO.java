package com.morning.star.retail.export.dao;

import com.morning.star.retail.export.dto.ReceiptInfoDTO;
import com.morning.star.retail.export.dto.ReceiptQueryDTO;

import java.util.List;

public interface ReceiptDAO {

    List<ReceiptInfoDTO> selectAll(ReceiptQueryDTO receiptQueryDTO);


}
