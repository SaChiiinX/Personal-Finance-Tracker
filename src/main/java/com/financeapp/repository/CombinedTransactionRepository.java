package com.financeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financeapp.entity.CombinedTransaction;

public interface CombinedTransactionRepository extends JpaRepository<CombinedTransaction, Long> {
    
}
