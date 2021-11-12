package com.upgrad.Payment.services;

import com.upgrad.Payment.entities.TransactionDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    public TransactionDetailsEntity acceptPaymentDetails(TransactionDetailsEntity payment);

    public List<TransactionDetailsEntity> acceptMultiplePaymentDetails(List<TransactionDetailsEntity> payments);

    public TransactionDetailsEntity getPaymentDetails(int id);

    public TransactionDetailsEntity updatePaymentDetails(int id , TransactionDetailsEntity payments);

    public boolean deletePayment(int id);

    public List<TransactionDetailsEntity> getAllPayments();

    public Page<TransactionDetailsEntity> getPaginatedPaymentDeatails(Pageable pageable);
}
