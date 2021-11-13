package com.upgrad.Payment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class TransactionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Column
    private String paymentMode;

    @Column(nullable = false)
    private int bookingId;

    @Column
    private String upiId;

    @Column
    private String cardNumber;
}
