package com.financeapp.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private Long accountId;
    private Double amount;
    private TransactionType transactionType;
    private String category;
    private LocalDate transactionDate;
    private String details;

    public Transaction(Long accountId, Double amount, TransactionType transactionType, String category,  String details){
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.category = category;
        this.transactionDate = LocalDate.now();
        this.details = details;
    }

    public Transaction(Long accountId, Double amount, TransactionType transactionType, String category, LocalDate transactionDate,  String details){
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.category = category;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public Transaction(Long transactionId, Long accountId, Double amount, TransactionType transactionType, String category, LocalDate transactionDate){
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.category = category;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public TransactionType getTransactionType() { return transactionType; }
    public void setTransactionType(TransactionType transactionType) { this.transactionType = transactionType; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

        Transaction other = (Transaction) obj;

        if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;

        if (accountId == null){
            if(other.accountId != null)
                return false;
        }else if(!accountId.equals(other.accountId))
            return false;

        if (amount == null){
            if(other.amount != null)
                return false;
        }else if(!amount.equals(other.amount))
            return false;

        if (transactionType == null){
            if(other.transactionType != null)
                return false;
        }else if(!transactionType.equals(other.transactionType))
            return false;

        if (category == null){
            if(other.category != null)
                return false;
        }else if(!category.equals(other.category))
            return false;

        if (transactionDate == null){
            if(other.transactionDate != null)
                return false;
        }else if(!transactionDate.equals(other.transactionDate))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "Transaction{" +
                "transactionId='" + transactionId +
                ", accountId='" + accountId +
                ", amount='" + amount + 
                ", transactionType='" + transactionType +
                ", category='" + category + 
                ", transactionDate='" + transactionDate.toString() +  '\'' +
                '}';
    }

}
