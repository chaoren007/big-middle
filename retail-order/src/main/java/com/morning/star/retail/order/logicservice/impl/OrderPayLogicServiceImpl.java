package com.morning.star.retail.order.logicservice.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.order.domain.entity.PaymentEntity;
import com.morning.star.retail.order.domain.entity.SalesOrderEntity;
import com.morning.star.retail.order.enums.PaymentStatus;
import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayFormDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.PayResultDTO;
import com.morning.star.retail.order.facade.dto.PosOrderPayResultDTO;
import com.morning.star.retail.order.helper.CompanyServiceHelper;
import com.morning.star.retail.order.helper.PayServiceHelper;
import com.morning.star.retail.order.helper.dto.PosOrderPayResult;
import com.morning.star.retail.order.logicservice.OrderPayLogicService;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.repository.OrderPaymentRepository;
import com.morning.star.retail.repository.OrderRepository;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.util.UniqueNoUtils;


@Service
public class OrderPayLogicServiceImpl implements OrderPayLogicService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CompanyServiceHelper companyServiceHelper;

    @Autowired
    private OrderPaymentRepository orderPaymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PayServiceHelper payServiceHelper;

    private Logger logger = LoggerFactory.getLogger(OrderPayLogicServiceImpl.class);

    @Transactional
    @Override
    public OfflineOrderPayResultDTO offlinePayForOrder(OfflineOrderPayFormDTO dto) {
        logger.info("========offlinePayForOrder====线下支付宝微信扫码支付====" + Json.toJson(dto));
        Validate.isTrue(dto.isCheckParamSucc(), "支付参数异常!");

        //检查订单状态
        SalesOrderEntity salesOrder = orderRepository.getByOrderCode(dto.getOrderCode());
        // Validate.isTrue(dto.getPaid().compareTo(salesOrder.getTotalAmount()) < 0, "支付金额大于支付的订单金额");
        Validate.notNull(salesOrder, "支付的订单不存在!");
        Validate.isTrue(salesOrder.getOrderStatus().equals(SalesOrderStatus.WAIT_PAY), "该订单已支付完成");

        //商户号
        String merchantCode = companyServiceHelper.getPayMerchantCode(salesOrder.getDepartment().getGroupCode());
        //支付金额
        BigDecimal payAmount = dto.getPaid().multiply(BigDecimal.valueOf(100));
        //
        String payBillCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PAY);


        ScanPay scanPay = new ScanPay();
        scanPay.setMerchantCode(merchantCode);                    //商户号
        scanPay.setTerminal_id(dto.getTerminalCode());            //设备号
        scanPay.setAuth_code(dto.getAuthCode());                //授权码
        scanPay.setOrderCode(dto.getOrderCode());                //订单号
        scanPay.setSubject(salesOrder.getOrderCode());

        scanPay.setTotal_amount(payAmount);                        //支付金额
        scanPay.setDeviceIp(dto.getTerminalHost());                //设备IP
        scanPay.setPay_start_time(getTimeAfterMinutes(0));        //开始支付时间
        scanPay.setPay_timeout(getTimeAfterMinutes(30));        //支付超时时间
        scanPay.setOut_trade_no(payBillCode);                    //随机字符串  (关联支付跟支付单的键)
        logger.info("========scanPay========" + Json.toJson(scanPay));

        PosOrderPayResult result = payServiceHelper.offlineScanPay(scanPay);
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPayCode(payBillCode);
        paymentEntity.setOrderCode(dto.getOrderCode());
        paymentEntity.setPayAmount(dto.getPaid());
        paymentEntity.setPayChannel(result.getPayChannel());
        paymentEntity.setPayTime(new Date());
        paymentEntity.setPayTradeNo(result.getTrade_no());
        if (result.isSucc()) {
            //保存支付记录
            paymentEntity.setPayStatus(PaymentStatus.PAY_SUCC);
        } else if (result.isFail()) {
            //保存支付记录
            paymentEntity.setPayStatus(PaymentStatus.PAY_FAIL);
            //orderService.updateOrderPayment(order, "线下支付失败");
        }
        orderPaymentRepository.save(paymentEntity);
        OfflineOrderPayResultDTO ret = new OfflineOrderPayResultDTO();
        ret.setStatus(paymentEntity.getPayStatus().getCode());
        ret.setMsg(result.getMsg());
        ret.setTradeNo(result.getTrade_no());
        ret.setTotalAmount(result.getTotal_amount());
        ret.setOrderCode(paymentEntity.getOrderCode());
        return ret;
    }

    @Override
    public PosOrderPayResultDTO getOfflineScanPayResult(String orderCode) {
        //检查订单状态
        SalesOrderEntity salesOrder = orderRepository.getByOrderCode(orderCode);
        Validate.notNull(salesOrder, "查询的订单不存在");
        //统计已支付和未支付
        PosOrderPayResultDTO ret = new PosOrderPayResultDTO();
        List<PaymentEntity> byOrderCodeAndPayStatus = orderPaymentRepository.getByOrderCodeAndPayStatus(orderCode, PaymentStatus.PAY_SUCC);
        if (byOrderCodeAndPayStatus != null && byOrderCodeAndPayStatus.size() > 0) {
            BigDecimal totlePaid = BigDecimal.ZERO;
            List<PayResultDTO> list = new ArrayList<>();
            for (PaymentEntity entity : byOrderCodeAndPayStatus) {
                PayResultDTO dto = new PayResultDTO();
                totlePaid = totlePaid.add(entity.getPayAmount());
                dto.setChannel(entity.getPayChannel().getCode());
                dto.setChannelDesc(entity.getPayChannel().getDesc());
                dto.setStatus(entity.getPayStatus().getCode());
                dto.setTotalAmount(entity.getPayAmount());
                dto.setTradeNo(entity.getPayTradeNo());
                list.add(dto);
            }
            ret.setPaid(totlePaid);
            ret.setOrderCode(orderCode);
            ret.setPayResultDTOS(list);
            //如果支付完成，修改订单为已支付
            if (totlePaid.compareTo(salesOrder.getTotalAmount()) >= 0) {
                salesOrder.setOrderStatus(SalesOrderStatus.PAYED);
                orderRepository.save(salesOrder);
            }
        }
        return ret;
    }

    /**
     * 获取多少分钟后的时间
     *
     * @param mins
     * @return
     */
    private String getTimeAfterMinutes(Integer mins) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date().getTime() + (mins == null ? 0 : mins * 60 * 1000));
    }
}
