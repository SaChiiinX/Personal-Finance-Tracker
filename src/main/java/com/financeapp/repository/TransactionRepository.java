package com.financeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financeapp.entity.Transaction;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
