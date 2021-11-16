package com.upgrad.Payment.services;

import com.upgrad.Payment.model.entity.TransactionDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    TransactionDetailsEntity acceptPaymentDetails(TransactionDetailsEntity payment);

    List<TransactionDetailsEntity> acceptMultiplePaymentDetails(List<TransactionDetailsEntity> payments);

    TransactionDetailsEntity getPaymentDetails(int id);

    TransactionDetailsEntity updatePaymentDetails(int id, TransactionDetailsEntity payments);

    boolean deletePayment(int id);

    List<TransactionDetailsEntity> getAllPayments();

    Page<TransactionDetailsEntity> getPaginatedPaymentDetails(Pageable pageable);
}
