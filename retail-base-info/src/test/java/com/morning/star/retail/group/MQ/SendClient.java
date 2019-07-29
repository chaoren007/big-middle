package com.morning.star.retail.group.MQ;

import com.morning.star.retail.Main;
import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.facade.dto.TaxKdDTO;
import com.morning.star.retail.helper.MqHelperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Main.class)
public class SendClient {
    @Autowired
    private MqHelperService mqHelperService;
    @Autowired
    private RabbitConfig rabbitConfig;

    @Test
    public void Test0(){
        //对接WMS
        TaxKdDTO dto = new TaxKdDTO("测试税率",1,"2018-12-24","2018-12-25","1");
        //发送新建仓库MQ
        mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateTaxRate(), dto);
    }
}
