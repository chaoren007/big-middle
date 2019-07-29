package com.morning.star.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morning.star.retail.order.domain.entity.PaymentEntity;
import com.morning.star.retail.order.enums.PaymentStatus;

public interface OrderPaymentRepository extends JpaRepository<PaymentEntity, String> {
    PaymentEntity save(PaymentEntity paymentEntity);
    List<PaymentEntity>  getByOrderCodeAndPayStatus(String orderCode,PaymentStatus status);

    PaymentEntity getByPayCode(String payCode);


}
