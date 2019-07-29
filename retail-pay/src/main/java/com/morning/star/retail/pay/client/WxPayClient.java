package com.morning.star.retail.pay.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wxpay.sdk.WXPay;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.util.Json;

public class WxPayClient implements PayClient {
    private Logger log = LoggerFactory.getLogger(AliPayClient.class);
    private WXPay wxPay;
    
    public WxPayClient(WXPay wxPay) {
        this.wxPay = wxPay;
    }
    
    @Override
    public ScanPayTradeResult scanPay(ScanPay payOrder) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("auth_code", payOrder.getAuth_code());
            reqData.put("spbill_create_ip", payOrder.getDeviceIp());
            reqData.put("body", payOrder.getSubject());
            reqData.put("out_trade_no", payOrder.getOut_trade_no());
            reqData.put("total_fee", String.valueOf(payOrder.getTotal_amount().intValue()));
            reqData.put("time_expire", countExpireTime(payOrder.getPay_timeout()));
            reqData.put("device_info", payOrder.getTerminal_id());
            
            log.info("========== 微信支付返回参数 ： " + Json.toJson(reqData));
            Map<String, String> mapFromXML = wxPay.microPay(reqData);
            log.info("========== 微信支付返回参数 ： " + Json.toJson(mapFromXML));
            return getScanPayResultFrom(mapFromXML);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("scan pay", e);
            return ScanPayTradeResult.error();
        }
    }
    

    private ScanPayTradeResult getScanPayResultFrom(Map<String, String> mapFromXML) {
        String return_code = mapFromXML.get("return_code");
        if("FAIL".equals(return_code)) {
            return ScanPayTradeResult.fail();
        }
        
        String result_code = mapFromXML.get("result_code");
        if("SUCCESS".equals(result_code)) {
            ScanPayTradeResult result = ScanPayTradeResult.succ();
            result.setTotal_amount(new BigDecimal(mapFromXML.get("total_fee")));
            result.setTrade_no(mapFromXML.get("transaction_id"));
            result.setOut_trade_no(mapFromXML.get("out_trade_no"));
            return result;
        } else if("FAIL".equals(result_code)) {
            String err_code = mapFromXML.get("err_code");
            String err_code_des = mapFromXML.get("err_code_des");
            if("SYSTEMERROR".equals(err_code)) {
                return ScanPayTradeResult.error(err_code_des);
            } else if("BANKERROR".equals(err_code)) {
                return ScanPayTradeResult.error(err_code_des);
            } else if("USERPAYING".equals(err_code)) {
                return ScanPayTradeResult.waiting(err_code_des);
            }
            return ScanPayTradeResult.fail(err_code_des);
        }
        return ScanPayTradeResult.error();
    }


    @Override
    public ScanPayTradeResult queryPayResult(String out_trade_no) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("out_trade_no", out_trade_no);
            Map<String, String> mapFromXML = wxPay.orderQuery(reqData);
            log.info("========== 微信支付查询返回参数 ： " + Json.toJson(mapFromXML));
            return getScanPayQueryResultFrom(mapFromXML);
        } catch (Exception e) {
            log.error("query result", e);
            return ScanPayTradeResult.error();
        }
    }
    


    private ScanPayTradeResult getScanPayQueryResultFrom(Map<String, String> mapFromXML) {
        String return_code = mapFromXML.get("return_code");
        if("FAIL".equals(return_code)) {
            return ScanPayTradeResult.fail();
        }
        
        String result_code = mapFromXML.get("result_code");
        if("SUCCESS".equals(result_code)) {
            String trade_state = mapFromXML.get("trade_state");
            String trade_state_desc = mapFromXML.get("trade_state_desc");
            if("SUCCESS".equals(trade_state)) {
                ScanPayTradeResult result = ScanPayTradeResult.succ();
                result.setTotal_amount(new BigDecimal(mapFromXML.get("total_fee")));
                result.setTrade_no(mapFromXML.get("transaction_id"));
                result.setOut_trade_no(mapFromXML.get("out_trade_no"));
                return result;
            } else if("USERPAYING".equals(trade_state)) {
                return ScanPayTradeResult.waiting(trade_state_desc);
            } else {
                return ScanPayTradeResult.fail(trade_state_desc);
            }
        } else if("FAIL".equals(result_code)) {
            String err_code = mapFromXML.get("err_code");
            String err_code_des = mapFromXML.get("err_code_des");
            if("SYSTEMERROR".equals(err_code)) {
                return ScanPayTradeResult.error(err_code_des);
            } else if("BANKERROR".equals(err_code)) {
                return ScanPayTradeResult.error(err_code_des);
            } else if("USERPAYING".equals(err_code)) {
                return ScanPayTradeResult.waiting(err_code_des);
            }
            return ScanPayTradeResult.fail(err_code_des);
        }
        return ScanPayTradeResult.error();
    }
    
    @Override
    public ScanPayRefundResult cancelPay(String out_trade_no) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("out_trade_no", out_trade_no);
            Map<String, String> mapFromXML = wxPay.reverse(reqData);
            log.info("========== 微信支付撤消返回参数 ： " + Json.toJson(mapFromXML));
            return getScanPayCancelResultFrom(mapFromXML);
        } catch (Exception e) {
            log.error("query result", e);
            return ScanPayRefundResult.error();
        }
    }
    
    private ScanPayRefundResult getScanPayCancelResultFrom(Map<String, String> mapFromXML) {
        String return_code = mapFromXML.get("return_code");
        if("FAIL".equals(return_code)) {
            return ScanPayRefundResult.fail();
        }
        
        String result_code = mapFromXML.get("result_code");
        if("SUCCESS".equals(result_code)) {
            return ScanPayRefundResult.succ();
        } else if("FAIL".equals(result_code)) {
            String err_code = mapFromXML.get("err_code");
            String err_code_des = mapFromXML.get("err_code_des");
            if("SYSTEMERROR".equals(err_code)) {
                return ScanPayRefundResult.error(err_code_des);
            }
            return ScanPayRefundResult.fail(err_code_des);
        }
        return ScanPayRefundResult.error();
    }


    private String countExpireTime(String timeout) {
        int timeoutValue = Integer.valueOf(timeout.substring(0, timeout.length() - 1));
        if(timeout.endsWith("m")) {
            return DateUtil.toString(DateUtil.addMinute(new Date(), timeoutValue), "yyyyMMddHHmmss");
        } else if(timeout.endsWith("h")) {
            return DateUtil.toString(DateUtil.addHous(new Date(), timeoutValue), "yyyyMMddHHmmss");
        }
        return null;
    }

    
    public void chekScanPayParam(String companyCode, String authCode, String device_info, int totalFee, String outTradeNo,
            String body, String attach, String deviceIp, String goodsTag) {
        if (companyCode == null)
            throw new IllegalArgumentException("没有获取到公司编码");
        if (authCode == null)
            throw new IllegalArgumentException("没有获取到支付授权码");
        if (device_info == null)
            throw new IllegalArgumentException("没有获取到机器码");
        if (outTradeNo == null)
            throw new IllegalArgumentException("没有户获取到外部订单号");
        if (totalFee <= 0)
            throw new IllegalArgumentException("收款金额必须大于0");
        if (deviceIp == null)
            throw new IllegalArgumentException("没有获取到支付设备IP");
    }
    
//
//    @Override
//    public Map<String, Object> appPay(WeiXin weixin) {
//        checkParams(weixin);
//        
//        Map<String, Object> respMap = new HashMap<>();
//        WxPayKeyEntity key = wxPayDao.getWxPayKeyEntityByCompanyCode(weixin.getCompanyCode());
//        if (key == null)
//            throw RetailException.of(PayErrorCode.WX_PAY_COMPANY_IS_NONE,PayErrorCode.WX_PAY_COMPANY_IS_NONE.getErrorMsg());
//
//        return respMap;
//    }
//    
//    public void checkParams(WeiXin weixin){
//        if (StringUtil.isNullOrEmpty(weixin.getOut_trade_no()))
//            throw RetailException.of(PayErrorCode.ORDERNO_NOT_NULL,PayErrorCode.ORDERNO_NOT_NULL.getErrorMsg());
//
//        if (StringUtil.isNullOrEmpty(weixin.getNotify_url()))
//            throw RetailException.of(PayErrorCode.RETURNURL_NOT_NULL,PayErrorCode.RETURNURL_NOT_NULL.getErrorMsg());
//
//        if (StringUtil.isNullOrEmpty(weixin.getPayType()))
//            throw RetailException.of(PayErrorCode.PAYTYPE_NOT_NULL,PayErrorCode.PAYTYPE_NOT_NULL.getErrorMsg());
//
//        if (weixin.getTotal_fee() < 0)
//            throw RetailException.of(PayErrorCode.TOTAL_FEE_NOT_NULL,PayErrorCode.TOTAL_FEE_NOT_NULL.getErrorMsg());
//    }
}
