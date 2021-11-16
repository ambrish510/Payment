package com.upgrad.Payment.controller;

import com.upgrad.Payment.model.dto.TransactionDTO;
import com.upgrad.Payment.model.entity.TransactionDetailsEntity;
import com.upgrad.Payment.services.PaymentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    /*
    Call acceptPaymentDetails method to get the transaction id for the payment
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDetailsEntity> CreatePayment(@RequestBody TransactionDTO transactionDTO) {
        TransactionDetailsEntity newTransaction = modelMapper.map(transactionDTO, TransactionDetailsEntity.class);
        TransactionDetailsEntity savedTransaction = paymentService.acceptPaymentDetails(newTransaction);
        System.out.println(savedTransaction.toString());
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    /*
    To get the transaction details based on transaction id
     */
    @GetMapping(value = "/{transactionId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDetailsEntity> getPaymentDetailsById(@PathVariable int transactionId) {
        TransactionDetailsEntity responsePayment = paymentService.getPaymentDetails(transactionId);
        System.out.println(responsePayment.toString());
        return new ResponseEntity<>(responsePayment, HttpStatus.OK);

    }
}