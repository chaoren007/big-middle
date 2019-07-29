package com.morning.star.retail.admin.controller.refund;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.WebBean;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/god")
public class RefundController {

    @ApiOperation(value = "")
    @RequestMapping(value = "/refunds", method = RequestMethod.POST)
    public WebBean<Void> test() {
        //TODO 刘越群
        //只是不让前端报错，暂时添加这个接口
        return WebBean.ok();
    }
}
