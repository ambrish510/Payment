package com.upgrad.Payment.dao;

import com.upgrad.Payment.model.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<TransactionDetailsEntity, Integer> {
}
