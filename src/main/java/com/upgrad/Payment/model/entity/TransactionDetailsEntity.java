package com.upgrad.Payment.model.entity;

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

    @Override
    public String toString() {
        return "TransactionDetailsEntity{" +
                "transactionId=" + transactionId +
                ", paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
