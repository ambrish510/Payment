package com.upgrad.Payment.services;

import com.upgrad.Payment.dao.TransactionDao;
import com.upgrad.Payment.exception.TransactionNotFoundException;
import com.upgrad.Payment.model.entity.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    TransactionDao transactionDao;

    @Override
    public TransactionDetailsEntity acceptPaymentDetails(TransactionDetailsEntity payment) {
        return transactionDao.save(payment);
    }

    @Override
    public List<TransactionDetailsEntity> acceptMultiplePaymentDetails(List<TransactionDetailsEntity> payments) {
        List<TransactionDetailsEntity> savedPayment = new ArrayList<>();
        for (TransactionDetailsEntity payment : payments) {
            savedPayment.add(acceptPaymentDetails(payment));
        }
        return savedPayment;
    }

    @Override
    public TransactionDetailsEntity getPaymentDetails(int id) {
        return transactionDao.findById(id).orElseThrow(() -> new TransactionNotFoundException("Invalid Transaction Id"));
    }

    @Override
    public TransactionDetailsEntity updatePaymentDetails(int id, TransactionDetailsEntity payment) {
        TransactionDetailsEntity savedPayment = getPaymentDetails(id);
        savedPayment.setPaymentMode(payment.getPaymentMode());
        savedPayment.setBookingId(payment.getBookingId());
        savedPayment.setUpiId(payment.getUpiId());
        savedPayment.setCardNumber(payment.getCardNumber());
        transactionDao.save(savedPayment);
        return savedPayment;
    }

    @Override
    public boolean deletePayment(int id) {
        TransactionDetailsEntity savedPayment = getPaymentDetails(id);

        if (savedPayment == null) {
            return false;
        }

        transactionDao.delete(savedPayment);
        return true;
    }

    @Override
    public List<TransactionDetailsEntity> getAllPayments() {
        return transactionDao.findAll();
    }

    @Override
    public Page<TransactionDetailsEntity> getPaginatedPaymentDetails(Pageable pageable) {
        return transactionDao.findAll(pageable);
    }
}