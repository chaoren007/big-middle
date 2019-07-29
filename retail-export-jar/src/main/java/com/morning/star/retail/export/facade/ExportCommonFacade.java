package com.morning.star.retail.export.facade;

import com.morning.star.retail.export.dto.ExportMqDTO;

import java.util.Map;

/**
 * @Author: kimhuhg
 * @Date: 18-11-9 下午2:29
 * @desc: 导出公共类
 */
public interface ExportCommonFacade {
    void export(ExportMqDTO command);
    Map<String, String> getExportBean();
}
