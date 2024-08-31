package com.financeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.*;

import com.financeapp.entity.Transaction;
import com.financeapp.entity.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("from Transaction where accountId = :accountId")
    List<Transaction> getAllTransactionsByAccount(@Param("accountId") Long accountId);

    @Query("from Transaction where amount > :min")
    List<Transaction> getAllTransactionsByMin(@Param("min") Double min);

    @Query("from Transaction where amount > :max")
    List<Transaction> getAllTransactionsByMax(@Param("max") Double max);

    @Query("from Transaction where amount > :min and amount < :max")
    List<Transaction> getAllTransactionsByMoneyRange(@Param("min") Double min, @Param("max") Double max);

    @Query("from Transaction where transactionType = :transactionType")
    List<Transaction> getAllTransactionsByType(@Param("transactoinType") TransactionType transactionType);

    @Query("from Transaction where category in :categories")
    List<Transaction> getAllTransactionsByCategory(@Param("categories") List<String> categories);

    @Query("from Transaction where transactionDate between :startDate and :endDate")
    List<Transaction> getAllTransactionsByDate(@Param("startDate") LocalDate startDate, 
                                               @Param("endDate") LocalDate endDate);

    @Query("update Transaction" +
           "set amount =  :amount," +  
           "transactionType = :transactionType," +
           "category = :category," +
           "transactionDate = :transactionDate" +
           "details = :details" +
           "where transactoinId = :transactoinId")
    Transaction updateTransaction(@Param("transactionId") Long transactionId,
                                  @Param("amount") Double amount,
                                  @Param("transactionType") TransactionType transactionType,
                                  @Param("category") String category,
                                  @Param("transactionDate") LocalDate transactionDate,
                                  @Param("details") String details);
}
