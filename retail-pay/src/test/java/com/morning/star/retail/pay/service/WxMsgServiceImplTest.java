package com.morning.star.retail.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.msg.dto.WxMsg;
import com.morning.star.retail.msg.dto.WxMsgResponse;
import com.morning.star.retail.msg.dto.WxOrderPayMsg;
import com.morning.star.retail.msg.dto.WxRefundMsg;
import com.morning.star.retail.msg.service.WxMsgService;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by lenovo on 2017/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/dubbo-provider.xml"})
public class WxMsgServiceImplTest {

    @Autowired
    private WxMsgService wxMsgService;

    @Test
    public void sendWxTemplateMsg() {
        long userId = 0;
        String templateName = "";
        WxMsg wxMsg;
        if (StringUtils.isEmpty(templateName) || WxOrderPayMsg.class.getSimpleName().equalsIgnoreCase(templateName)) {
            wxMsg = new WxOrderPayMsg("您的订单支付成功。", "123456789012", "宫保鸡丁，酸汤肥牛",
                    "48元", new Date(), "菜品预计半小时内送达，请注意查收。谢谢。");
        } else {
            wxMsg = new WxRefundMsg("您好，您的订单1002 已退款成功。再次欢迎您的光临。",
                    "示例餐厅", "1002", "外卖", "订单金额：100.00元");
        }
        WxMsgResponse response = wxMsgService.sendTemplateMsg(userId, wxMsg, "http://www.baidu.com");
        System.out.println(JSONObject.toJSONString(response));
    }
}
