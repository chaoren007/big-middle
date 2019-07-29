package com.morning.star.retail;

import com.morning.star.retail.export.dto.ExportMqDTO;
import com.morning.star.retail.export.dto.UserInfoDTO;
import com.morning.star.retail.export.facade.ExportCommonFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportApplicationTests {
    @Autowired
    ExportCommonFacade exportCommonFacade;

    @Test
    public void export() {
        ExportMqDTO exportMqDTO = new ExportMqDTO();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setGroupCode("haha");
        userInfoDTO.setStoreCode("test");
        userInfoDTO.setUserId(Long.valueOf(1));
        userInfoDTO.setUserName("测试");
        exportMqDTO.setUserCommand(userInfoDTO);
        exportMqDTO.setType("ReceiptExportBean");
        exportCommonFacade.export(exportMqDTO);
    }

}
