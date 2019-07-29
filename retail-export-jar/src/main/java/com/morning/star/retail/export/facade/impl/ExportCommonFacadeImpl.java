package com.morning.star.retail.export.facade.impl;

import com.morning.star.retail.dao.ExportRecordDAO;
import com.morning.star.retail.export.annotation.ComponentExport;
import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.ExportRecordDTO;
import com.morning.star.retail.export.dto.UserInfoDTO;
import com.morning.star.retail.export.facade.ExportCommonFacade;
import com.morning.star.retail.export.mq.MqMessageSender;
import com.morning.star.retail.export.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kimhuhg
 * @Date: 18-11-9 下午2:38
 * @desc: 导出公共类
 */
@Service
public class ExportCommonFacadeImpl implements ExportCommonFacade {
    private static Logger logger = LoggerFactory.getLogger(ExportCommonFacadeImpl.class);
    @Autowired
    ExportRecordDAO exportRecordDAO;
    @Autowired
    MqMessageSender mqMessageSender;

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public void export(ExportMqDTO command) {
        try {
            ExportRecordDTO dto = new ExportRecordDTO();
            UserInfoDTO user = command.getUserCommand();

            if (user != null) {
                dto.setUsername(user.getUserName());
                dto.setUserId(user.getUserId());
                dto.setGroupCode(user.getGroupCode());
                dto.setStoreCode(user.getStoreCode());
                if (command.getItem() != null) {
                    dto.setQueryStr(command.getItem().toString());
                }
                dto.setStatus(0);
                dto.setType(command.getType());
                exportRecordDAO.add(dto);
                command.setId(dto.getId());
                logger.info("保存id："+dto.getId());
                if (dto.getId() != null) {
                    mqMessageSender.send(command, appName + "-export");
                } else {
                    throw new IllegalArgumentException("导出新增记录失败！");
                }
            } else {
                throw new IllegalArgumentException("获取失败，用户信息不能为空！");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("导出新增记录出现异常！", e);
        }

    }

    @Override
    public Map<String, String> getExportBean() {
        Map<String, String> map = new HashMap<>();
        Map<String, Object> beanMap = SpringUtil.getBeanByAnnotation();
//        Class<? extends Object> clazz = null;
        for(Map.Entry<String, Object> entry : beanMap.entrySet()){
            Class<? extends Object> clazz = entry.getValue().getClass();
            ComponentExport componentExport = clazz.getAnnotation(ComponentExport.class);
            map.put(componentExport.name(), componentExport.value());
        }
        return map;
    }
}
