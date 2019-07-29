package com.morning.star.retail.pay.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.DefaultAlipayClient;
import com.github.wxpay.sdk.WXPay;
import com.morning.star.retail.pay.client.AliPayClient;
import com.morning.star.retail.pay.client.PayClient;
import com.morning.star.retail.pay.client.WxPayClient;
import com.morning.star.retail.pay.dao.AlipayPayDao;
import com.morning.star.retail.pay.dao.WxPayDao;
import com.morning.star.retail.pay.entity.AlipayKeyEntity;
import com.morning.star.retail.pay.entity.WxPayKeyEntity;
import com.morning.star.retail.pay.enums.PayChannel;

@Service
public class PayClientServiceImpl implements PayClientService {

    @Autowired private AlipayPayDao alipayPayDao;
    @Autowired private WxPayDao wxPayDao;
    @Autowired private PayCertService payCertService;
    
    
    @Override
    public PayClient createPayClient(PayChannel payChannel, int ownerId) {
        if(payChannel == PayChannel.ALI_SCAN) {
            return createAliPayClient(ownerId);
        } else if(payChannel == PayChannel.WX_SCAN) {
            return createWxPayClient(ownerId);
        }
        throw new RuntimeException("该公司还未接入支付");
    }
    
    
    private AliPayClient createAliPayClient(int ownerId) {
        AlipayKeyEntity key = alipayPayDao.getAlipayKey(ownerId);
        if (key == null) {
            throw new IllegalArgumentException("未接入支付宝支付");
        }
        DefaultAlipayClient alipayClient = new DefaultAlipayClient(key.getGateway(), key.getAppID(), key.getPrivateKey(), "json", "UTF-8",
                key.getPublicKey(), "RSA2");
        
        return new AliPayClient(alipayClient);
    }
    
    private WxPayClient createWxPayClient(int ownerId) {
        WxPayKeyEntity key = wxPayDao.getWxPayKey(ownerId);
        if (key == null) {
            throw new RuntimeException("该公司还未接入微信支付");
        }
        
        if(StringUtils.isBlank(key.getCertLocalPath())) {
            throw new RuntimeException("没有配置证书");
        }
        byte[] cert = payCertService.getCert(key.getCertLocalPath());
        if(cert == null) {
            throw new RuntimeException("证书未找到");
        }
        key.setCertData(cert);
        
        return new WxPayClient(new WXPay(key));
    }

}
