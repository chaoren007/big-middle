package com.morning.star.retail.export.bean;

import com.morning.star.retail.export.dto.ExportMqDTO;

/**
 * @Author: kimhuhg
 * @Date: 18-11-9 下午3:30
 * @desc: 导出bean实现接口
 */
public interface ExportCommon {
    /**
     * 统一实现这个方法用于反射调用
     * @param command
     * @return
     */
    String export(ExportMqDTO command);
}
