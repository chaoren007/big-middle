package com.morning.star.retail.export.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morning.star.retail.export.annotation.ComponentExport;
import com.morning.star.retail.export.dao.ReceiptDAO;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.ReceiptInfoDTO;
import com.morning.star.retail.export.dto.ReceiptQueryDTO;
import com.morning.star.retail.export.listener.ExportListener;
import com.morning.star.retail.export.util.ExportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: kimhuhg
 * @Date: 18-11-13 上午11:26
 * @desc: 入库导出
 */
@ComponentExport(value = "ReceiptExportBean", name = "入库导出")
//@Component(value = "ReceiptExportBean")
public class ReceiptExportBean implements ExportCommon {
    private static Logger logger = LoggerFactory.getLogger(ExportListener.class);

    @Autowired
    ExportUtil exportUtil;

    @Autowired
    ReceiptDAO receiptDAO;

    public ObjectMapper om;

    @Override
    public String export(ExportMqDTO command) {
        ReceiptQueryDTO req = new  ReceiptQueryDTO();
        if (command.getItem() != null) {
            req = om.convertValue(command.getItem(), ReceiptQueryDTO.class);
        }
        req.setPageNo(1);
        req.setPageSize(Integer.MAX_VALUE);
//        PageBean<ReceiptDTO> page = receiptFacade.queryOrder(req);
        List<ReceiptInfoDTO> list = receiptDAO.selectAll(req);
//        List<ReceiptDTO> list = page.getRecord();
        logger.info("导出查询结果:"+list);
        return exportUtil.export(ReceiptInfoDTO.class, list, "入库列表导出");
    }
}
