package com.morning.star.retail.pay.service;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.morning.star.retail.exception.BizException;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.client.OfflinePayClient;
import com.morning.star.retail.pay.dao.RefundDAO;
import com.morning.star.retail.pay.dao.ScanPayDAO;
import com.morning.star.retail.pay.entity.ScanPayPO;
import com.morning.star.retail.pay.entity.ScanRefund;
import com.morning.star.retail.pay.enums.RefundStatus;
import com.morning.star.retail.pay.enums.ScanPayStatus;
import com.morning.star.retail.util.Json;

@Service
public class ScanPayServiceImpl implements ScanPayService {

    private static final Logger logger = LoggerFactory.getLogger(ScanPayServiceImpl.class);

    @Autowired
    private PayClientService payClientService;
    @Autowired
    private ScanPayDAO scanDAO;
    @Autowired
    private RefundDAO refundDAO;
    @Value("${offline.pay.url}")
    private String offline_pay_url;

    /**
     * 聚合支付扫码支付
     */
    @Override
    public ScanPayTradeResult offlineScanPay(ScanPay scanPay) {

        try {
            ScanPayPO po = scanDAO.get(scanPay.getOut_trade_no());
            if (po != null) {
                throw new IllegalArgumentException("不能重复支付");
            }
            po = ScanPayPO.from(scanPay);
            scanDAO.save(po);
            ScanPayTradeResult result = OfflinePayClient
                    .createPayClient()
                    .payBill(offline_pay_url, scanPay);
            //只付失败或者支付中立马调用查询接口查询
            if (result.getCode().equals(ScanPayStatus.WAITING) || result.getCode().equals(ScanPayStatus.FAIL)) {
                ScanPayTradeResult queryResult = OfflinePayClient
                        .createPayClient()
                        .queryPayBill(offline_pay_query_url, scanPay.getMerchantCode(), scanPay.getOut_trade_no());
                result.setCode(queryResult.getCode());
                result.setMsg(queryResult.getMsg());
                result.setOut_trade_no(queryResult.getOut_trade_no());
                result.setPayChannel(queryResult.getPayChannel());
                result.setTotal_amount(scanPay.getTotal_amount());
                result.setTrade_no(queryResult.getTrade_no());
            }
            if (isFinalStatus(result.getCode())) {
                updateStatus(po, result);
                ScanPayTradeResult createScanPayTradeResult = po.createScanPayTradeResult();
                return createScanPayTradeResult;
            }
            return result;

        } catch (Exception e) {
            logger.info("offlineScanPay.Exception=======" + Json.toJson(e));
            if (e instanceof BizException) {
                throw (BizException)e;
            } else {
                throw new RuntimeException("未知异常", e);
            }
        }
    }


    @Value("${offline.pay.query.url}")
    private String offline_pay_query_url;

    /**
     * 查询聚合支付的结果
     */
    @Override
    public ScanPayTradeResult getOfflineScanPayResult(String merchantCode, String payBillCode) {
        logger.info("getOfflineScanPayResult.merchantCode.payBillCode=======" + merchantCode + ":" + payBillCode);
        try {
            ScanPayPO po = scanDAO.get(payBillCode);
            logger.info("getOfflineScanPayResult.ScanPayPO=======" + Json.toJson(po));
            if (po == null) {
                return ScanPayTradeResult.fail("未请求支付");
            }
            if (isFinalStatus(po.getStatus())) {
                return po.createScanPayTradeResult();
            }
            ScanPayTradeResult result = OfflinePayClient
                    .createPayClient()
                    .queryPayBill(offline_pay_query_url, merchantCode, payBillCode);
            logger.info("getOfflineScanPayResult.ScanPayTradeResult=======" + Json.toJson(po));
            if (isFinalStatus(result.getCode())) {
                updateStatus(po, result);
                return po.createScanPayTradeResult();
            }
            return result;

        } catch (Exception e) {
            logger.info("getOfflineScanPayResult.Exception=======" + Json.toJson(e));
            if (e instanceof BizException) {
            	throw (BizException)e;
            } else {
                throw new RuntimeException("未知异常", e);
            }
        }
    }


    @Value("${offline.pay.revoke.url}")
    private String offline_pay_revoke_url;
    @Value("${offline.pay.refund.url}")
    private String offline_pay_refund_url;

    /**
     * 聚合支付退款
     */
    @Override
    public ScanPayRefundResult offlineRefundScanPayBill(String payBillCode, String refundCode,
                                                        BigDecimal refundAmount) {
        logger.info("offlineRefundScanPayBill=======" + payBillCode + ":" + refundCode + ":" + refundAmount);
        try {
            ScanPayPO po = scanDAO.get(payBillCode);
            logger.info("offlineRefundScanPayBill.ScanPayPO=======" + Json.toJson(po));
            if (po == null) {
                return ScanPayRefundResult.fail("原支付单不存在");
            }
            if (!po.getStatus().equals(ScanPayStatus.SUCC)) {
                return ScanPayRefundResult.fail("原支付单未支付");
            }
            ScanRefund refund = refundDAO.getRefund(refundCode);
            if (refund != null && refund.getStatus().equals("SUCC")) {        //退款成功
                return ScanPayRefundResult.fail("该退款单已退款");
            }
            if (refund != null && !refund.getStatus().equals("SUCC")) {        //未退款成功的订单可以重复退款
                if (refund.getRefundAmount().intValue() != refundAmount.intValue()) {        //失败的退款跟现在的退款金额不一致
                    return ScanPayRefundResult.fail("退款的金额与原退款金额不符");
                }
            }
            String remark = "";
            if (refund != null) {        //复用原失败退款
                refund.setStatus(RefundStatus.REFUNDING);
                refund.setTransactionId(null);
                remark = remark + "(失败后重新发起)";
                refund.setModifyTime(new Date());
                refundDAO.updateRefund(refund, refund.getCode());
            } else {        //新的退款
                refund = new ScanRefund();
                refund.setCode(refundCode);
                refund.setCreateTime(new Date());
                refund.setMerchantCode(po.getMerchantCode());
                refund.setModifyTime(new Date());
                refund.setOrderCode(po.getOrderCode());
                refund.setPayBillCode(po.getOutTradeNo());
                refund.setRefundAmount(refundAmount);
                refund.setRefundChannel(po.getPayChannel());
                refund.setStatus(RefundStatus.REFUNDING);
                refundDAO.saveRefund(refund);
            }

            ScanPayRefundResult result = null;
            //支付金额等于原支付单金额  并且是五分钟以内走撤销
            if (po.getTotalAmount().intValue() == refundAmount.multiply(new BigDecimal("100")).intValue()
                    && new Date(po.getCreateTime().getTime() + 5 * 60 * 1000).compareTo(new Date()) > 0) {
                refund.setType("REVOKE");
                refund.setRemark(remark + "五分钟内全额退款走支付撤销");
                result = OfflinePayClient.createPayClient()
                        .revokePayBill(offline_pay_revoke_url, po.getMerchantCode(), payBillCode);
            } else {    //其他情况走退款
                refund.setType("REFUND");
                refund.setRemark(remark + "五分钟后走支付退款流程");
                result = OfflinePayClient.createPayClient().refund(offline_pay_refund_url, po, refund);
            }
            refund.setStatus(result.getCode());
            refund.setTransactionId(result.getTransactionId());
            refundDAO.updateRefund(refund, refund.getCode());
            return result;
        } catch (Exception e) {
            logger.info("getOfflineScanPayResult.Exception=======" + Json.toJson(e));
            if (e instanceof BizException) {
            	throw (BizException)e;
            } else {
                throw new IllegalArgumentException("未知异常", e);
            }
        }
    }

    private boolean isFinalStatus(String status) {
        return ScanPayStatus.SUCC.equals(status) || ScanPayStatus.FAIL.equals(status);
    }

    private void updateStatus(ScanPayPO po, ScanPayTradeResult result) {
        if (ScanPayStatus.SUCC.equals(result.getCode())) {
            po.setStatus(ScanPayStatus.SUCC);
            po.setDesc(result.getMsg());
            po.setTradeNo(result.getTrade_no());
            po.setModifyTime(new Date());
            if (result.getPayChannel() != null) {
                po.setPayChannel(result.getPayChannel().getCode());
            }
            scanDAO.update(po);
        } else if (ScanPayStatus.FAIL.equals(result.getCode())) {
            po.setStatus(ScanPayStatus.FAIL);
            po.setDesc(result.getMsg());
            po.setModifyTime(new Date());
            scanDAO.update(po);
        }
    }

}
