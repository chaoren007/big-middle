package com.morning.star.retail.stock.export;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morning.star.retail.export.annotation.ComponentExport;
import com.morning.star.retail.export.bean.ExportCommon;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.listener.ExportListener;
import com.morning.star.retail.export.util.ExportUtil;
import com.morning.star.retail.facade.ReceiptFacade;
import com.morning.star.retail.stock.dto.ReceiptDTO;
import com.morning.star.retail.stock.dto.ReceiptQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
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
public class ReceiptExportBean implements ExportCommon {
    private static Logger logger = LoggerFactory.getLogger(ExportListener.class);

    @Autowired
    ExportUtil exportUtil;

    @Autowired
    ReceiptFacade receiptFacade;

    public ObjectMapper om;

    @Override
    public String export(ExportMqDTO command) {
        ReceiptQueryDTO req = new  ReceiptQueryDTO();
        if (command.getItem() != null) {
            req = om.convertValue(command.getItem(), ReceiptQueryDTO.class);
        }
        req.setPageNo(1);
        req.setPageSize(Integer.MAX_VALUE);
        PageBean<ReceiptDTO> page = receiptFacade.list(req);
        List<ReceiptDTO> list = page.getRecord();
        logger.info("导出查询结果:"+list);
        return exportUtil.export(ReceiptDTO.class, list, "入库列表导出");
    }
}
