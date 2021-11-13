package com.upgrad.Payment.controller;

import com.upgrad.Payment.dto.TransactionDTO;
import com.upgrad.Payment.entities.TransactionDetailsEntity;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDTO> CreatePayment(@RequestBody TransactionDTO transactionDTO) {
        TransactionDetailsEntity newTransaction = modelMapper.map(transactionDTO, TransactionDetailsEntity.class);
        TransactionDetailsEntity savedTransaction = paymentService.acceptPaymentDetails(newTransaction);
        TransactionDTO SavedTransactionDTO = modelMapper.map(savedTransaction, TransactionDTO.class);
        return new ResponseEntity<>(SavedTransactionDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{transactionId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDTO> getPaymentDetailsById(@PathVariable int transactionId) {
        TransactionDetailsEntity responsePayment = paymentService.getPaymentDetails(transactionId);
        TransactionDTO responsePaymentDTO = modelMapper.map(responsePayment, TransactionDTO.class);
        return new ResponseEntity<>(responsePaymentDTO, HttpStatus.OK);

    }
}